package com.core.network.service

import com.core.network.model.SunflowerResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
interface SunflowerApiService {
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int,
        @Query("client_id") clientId: String = "fsW1RKkPV2Q04y2Xz42xG9y11t0lgnwYWjlg3WvDo0c"
    ): ApiResponse<SunflowerResponse>
}