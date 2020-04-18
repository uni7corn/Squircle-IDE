/*
 * Licensed to the Light Team Software (Light Team) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The Light Team licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lightteam.language.scheme

interface ColorScheme {
    val textColor: String
    val backgroundColor: String
    val gutterColor: String
    val gutterDividerColor: String
    val gutterCurrentLineNumberColor: String
    val gutterTextColor: String
    val selectedLineColor: String
    val selectionColor: String
    val filterableColor: String

    val searchBgColor: String
    val bracketBgColor: String

    //Syntax Highlighting
    val numberColor: String
    val operatorColor: String
    val bracketColor: String
    val keywordColor: String
    val typeColor: String
    val langConstColor: String
    val methodColor: String
    val stringColor: String
    val commentColor: String
}