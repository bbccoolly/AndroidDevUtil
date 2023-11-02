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
package com.core.data.repository

import androidx.annotation.WorkerThread
import com.core.database.SunflowerDao
import com.core.database.entity.mapper.asDomain
import com.core.database.entity.mapper.asEntity
import com.core.network.Dispatcher
import com.core.network.USAppDispatchers
import com.core.network.service.SunflowerDexClient
import com.skydoves.sandwich.message
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/11/2
 */
class SunflowerRepositoryImpl @Inject constructor(
    private val sunflowerDao: SunflowerDao,
    private val sunflowerDexClient: SunflowerDexClient,
    @Dispatcher(USAppDispatchers.IO) private val ioDispatcher: CoroutineDispatcher
) : SunflowerRepository {

    @WorkerThread
    override fun fetchSunflowerList(
        searchKey: String,
        onStart: () -> Unit,
        onComplete: () -> Unit,
        onError: (String?) -> Unit
    ) = flow {
        var photos = sunflowerDao.getAllPlants().asDomain()
        if (photos.isEmpty()) {
            val response = sunflowerDexClient.fetchSunflowerPhotos(searchKey = searchKey)
            response.suspendOnSuccess {
                photos = data.results
                sunflowerDao.insertAll(photos.asEntity())
                emit(photos)
            }.onFailure {
                onError(message())
            }
        } else {
            emit(photos)
        }
    }.onStart { onStart() }.onCompletion { onComplete() }.flowOn(ioDispatcher)
}
