package com.misoncloud.misopush.model.requestmessage

import com.google.gson.annotations.SerializedName
import java.text.SimpleDateFormat
import java.util.*


class RequestMessageSaveModel {


    @SerializedName("idno")
    private var idno: Int = 0

    @SerializedName("userKey")
    private var userKey: String? = null

    @SerializedName("messageKey")
    private var messageKey: String? = null

    @SerializedName("sendrequestDateTime")
    private var sendrequestDateTime: String? = null

    @SerializedName("os")
    private var os: Int = 0



    constructor(){}
    constructor(idno:Int, userKey:String, messageKey:String, sendrequestDateTime:Date){

        this.idno = idno
        this.userKey = userKey
        this.messageKey = messageKey
        this.sendrequestDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(sendrequestDateTime)
        this.os = 1

    }


}