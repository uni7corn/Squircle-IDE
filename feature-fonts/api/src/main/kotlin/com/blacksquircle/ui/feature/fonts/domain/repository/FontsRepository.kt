/*
 * Copyright 2023 Squircle CE contributors.
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

package com.blacksquircle.ui.feature.fonts.domain.repository

import android.net.Uri
import com.blacksquircle.ui.feature.fonts.domain.model.FontModel

interface FontsRepository {

    suspend fun current(): FontModel
    suspend fun loadFonts(): List<FontModel>
    suspend fun loadFonts(query: String): List<FontModel>
    suspend fun loadFont(path: String): FontModel

    suspend fun importFont(fileUri: Uri)
    suspend fun selectFont(fontModel: FontModel)
    suspend fun removeFont(fontModel: FontModel)
}