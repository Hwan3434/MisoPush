package com.misoncloud.misopush.model.target

import com.google.gson.annotations.SerializedName


class TargetSaveModel {


    @SerializedName("appId")
    private var appId: String? = null

    @SerializedName("userKey")
    private var userKey: String? = null

    @SerializedName("deviceToken")
    private var deviceToken: String? = null

    @SerializedName("os")
    private var os: Int? = null

    @SerializedName("versionId")
    private var versionId: String? = null


    constructor(){}
    constructor(appId:String, userKey:String, deviceToken:String, os:Int, versionId:String){

        this.appId = appId
        this.userKey = userKey
        this.deviceToken = deviceToken
        this.os = os
        this.versionId = versionId

    }

    override fun toString(): String {
        return "appId : " + appId + " / " +
                "userKey : " + userKey + " / " +
                "os : " + os + " / " +
                "versionId : " + versionId
    }

}