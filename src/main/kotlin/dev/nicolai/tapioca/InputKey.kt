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

/**
 * A user input, such as a keyboard key or a mouse button.
 */
interface InputKey {

    /**
     * A displayable representation of this interaction.
     */
    val representation: String
}

/**
 * A combination of a [key] and a state of [modifier keys][modifiers].
 */
data class KeyCombination<T : InputKey>(
    val key: T,
    val modifiers: ModifierKeys
) {
    companion object {
        /**
         * Creates a combination with a [key], and no modifier keys pressed.
         */
        fun <T : InputKey> just(key: T) = KeyCombination(key, ModifierKeys.none)
    }
}