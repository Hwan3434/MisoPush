package com.misoncloud.misopush

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import com.google.firebase.messaging.RemoteMessage
import com.misoncloud.misopush.controller.TempControllerInterface
import com.misoncloud.misopush.model.temp.Contributors
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

/**
 * 2020. 04. 06 메모
 * 목표 : Kotlin + okHttp + 비동기 결과값 리턴
 * 작성해야 할 것.
 * 1. 멤버 등록 하는 방법
 * 2. 멤버에서 삭제 하는 방법
 * 3. 사용자의 앱버전 업데이트 하는 방법
 * 4. 푸시 수신완료시 푸시서버로 리절트 주는 함수
 * 5.
 * 6.
 * 7.
 * 8.
 *
 *
 *
 */

class MisoPush private constructor() {


    companion object Client {

        @Volatile private var instance: MisoPush? = null

        @JvmStatic fun getInstance(): MisoPush =
            instance ?: synchronized(this) {
                instance ?: MisoPush().also {
                    instance = it

                    // http connection 기본 세팅 작업

                }
        }

        object KotlinOKHttpRxJavaManager {


            val CONNECTION_TIMEOUT:Long = 10
            val WRITE_TIMEOUT: Long = 10
            val READ_TIMEOUT: Long = 10
            val API_URL: String = "https://api.github.com/"

            val MISO_URL: String = "http://192.168.0.101:8080/"
            var mOKHttpClient: OkHttpClient
            var mRetrofit: Retrofit
            var mTempControllerInterface: TempControllerInterface


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
                    baseUrl(API_URL)
                    client(mOKHttpClient)
                    addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    addConverterFactory(GsonConverterFactory.create())
                }.build()

                mTempControllerInterface = mRetrofit.create()

            }

            fun getInstance(): TempControllerInterface {
                return mTempControllerInterface
            }


        }



        /**
         *
         */

        /**
         * 확인 후 서버로 AppID, MessageKey를 전달해줘야합니다.
         *
         */
        fun onReceveFcmMessage(){

        }

        /**
         * 로그인 할때 서버와 앱 버전 비교의(강업여부 판단)
         */
        fun checkVersion(){

        }

        /**
         * 앱 버전이 올라갈 경우 호출 해야하는 함수
         */
        fun UpdateAppVersion(){

        }

        /**
         * 디바이스토큰 변경시 호출
         */
        fun UpdateDeviceToken(){

        }


        /**
         * 최초 등록시
         */
        // 앱아이디, 앱 버전, 유저키, 디바이스토큰, 버전 필요
        @SuppressLint("CheckResult")
        fun RegisterMember(misoAppKey: String, deviceToken: String){

            val adapter = KotlinOKHttpRxJavaManager.getInstance()

            adapter.requestContributors("ldhcjs", "GetPackagesName")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .doOnError {
                    Log.d(TAG, "doOnError")
                }
                .unsubscribeOn(Schedulers.io())
                .onErrorReturn { t: Throwable ->
                    Log.d(TAG, "onErrorReturn : " + t.message)
                    arrayOf(Contributors())
                }
                .subscribe { result ->
                    if ("User" == result[0].getType()) {
                        Log.d(TAG, "subscribe good")
                    } else {
                        Log.d(TAG, "subscribe bad")
                    }
                }

        }

        /**
         * 푸시기능을 더이상 사용하지않을때
         */
        // 앱아이디, 앱 버전, 유저키, 디바이스토큰 필요
        fun DeleteMember(misoAppKey: String, misoKey: String){

            Log.d("MisoPush", "miso push misoAppKey : " + misoAppKey)

            Log.d("MisoPush", "miso push misoKey : " + misoKey)

        }

        /**
         * 푸시를 받으면 받았다고 리턴해주는 함수
         */
        // 메세지키를 통으로 넣어주자.
        fun onRecvPush(data : RemoteMessage){



        }

    }


}