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

class SimpleBindingSystem<T : InputKey>(
    override val keymap: Keymap<T>
) : BindingSystem<T> {

    private val bindables = mutableMapOf<String, Bindable<T>>()

    override fun createBindable(definition: BindableDefinition): Bindable<T> {
        val id = definition.id

        require(id !in bindables) { "A bindable with id '$id' already exists" }

        return KeymapBindable(definition, keymap)
            .also { bindables[id] = it }
    }

    override fun removeBindable(bindable: Bindable<T>) {
        if (bindables.remove(bindable.definition.id, bindable)) {
            bindable.clear()
        }
    }

    override fun findBindable(id: String) = bindables[id]

    override fun getAllBindables(): Set<Bindable<T>> = bindables.values.toSet()

    override fun clearBindings() {
        bindables.values.forEach(Bindable<T>::clear)
    }

    override fun handlePressed(key: T, modifiers: ModifierKeys) {
        val bindings = keymap.findBindings(key)

        for (binding in bindings) {
            if (binding.boundCombination.modifiers == modifiers) {
                binding.press()
            }
        }
    }

    override fun handleReleased(key: T) {
        keymap.findBindings(key).forEach(Binding<T>::release)
    }

    override fun releaseAll() {
        keymap.getAllBindings().forEach(Binding<T>::release)
    }
}