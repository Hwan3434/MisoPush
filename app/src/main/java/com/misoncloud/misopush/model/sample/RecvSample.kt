package com.misoncloud.misopush.model.sample

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class RecvSample {

    @SerializedName("appId")
    @Expose
    private var appId: String? = null

    @SerializedName("requestDateTime")
    @Expose
    private var requestDateTime: String? = null

    @SerializedName("jsonText")
    @Expose
    private var jsonText: String? = null

    @SerializedName("userKeyList")
    @Expose
    private var userKeyList: ArrayList<String>? = null


    fun log(){
        System.out.println("appId : " + appId)
        System.out.println("requestDateTime : " + requestDateTime)
        System.out.println("jsonText : " + jsonText)
        System.out.println("userKeyList : " + userKeyList.toString())
    }

}