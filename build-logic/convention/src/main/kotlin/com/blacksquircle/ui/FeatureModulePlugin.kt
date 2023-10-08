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

package com.blacksquircle.ui

import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class FeatureModulePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                val isApiModule = target.name.endsWith("api")
                if (isApiModule) {
                    apply("com.android.library")
                    apply("org.jetbrains.kotlin.android")
                } else {
                    apply("com.android.library")
                    apply("org.jetbrains.kotlin.android")
                    apply("org.jetbrains.kotlin.kapt")
                    apply("dagger.hilt.android.plugin")
                    apply("androidx.navigation.safeargs.kotlin")
                }
            }

            configure<LibraryExtension> {
                compileSdk = BuildConst.COMPILE_SDK

                defaultConfig {
                    minSdk = BuildConst.MIN_SDK

                    consumerProguardFiles("consumer-rules.pro")
                }
                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                }
                tasks.withType<KotlinCompile>().configureEach {
                    kotlinOptions {
                        jvmTarget = "17"
                    }
                }
                sourceSets {
                    named("main") {
                        java.srcDir("src/main/kotlin")
                    }
                    named("test") {
                        java.srcDir("src/test/kotlin")
                    }
                }
            }
        }
    }
}