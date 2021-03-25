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

package dev.nicolai.tapioca.impl

import dev.nicolai.tapioca.*

class SimpleBinding<T : InputKey>(
    override val handle: Bindable<T>,
    override val boundCombination: KeyCombination<T>,
    private val press: Action,
    private val release: Action?,
    private val repeatable: Boolean
) : Binding<T> {

    private var pressed = false

    override fun press() {
        if (pressed && !repeatable) return

        pressed = true
        press.invoke()
    }

    override fun release() {
        if (!pressed) return

        pressed = false
        release?.invoke()
    }

    override fun isPressed() = pressed

    override fun unbind() {
        handle.unbind(boundCombination)
    }
}