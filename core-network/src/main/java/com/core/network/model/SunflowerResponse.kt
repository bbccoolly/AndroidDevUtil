package com.core.network.model

import com.core.model.sunflower.SunflowerPhotos
import com.google.gson.annotations.SerializedName

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/3/31
 */
data class SunflowerResponse(
    @field:SerializedName("results") val results: List<SunflowerPhotos>,
    @field:SerializedName("total_pages") val totalPages: Int
)