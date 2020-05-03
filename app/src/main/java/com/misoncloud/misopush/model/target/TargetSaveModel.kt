package com.misoncloud.misopush.model.target

import com.google.gson.annotations.SerializedName


class TargetSaveModel {


    @SerializedName("idno")
    private var idno: Int = 0;

    @SerializedName("appIdno")
    private var appIdno: Int? = null

    @SerializedName("userKey")
    private var userKey: String? = null

    @SerializedName("deviceToken")
    private var deviceToken: String? = null

    @SerializedName("os")
    private var os: Int? = null

    @SerializedName("versionId")
    private var versionId: Int? = null


    constructor(){}
    constructor(appIdno:Int, userKey:String, deviceToken:String, os:Int, versionId:Int){

        this.appIdno = appIdno
        this.userKey = userKey
        this.deviceToken = deviceToken
        this.os = os
        this.versionId = versionId

    }

    override fun toString(): String {
        return "idno : " + idno + " / " +
                "appId : " + appIdno + " / " +
                "userKey : " + userKey + " / " +
                "os : " + os + " / " +
                "versionId : " + versionId
    }




}