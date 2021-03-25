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

class KeymapBindable<T : InputKey>(
    override val definition: BindableDefinition,
    private val keymap: Keymap<T>
) : Bindable<T> {

    private val bindings = mutableMapOf<KeyCombination<T>, Binding<T>>()

    override fun bind(combination: KeyCombination<T>, repeatable: Boolean): Boolean {
        if (areBound(combination)) return false

        val binding = createBinding(combination, repeatable)

        bindings[combination] = binding
        keymap.registerBinding(binding)

        return true
    }

    private fun createBinding(combination: KeyCombination<T>, repeatable: Boolean) =
        SimpleBinding(
            this,
            combination,
            definition.press,
            definition.release,
            repeatable
        )

    override fun unbind(combination: KeyCombination<T>): Boolean {
        return bindings.remove(combination)?.also(keymap::unregisterBinding) != null
    }

    override fun areBound(combination: KeyCombination<T>) = bindings.containsKey(combination)

    override fun getBindings() = bindings.values.toSet()

    override fun clear() {
        bindings.values.forEach(keymap::unregisterBinding)
        bindings.clear()
    }
}
