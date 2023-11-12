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

package com.blacksquircle.ui.feature.changelog.data.repository

import android.content.Context
import com.blacksquircle.ui.core.provider.coroutine.DispatcherProvider
import com.blacksquircle.ui.feature.changelog.R
import com.blacksquircle.ui.feature.changelog.data.converter.ReleaseConverter
import com.blacksquircle.ui.feature.changelog.domain.model.ReleaseModel
import com.blacksquircle.ui.feature.changelog.domain.repository.ChangelogRepository
import kotlinx.coroutines.withContext
import java.io.BufferedReader

class ChangelogRepositoryImpl(
    private val dispatcherProvider: DispatcherProvider,
    private val context: Context,
) : ChangelogRepository {

    override suspend fun loadChangelog(): List<ReleaseModel> {
        return withContext(dispatcherProvider.io()) {
            val inputStream = context.resources.openRawResource(R.raw.changelog)
            val changelogRaw = inputStream.bufferedReader().use(BufferedReader::readText)
            ReleaseConverter.toReleaseModels(changelogRaw)
        }
    }
}