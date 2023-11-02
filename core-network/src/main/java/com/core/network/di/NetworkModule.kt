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
package com.core.network.di

import com.core.network.BuildConfig
import com.core.network.service.SunflowerApiService
import com.core.network.service.SunflowerDexClient
import com.core.preferences.Preferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.skydoves.sandwich.adapters.ApiResponseCallAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {
    @Provides
    @Singleton
    fun provideOkhttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    if (BuildConfig.DEBUG) {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    } else {
                        setLevel(HttpLoggingInterceptor.Level.NONE)
                    }
                }
            )
            .connectTimeout(20, TimeUnit.SECONDS) // 设置连接超时时间为30秒
            .readTimeout(20, TimeUnit.SECONDS) // 设置读取超时时间为30秒
            .writeTimeout(20, TimeUnit.SECONDS) // 设置写入超时时间为30秒
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, pref: Preferences): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(pref.apiHost)
//            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(ApiResponseCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideSunflowerSunflowerApiService(retrofit: Retrofit): SunflowerApiService {
        return retrofit.create(SunflowerApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideSunflowerDexClient(sunflowerApiService: SunflowerApiService): SunflowerDexClient {
        return SunflowerDexClient(sunflowerApiService)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}
