package com.misoncloud.misopush

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


// 요녀석을 misopush를 받을려면 요녀석을 상속해서 사용 해야합니다. ~
open class MisoFirebaseMessagingService : FirebaseMessagingService() {


    // 디바이스토큰 수신
    override fun onNewToken(p0: String) {
        super.onNewToken(p0)
        // 던질때 필요한게 앱 아이디랑 유저키 디바이스토큰 os 버전아이디
        // 못구하는건 앱아이디, 유저키
        // 앱아이디가 없으면 던지는게 무의미한뎅

    }

    // 메세지 수신
    override fun onMessageReceived(p0: RemoteMessage) {
        super.onMessageReceived(p0)
        MisoPush.onRecvPush()
        // 미소서버로 일단 수신완료 날리기 ~
        // 이건 쌉가능 ~




    }


}