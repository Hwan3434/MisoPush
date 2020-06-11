package com.misoncloud.misopush.model.check

import com.google.gson.annotations.SerializedName


class KeepAliveRequestModel {

    @SerializedName("keep")
    private var keep: String? = null

    @SerializedName("os")
    private var os: Int = 0

    constructor(){}
    constructor(keep:String, deviceToken:String){

        this.keep = keep
        this.os = 1

    }


}