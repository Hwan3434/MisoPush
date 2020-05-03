package com.misoncloud.misopush.model.requestmessage

import com.google.android.gms.common.util.JsonUtils
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*


class RequestMessageSaveModel {


    @SerializedName("idno")
    private var idno: Int = 0;

    @SerializedName("user_key")
    private var userKey: String? = null

    @SerializedName("messageKey")
    private var messageKey: String? = null

    @SerializedName("sendrequestDateTime")
    private var sendrequestDateTime: String? = null



    constructor(){}
    constructor(idno:Int, userKey:String, messageKey:String, sendrequestDateTime:Date){

        this.idno = idno
        this.messageKey = messageKey
        this.userKey = userKey
        this.sendrequestDateTime = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").format(sendrequestDateTime)

    }


}