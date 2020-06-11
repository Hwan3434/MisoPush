package com.misoncloud.misopush.model.check

import com.google.gson.annotations.SerializedName
import com.misoncloud.misopush.model.ResultModel

class KeepAliveResponseModel {


    @SerializedName("result")
    private var resultModel: ResultModel? = null

    @SerializedName("message")
    private var message: String? = null

    @SerializedName("code")
    private var code: Int? = null

    @SerializedName("data")
    private var data: String? = null


}