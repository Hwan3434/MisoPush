package com.misoncloud.misopush.model.version

import com.google.gson.annotations.SerializedName

class AppVersionApiRequestModel {


    @SerializedName("appId")
    private var appId: String? = null

    @SerializedName("os")
    private var os: Int? = null

    constructor(){}
    constructor(appId:String){

        this.appId = appId
        this.os = 1

    }


}