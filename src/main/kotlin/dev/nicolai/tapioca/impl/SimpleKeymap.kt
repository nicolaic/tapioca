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

import dev.nicolai.tapioca.Binding
import dev.nicolai.tapioca.InputKey
import dev.nicolai.tapioca.Keymap

class SimpleKeymap<T : InputKey> : Keymap<T> {

    private val lookup = mutableMapOf<T, MutableSet<Binding<T>>>()

    override fun registerBinding(binding: Binding<T>) {
        lookup.getOrPut(binding.boundCombination.key, ::mutableSetOf).add(binding)
    }

    override fun unregisterBinding(binding: Binding<T>) {
        lookup[binding.boundCombination.key]?.remove(binding)
    }

    override fun findBindings(key: T): Set<Binding<T>> {
        return lookup[key] ?: emptySet()
    }

    override fun getAllBindings(): Set<Binding<T>> {
        return lookup.values.flatten().toSet()
    }

    override fun clear() {
        getAllBindings().forEach(Binding<T>::unbind)
    }
}