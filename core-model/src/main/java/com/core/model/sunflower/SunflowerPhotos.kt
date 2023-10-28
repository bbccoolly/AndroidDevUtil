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
    @field:Json(name = "small") val small: String=""
) : Parcelable

@Parcelize
@JsonClass(generateAdapter = true)
data class UnsplashUser(
    @field:Json(name = "name") val name: String,
    @field:Json(name = "username") val username: String,
) : Parcelable
