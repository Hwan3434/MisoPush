package com.misoncloud.misopush

interface MisoFirebaseInterface{

    fun onMisoMessageReceived(data:Map<String, String>)
    fun onKeepAlive(data:String)

}