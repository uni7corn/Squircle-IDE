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

package com.blacksquircle.ui.filesystem.base

import com.blacksquircle.ui.filesystem.base.model.FileModel
import com.blacksquircle.ui.filesystem.base.model.FileParams
import com.blacksquircle.ui.filesystem.base.model.FileTree
import kotlinx.coroutines.flow.Flow

interface Filesystem {

    fun defaultLocation(): FileModel
    fun provideDirectory(parent: FileModel): FileTree
    fun exists(fileModel: FileModel): Boolean

    fun createFile(fileModel: FileModel)
    fun renameFile(source: FileModel, dest: FileModel)
    fun deleteFile(fileModel: FileModel)
    fun copyFile(source: FileModel, dest: FileModel)

    fun compressFiles(source: List<FileModel>, dest: FileModel): Flow<FileModel>
    fun extractFiles(source: FileModel, dest: FileModel): Flow<FileModel>

    fun loadFile(fileModel: FileModel, fileParams: FileParams): String
    fun saveFile(fileModel: FileModel, text: String, fileParams: FileParams)

    interface Mapper<T> {
        fun toFileModel(fileObject: T): FileModel
        fun toFileObject(fileModel: FileModel): T
    }
}