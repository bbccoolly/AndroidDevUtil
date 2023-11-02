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
package com.core.database.entity.mapper

import com.core.database.entity.SunflowerPhotosEntity
import com.core.model.sunflower.SunflowerPhotos

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/11/2
 */
object SunflowerEntityMapper :
    EntityMapper<List<SunflowerPhotos>, List<SunflowerPhotosEntity>> {
    override fun asEntity(domain: List<SunflowerPhotos>): List<SunflowerPhotosEntity> {
        return domain.map { photo ->
            SunflowerPhotosEntity(
                plantId = photo.id,
                user = photo.user,
                urls = photo.urls
            )
        }
    }

    override fun asDomain(entity: List<SunflowerPhotosEntity>): List<SunflowerPhotos> {
        return entity.map { plantEntity ->
            SunflowerPhotos(
                id = plantEntity.plantId,
                user = plantEntity.user,
                urls = plantEntity.urls
            )
        }
    }
}

fun List<SunflowerPhotos>.asEntity(): List<SunflowerPhotosEntity> {
    return SunflowerEntityMapper.asEntity(this)
}

fun List<SunflowerPhotosEntity>.asDomain(): List<SunflowerPhotos> {
    return SunflowerEntityMapper.asDomain(this)
}
