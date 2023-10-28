package com.core.network.di

import com.core.network.Dispatcher
import com.core.network.USAppDispatchers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
@Module
@InstallIn(SingletonComponent::class)
internal object DispatchersModule {
    @Provides
    @Dispatcher(USAppDispatchers.IO)
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
}