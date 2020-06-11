package com.misoncloud.misopush

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


// 요녀석을 misopush를 받을려면 요녀석을 상속해서 사용 해야합니다. ~
open class MisoFirebaseMessagingService : FirebaseMessagingService() {


    // 디바이스토큰 수신
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)

    }

    // 메세지 수신
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        var messageKey = p0.data.get("messageKey")

        if(messageKey.equals("onKeepAlive")){
            MisoPush.getInstance().keepAlive("appId")
            onKeepAlive("");
        }else {

            // 1. messageKey = {"misoMessageKey" : "messagekey", "dataMessageKey" : "messageKey" }
            // 2. messageKey = {"misoMessageKey" : "messagekey", "dataMessageKey" : "" }
            // 사용자가 key값을 messageKey를 쓰면 1번으로 넘어오고
            // 사용자가 key값을 messageKey를 안쓰면 2번으로 넘어옵니다.
            MisoPush.getInstance().onRecvPush("",messageKey.toString())
            p0.data.remove("messageKey")
            onMisoMessageReceived(messageKey.toString(), p0.data)

        }
    }

    open fun onKeepAlive(keep:String){

    }

    open fun onMisoMessageReceived(messageKey:String, map:Map<String, String>){

    }
}