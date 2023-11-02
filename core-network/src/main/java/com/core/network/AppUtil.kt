/*
 * Designed and developed by 2020 skydoves (Jaewoong Eum)
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
package com.core.network

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */

enum class ServerCode {
    DEV,
    PRODUCT,
}

object AppUtil {
    private var serverCode = ServerCode.DEV

    val apiHost: String
        get() {
            return if (serverCode == ServerCode.DEV) {
                "http://192.168.1.210:8087/"
            } else {
                "http://192.168.1.210:8087/"
            }
        }

    const val apiHostVersionCheck: String = "http://172.16.1.9:19999/" + "update/checkVersion"
    const val apiHostVersionUpdate: String = "http://172.16.1.9:19999/" + "update/apk/"
}
