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

import dev.nicolai.tapioca.Action
import dev.nicolai.tapioca.BindableDefinition

class GenericBindableDefinition(
    override val id: String,
    override val repeatable: Boolean = false,

    override val press: Action,
    override val release: Action?,

    override val name: String? = null,
    override val description: String? = null
) : BindableDefinition