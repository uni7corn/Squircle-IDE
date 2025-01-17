/*
 * Copyright 2021 Squircle IDE contributors.
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

package com.blacksquircle.ui.core.extensions

import androidx.annotation.IdRes
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator
import com.blacksquircle.ui.core.navigation.Screen

fun NavController.popBackStack(n: Int) {
    for (index in 0 until n) {
        popBackStack()
    }
}

fun NavController.navigate(
    screen: Screen,
    extras: Navigator.Extras? = null,
    navOptions: NavOptions? = null
) {
    navigate(screen.route.toUri(), navOptions, extras)
}

@Suppress("UNCHECKED_CAST")
fun <T : Fragment> FragmentManager.fragment(@IdRes id: Int): T {
    return findFragmentById(id) as T
}