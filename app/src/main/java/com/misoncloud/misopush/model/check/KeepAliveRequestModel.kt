package com.misoncloud.misopush.model.check

import com.google.gson.annotations.SerializedName


class KeepAliveRequestModel {

    @SerializedName("appId")
    private var appId: String? = null

    @SerializedName("deviceToken")
    private var deviceToken: String? = null

    @SerializedName("os")
    private var os: Int = 0

    constructor(){}
    constructor(appId:String, deviceToken:String){

        this.appId = appId
        this.deviceToken = deviceToken
        this.os = 1

    }


}