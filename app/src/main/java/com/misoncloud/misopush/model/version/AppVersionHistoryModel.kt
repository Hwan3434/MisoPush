package com.misoncloud.misopush.model.version

import com.google.gson.annotations.SerializedName
import java.util.*


class AppVersionHistoryModel {

    @SerializedName("IdNo")
    private var IdNo: String? = null

    @SerializedName("appIdNo")
    private var appIdno: String? = null

    @SerializedName("os")
    private var os: Integer? = null

    @SerializedName("versionId")
    private var versionId: String? = null

    @SerializedName("forceUpdate")
    private var forceUpdate: Boolean? = null

    @SerializedName("targetKeyType")
    private var targetKeyType: String? = null

    @SerializedName("releaseDateTime")
    private var releaseDateTime: Date? = null

    constructor(){}

}