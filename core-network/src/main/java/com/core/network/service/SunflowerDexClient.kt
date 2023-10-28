package com.core.network.service

import com.core.network.model.SunflowerResponse
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
class SunflowerDexClient @Inject constructor(
    private val sunflowerApiService: SunflowerApiService
) {
    suspend fun fetchSunflowerPhotos(
        searchKey: String
    ): ApiResponse<SunflowerResponse> =
        sunflowerApiService.searchPhotos(searchKey, PAGING_SIZE, PAGING_PER)

    companion object {
        private const val PAGING_SIZE = 1
        private const val PAGING_PER = 5
    }
}