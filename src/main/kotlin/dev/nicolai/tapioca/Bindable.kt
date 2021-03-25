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
 * An action that be be bound to a key combination.
 */
interface Bindable<T : InputKey> {

    val definition: BindableDefinition

    /**
     * Creates a binding for the specified combination.
     */
    fun bind(combination: KeyCombination<T>, repeatable: Boolean = definition.repeatable): Boolean

    /**
     * Unbinds the specified combination.
     */
    fun unbind(combination: KeyCombination<T>): Boolean

    /**
     * Checks if the specified combination is already bound.
     */
    fun areBound(combination: KeyCombination<T>): Boolean

    /**
     * Returns all bindings for this bindable.
     */
    fun getBindings(): Set<Binding<T>>

    /**
     * Removes all bindings for this bindable.
     */
    fun clear()
}

typealias Action = () -> Unit