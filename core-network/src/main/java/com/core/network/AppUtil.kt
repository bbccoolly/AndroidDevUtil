package com.core.network

/**
 *
 * desc: TODO
 *
 * create by lcz on 2023/10/28
 */

enum class ServerCode {
    DEV,
    PRODUCT,
}

object AppUtil {
    private var serverCode = ServerCode.DEV

    val apiHost: String
        get() {
            return if (serverCode == ServerCode.DEV) {
                "http://192.168.1.210:8087/"
            } else {
                "http://192.168.1.210:8087/"
            }
        }

    const val apiHostVersionCheck: String = "http://172.16.1.9:19999/"+"update/checkVersion"
    const val apiHostVersionUpdate: String = "http://172.16.1.9:19999/"+"update/apk/"
}