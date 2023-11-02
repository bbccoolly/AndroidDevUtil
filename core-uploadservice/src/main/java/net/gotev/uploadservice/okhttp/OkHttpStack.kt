package net.gotev.uploadservice.okhttp

import net.gotev.uploadservice.UploadServiceConfig
import net.gotev.uploadservice.network.HttpRequest
import net.gotev.uploadservice.network.HttpStack
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import java.io.IOException
import java.util.concurrent.TimeUnit

/**
 * Implementation of the OkHttp Stack.
 * @author Aleksandar Gotev
 */
class OkHttpStack(
    private val client: OkHttpClient =
        OkHttpClient.Builder()
//            .followRedirects(true)
//            .followSslRedirects(true)
//            .retryOnConnectionFailure(true)
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .writeTimeout(30, TimeUnit.SECONDS)
//            .readTimeout(30, TimeUnit.SECONDS)
            .cache(null)
            .addInterceptor(Interceptor { chain ->
                val request = chain.request().newBuilder()
                    .header("User-Agent", UploadServiceConfig.defaultUserAgent)
                    .build()
                chain.proceed(request)
            })
            .build()
) : HttpStack {
    @Throws(IOException::class)
    override fun newRequest(uploadId: String, method: String, url: String): HttpRequest {
        return OkHttpStackRequest(uploadId, client, method, url)
    }
}
