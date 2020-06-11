package com.misoncloud.misopush

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


// 요녀석을 misopush를 받을려면 요녀석을 상속해서 사용 해야합니다. ~
open class MisoFirebaseMessagingService : FirebaseMessagingService() {

    var misoFirebaseInterface:MisoFirebaseInterface
        get() {
            return misoFirebaseInterface;
        }
        set(value) {
            misoFirebaseInterface = value
        }

    // 디바이스토큰 수신
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
//        유저키도 우리가 만드는게 아니다잉
//        MisoPush.getInstance().insertTarget(appId, userKey, deviceToken, version)

    }

    // 메세지 수신
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)

        var messageKey = p0.data.get("messageKey")

        if(messageKey.equals("onKeepAlive")){
            MisoPush.getInstance().keepAlive("appId", "dtk")
            misoFirebaseInterface.onKeepAlive("")// deviceToken 쓰자
        }else {

            // 1. messageKey = {"misoMessageKey" : "messagekey", "dataMessageKey" : "messageKey" }
            // 2. messageKey = {"misoMessageKey" : "messagekey", "dataMessageKey" : "" }
            // 사용자가 key값을 messageKey를 쓰면 1번으로 넘어오고
            // 사용자가 key값을 messageKey를 안쓰면 2번으로 넘어옵니다.
            MisoPush.getInstance().onRecvPush("",messageKey.toString())
            p0.data.remove("messageKey")
            misoFirebaseInterface.onMisoMessageReceived(p0.data)

        }
    }


}