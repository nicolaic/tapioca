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

interface BindingSystem<T : InputKey> {

    val keymap: Keymap<T>

    fun createBindable(definition: BindableDefinition): Bindable<T>

    /**
     * Removes a bindable and all its bindings.
     */
    fun removeBindable(bindable: Bindable<T>)

    /**
     * Tries to find a bindable by its id, if one cannot
     * be found a null value will be returned instead.
     */
    fun findBindable(id: String): Bindable<T>?

    fun getAllBindables(): Set<Bindable<T>>

    /**
     * Removes all registered bindings.
     */
    fun clearBindings()

    fun handlePressed(key: T, modifiers: ModifierKeys)

    fun handleReleased(key: T)

    fun releaseAll()
}