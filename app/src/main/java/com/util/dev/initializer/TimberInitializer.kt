/*
 * Designed and developed by 2022 skydoves (Jaewoong Eum)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.util.dev.initializer

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

/**
 *
 * desc: https://developer.android.com/topic/libraries/app-startup
 * App Startup 允许您定义共享单个内容提供程序的组件初始化程序，
 * 而不是为您需要初始化的每个组件定义单独的内容提供程序。这可以显着缩短应用程序启动时间。
 *
 * create by lcz on 2023-03-28
 */
class TimberInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Timber.plant(Timber.DebugTree())
        Timber.d("TimberInitializer is initialized.")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}
