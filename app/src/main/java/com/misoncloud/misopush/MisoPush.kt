package com.misoncloud.misopush

import android.annotation.SuppressLint
import android.util.Log
import com.misoncloud.misopush.model.check.KeepAliveRequestModel
import com.misoncloud.misopush.model.check.KeepAliveResponseModel
import com.misoncloud.misopush.model.requestmessage.ResponseFromDeviceMessageSaveModel
import com.misoncloud.misopush.model.sample.SampleJsonModel
import com.misoncloud.misopush.model.target.TargetSaveModel
import com.misoncloud.misopush.util.date.MisoListener
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList


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

open class MisoPush private constructor() {


    var mainListener:MisoListener? = null
    var userKey:String = ""
    var appId:String = ""
    var version:String = ""

    companion object Client {

        @Volatile
        private var instance: MisoPush? = null

        @JvmStatic
        fun getInstance(): MisoPush =
            instance ?: synchronized(this) {
                instance ?: MisoPush().also {
                    instance = it

                }
            }
    }

    fun init(listener: MisoListener, userKey: String, appId: String, version: String){
        this.mainListener = listener
        this.appId = appId
        this.userKey = userKey
        this.version = version
    }

    fun onErrorListener(t:Throwable, listener: MisoListener?){

        if(listener != null){
            listener.onFaile("error return : " + t.message)
        }else if(mainListener != null){
            mainListener?.onFaile("error return : " + t.message)
        }
    }

    fun onErrorReturnListener(t:Throwable, listener: MisoListener?){

        if(listener != null){
            listener.onFaile("error return : " + t.message)
        }else if(mainListener != null){
            mainListener?.onFaile("error return : " + t.message)
        }

    }
    fun onSuccesListener(message:String, listener: MisoListener?){

        if(listener != null){
            listener.onSucces("error return : " + message)
        }else if(mainListener != null){
            mainListener?.onSucces("error return : " + message)
        }
    }

    fun keepAlive(keep:String){
        keepAlive(appId, null)
    }

    fun insertTarget(appId:String, userKey:String, deviceToken:String, version:String) {
        insertTarget(appId, userKey, deviceToken, version, null)
    }

    fun onRecvPush(userKey:String, messageKey: String){
        onRecvPush(userKey, messageKey, null)
    }

    fun TestBySample(misoAppKey: String, deviceToken: String){
        TestBySample(misoAppKey, deviceToken, null)
    }

    @SuppressLint("CheckResult")
    fun keepAlive(keep:String, listener: MisoListener?) {

        val adapter = WebClient.getInstance().getCheckControllerInterface()

        var target:KeepAliveRequestModel = KeepAliveRequestModel(appId, keep)

        adapter.keepAlive(target)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {

                System.out.println("fail : " + it.message)
                onErrorListener(it, listener)

                it.printStackTrace()

            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->

                // 500 : @CommonAspectNotTarget ( 인증안된 요청 - 로그인 안해서 웹 호출 거부 )
                System.out.println("error return : " + t.message)
                onErrorReturnListener(t, listener)

                KeepAliveResponseModel()
            }
            .subscribe { result ->

                System.out.println("go @@@@@@@@@@@@@@@@@@");
                onSuccesListener(result.toString(), listener)

            }
    }

    /**
     *
     */
    @SuppressLint("CheckResult")
    fun insertTarget(appId:String, userKey:String, deviceToken:String, version:String, listener: MisoListener?){

        val adapter = WebClient.getInstance().getTargetController()

        var target:TargetSaveModel = TargetSaveModel(appId, userKey,deviceToken, 1, version)

        adapter.targetInsert(target)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {

                onErrorListener(it, listener)
                System.out.println("fail : " + it.message)

                it.printStackTrace()

            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->

                // 500 : @CommonAspectNotTarget ( 인증안된 요청 - 로그인 안해서 웹 호출 거부 )


                onErrorReturnListener(t, listener)
                System.out.println("error return : " + t.message)

                TargetSaveModel()
            }
            .subscribe { result ->

                onSuccesListener(result.toString(), listener)
                System.out.println("result !! : " + result.toString())

            }


    }

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
    fun TestBySample(misoAppKey: String, deviceToken: String, listener: MisoListener?){

        val adapter = WebClient.getInstance().getSampleController()

        var ss:ArrayList<String> = ArrayList<String>()

        ss.add("아니")
        ss.add("rkfk")
        ss.add("말이야 개야?")

//            var sss:SendSample = SendSample("aaa",1,2.1, false, "2011-04-24T10:11:10:35.520Z", ss, SendSample.SapleInner_Object(9, "Jh"))
        var sss:SampleJsonModel = SampleJsonModel("aaa",1,2.1, false, "2011-04-24 10:11:10:35.520", ss, SampleJsonModel.SampleJsonModelItem(9, "Jh"))


        adapter.sampleJson(sss)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {

                onErrorListener(it, listener)
                System.out.println("fail : " + it.message)

                it.printStackTrace()

            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->

                // 500 : @CommonAspectNotTarget ( 인증안된 요청 - 로그인 안해서 웹 호출 거부 )


                onErrorReturnListener(t, listener)
                System.out.println("error return : " + t.message)

                SampleJsonModel()
            }
            .subscribe { result ->

                onSuccesListener(result.toString(), listener)
                System.out.println("result !! : " + result.toString())

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
    @SuppressLint("CheckResult")
    fun onRecvPush(userKey:String, messageKey: String, listener: MisoListener?){

        System.out.println("method : onRecvPush")

        val adapter = WebClient.getInstance().getRequestMessageControllerInterface()

        var data:ResponseFromDeviceMessageSaveModel = ResponseFromDeviceMessageSaveModel(0,userKey, messageKey, Date())

        adapter.responseFromDeviceMessageInsert(data)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {

                onErrorListener(it, listener)
                System.out.println("fail : " + it.message)

                it.printStackTrace()

            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->

                // 500 : @CommonAspectNotTarget ( 인증안된 요청 - 로그인 안해서 웹 호출 거부 )


                onErrorReturnListener(t, listener)
                System.out.println("error return : " + t.message)

                ResponseFromDeviceMessageSaveModel()
            }
            .subscribe { result ->

                onSuccesListener(result.toString(), listener)
                System.out.println("result !! : " + result.toString())

            }


    }

}
