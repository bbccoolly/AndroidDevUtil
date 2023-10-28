package com.core.network

import javax.inject.Qualifier

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */
@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Dispatcher(val lczAppDispatchers: USAppDispatchers)

enum class USAppDispatchers {
    IO
}