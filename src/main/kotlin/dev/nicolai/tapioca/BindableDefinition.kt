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

interface BindableDefinition {

    /**
     * An unique identifier of this bindable.
     */
    val id: String

    /**
     * If the action is repeatable by default.
     */
    val repeatable: Boolean

    /**
     * Action to do when this bindable is pressed.
     */
    val press: Action

    /**
     * Action to do when this bindable is released.
     */
    val release: Action?

    /**
     * A displayable name of this bindable.
     */
    val name: String?

    /**
     * A short description of what this bindable does.
     */
    val description: String?
}