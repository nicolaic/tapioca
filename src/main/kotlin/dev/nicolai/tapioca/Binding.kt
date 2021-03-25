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

interface Binding<T : InputKey> {

    val handle: Bindable<T>

    /**
     * The bound key and modifier keys combination for this binding.
     */
    val boundCombination: KeyCombination<T>

    /**
     * Tells this binding that its combination has been pressed.
     *
     * If a key is pressed and held, the underlying system will typically start
     * sending repeated input events. For repeated inputs this function should
     * still be called, as bindings may perform actions on repeated inputs.
     */
    fun press()

    /**
     * Tells this binding its bound key has been released.
     */
    fun release()

    /**
     * The current pressed state of this binding.
     */
    fun isPressed(): Boolean

    fun unbind()
}