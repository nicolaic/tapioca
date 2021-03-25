/*
 * Copyright 2021 Nicolai Christophersen
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.nicolai.tapioca

const val BASE_MODS: Int = 0x0000
const val MOD_SHIFT: Int = 0x0001
const val MOD_CTRL: Int = 0x0002
const val MOD_ALT: Int = 0x0004
const val MOD_SUPER: Int = 0x0008

/**
 * The pressed state of some standard keyboard modifier keys.
 *
 * This class is a representation of the pressed state of the `shift`, `ctrl`,
 * `alt`/`option`, and `super` modifier keys, which are present on most keyboards.
 * This can be used to describe the current or desired state of the keys.
 */
class ModifierKeys private constructor(
    private val modifiers: Int
) {
    /**
     * The shift modifier pressed state.
     */
    val shift: Boolean get() = modifiers and MOD_SHIFT != 0

    /**
     * The ctrl modifier pressed state.
     */
    val ctrl: Boolean get() = modifiers and MOD_CTRL != 0

    /**
     * The alt or option modifier pressed state.
     */
    val alt: Boolean get() = modifiers and MOD_ALT != 0

    /**
     * The super modifier pressed state.
     */
    val sup: Boolean get() = modifiers and MOD_SUPER != 0

    // Destructuring support
    operator fun component1() = shift
    operator fun component2() = ctrl
    operator fun component3() = alt
    operator fun component4() = sup

    companion object {

        /**
         * A modifier key set with no keys pressed.
         */
        val none = ModifierKeys(BASE_MODS)

        fun from(
            shift: Boolean = false,
            ctrl: Boolean = false,
            alt: Boolean = false,
            sup: Boolean = false
        ): ModifierKeys {
            var modifiers = BASE_MODS

            if (shift) modifiers = modifiers or MOD_SHIFT
            if (ctrl) modifiers = modifiers or MOD_CTRL
            if (alt) modifiers = modifiers or MOD_ALT
            if (sup) modifiers = modifiers or MOD_SUPER

            return ModifierKeys(modifiers)
        }

        fun fromBitmap(modifiers: Int) = ModifierKeys(modifiers)
    }

    override fun equals(other: Any?) =
        other is ModifierKeys && modifiers == other.modifiers

    override fun hashCode() = modifiers
}