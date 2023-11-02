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
package com.core.preferences

import android.content.SharedPreferences
import com.core.preferences.delegate.booleanPreferences
import com.core.preferences.delegate.stringPreferences
import java.util.UUID
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/3/31
 */
class Preferences @Inject constructor(
    val sharedPreferences: SharedPreferences
) {

    val userUUID: String by stringPreferences(
        key = KEY_UUID,
        defaultValue = UUID.randomUUID().toString()
    )

    var authorization: String by stringPreferences(
        key = KEY_AUTHORIZATION,
        defaultValue = String.Empty
    )

    var cookie: String by stringPreferences(
        key = KEY_COOKIE,
        defaultValue = String.Empty
    )

    var userAgent: String by stringPreferences(
        key = KEY_USER_AGENT,
        defaultValue = String.Empty
    )

    var balloonChannelDisplayed: Boolean by booleanPreferences(
        key = KEY_BALLOON_CHANNEL_DISPLAYED,
        defaultValue = false
    )

    var accessToken: String by stringPreferences(
        key = KEY_ACCESS_TOKEN,
        defaultValue = String.Empty
    )

    var refreshToken: String by stringPreferences(
        key = KEY_REFRESH_TOKEN,
        defaultValue = String.Empty
    )

    var deviceId: String by stringPreferences(
        key = KEY_DEVICE_ID_FLY,
        defaultValue = String.Empty
    )

    var workerId: String by stringPreferences(
        key = KEY_WORKER_ID,
        defaultValue = String.Empty
    )

    var isLogin: Boolean by booleanPreferences(
        key = KEY_IS_LOGIN,
        defaultValue = false
    )

    var userId: String by stringPreferences(
        key = KEY_USER_ID,
        defaultValue = String.Empty
    )

    var phone: String by stringPreferences(
        key = KEY_USER_PHONE,
        defaultValue = String.Empty
    )

    var password: String by stringPreferences(
        key = KEY_USER_PW,
        defaultValue = String.Empty
    )

    var phoneTel: String by stringPreferences(
        key = KEY_USER_PHONE_TEL,
        defaultValue = String.Empty
    )

    var apiHost: String by stringPreferences(
        key = KEY_API,
        defaultValue = "http://192.168.1.210:8087/"
    )

    companion object {
        private const val KEY_ACCESS_TOKEN = "access_token"
        private const val KEY_REFRESH_TOKEN = "refresh_token"

        private const val KEY_UUID: String = "key_uuid"
        private const val KEY_AUTHORIZATION: String = "key_authorization"
        private const val KEY_COOKIE: String = "key_cookie"
        private const val KEY_USER_AGENT: String = "key_user_agent"
        private const val KEY_BALLOON_CHANNEL_DISPLAYED = "key_balloon_channel_displayed"
        private const val KEY_DEVICE_ID_FLY = "key_device_id_fly"
        private const val KEY_WORKER_ID = "key_worker_id"
        private const val KEY_IS_LOGIN = "key_is_login"
        private const val KEY_USER_ID = "key_user_id"
        private const val KEY_USER_PHONE = "key_user_phone" // userName
        private const val KEY_USER_PW = "key_user_pw"
        private const val KEY_USER_PHONE_TEL = "key_user_tel" // userName
        private const val KEY_API = "key_api" // userName
    }
}

val String.Companion.Empty
    inline get() = ""
