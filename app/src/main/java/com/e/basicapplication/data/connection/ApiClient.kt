package com.e.basicapplication.data.connection

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {


    private var retrofit: Retrofit? = null
    private var retrofitWithHeader: Retrofit? = null

    private val interceptor = HttpLoggingInterceptor()

    private fun getHttpClient(isHeader: Boolean = false): OkHttpClient {
        return if (isHeader) {
            httpClient()
                    .addInterceptor(HeaderInterceptor())
                    .build()
        } else {
            httpClient()
                    .build()
        }
    }

    private fun httpClient(): OkHttpClient.Builder {
        return OkHttpClient()
                .newBuilder()
                .addInterceptor(interceptor)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .followRedirects(true)
                .followSslRedirects(true)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
    }

    fun getServiceWithoutHeader(): ApiService? {
        if (retrofitWithHeader == null) {
            retrofitWithHeader = Retrofit.Builder()
                    .client(getHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }
        return retrofitWithHeader?.create(ApiService::class.java)
    }

    fun getService(): ApiService? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .client(getHttpClient(true))
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
        }
        return retrofit?.create(ApiService::class.java)
    }
}

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain) = chain.run {
        proceed(
                request()
                        .newBuilder()
                        .addHeader(Authorization, "")
                        .build()
        )
    }
}

