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
package com.core.model.sunflower

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class SunflowerPhotos(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "urls") val urls: UnsplashPhotoUrls,
    @field:Json(name = "user") val user: UnsplashUser
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class UnsplashPhotoUrls(
    @field:Json(name = "small") val small: String = ""
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class UnsplashUser(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "username") val username: String
) : Parcelable
