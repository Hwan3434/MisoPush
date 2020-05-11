package com.misoncloud.misopush

import com.misoncloud.misopush.controller.RequestMessageControllerInterface
import com.misoncloud.misopush.controller.SampleControllerInterface
import com.misoncloud.misopush.controller.TargetControllerInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class WebClient private constructor() {

    val CONNECTION_TIMEOUT: Long = 10
    val WRITE_TIMEOUT: Long = 10
    val READ_TIMEOUT: Long = 10

    companion object {
        @Volatile private var instance: WebClient? = null

        @JvmStatic fun getInstance(): WebClient =
            instance ?: synchronized(this) {
                instance ?: WebClient().also {
                    instance = it
                }
            }
    }

    // 집 : 192.168.219.179
    // 회사 : 192.168.0.101

    val MISO_URL: String = "http://192.168.0.97:8080/"
    var mOKHttpClient: OkHttpClient
    var mRetrofit: Retrofit
    var mSampleControllerInterface: SampleControllerInterface
    var mTargetControllerInterface: TargetControllerInterface
    var mRequestMessageControllerInterface: RequestMessageControllerInterface

    init {

        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        mOKHttpClient = OkHttpClient().newBuilder().apply {
            addInterceptor(httpLoggingInterceptor)
            connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
            writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
        }.build()


        mRetrofit = Retrofit.Builder().apply {
            baseUrl(MISO_URL)
            client(mOKHttpClient)
            addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            addConverterFactory(GsonConverterFactory.create())
        }.build()

        mSampleControllerInterface = mRetrofit.create()
        mTargetControllerInterface = mRetrofit.create()
        mRequestMessageControllerInterface = mRetrofit.create()

    }

    fun getSampleController(): SampleControllerInterface {
        return mSampleControllerInterface
    }

    fun getTargetController(): TargetControllerInterface {
        return mTargetControllerInterface
    }

    fun getRequestMessageControllerInterface(): RequestMessageControllerInterface {
        return mRequestMessageControllerInterface
    }






}