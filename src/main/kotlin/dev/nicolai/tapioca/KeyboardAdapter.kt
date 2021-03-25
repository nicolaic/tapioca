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
 * An adapters that simplifies working with the platform keyboard.
 */
interface KeyboardAdapter<T : InputKey> {

    /**
     * Tries to parse a key name to an instance, and returns the result.
     */
    fun parseKey(key: String): T? {
        return keyAdapter.toKey(key)
    }

    /**
     * The current pressed state of the system modifier keys.
     */
    val modifierKeys: ModifierKeys

    /**
     * An adapter that converts between keys and their unique identifiers.
     */
    val keyAdapter: InputKeyAdapter<T>
}

/**
 * An adapter that converts between keys and their unique identifiers.
 */
interface InputKeyAdapter<T : InputKey> {

    /**
     * Tries to find a key by its identifier, and returns the result.
     */
    fun toKey(identifier: String): T?

    /**
     * Returns the identifier of the key.
     */
    fun toIdentifier(key: T): String
}
