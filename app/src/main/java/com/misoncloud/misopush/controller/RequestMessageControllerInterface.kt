package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.requestmessage.RequestMessageSaveModel
import com.misoncloud.misopush.model.sample.SampleJsonModel
import com.misoncloud.misopush.model.target.TargetSaveModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface RequestMessageControllerInterface {

    @POST("requestmessage/insert.vsj")
    fun requestMessageInsert(
        @Body param:RequestMessageSaveModel
    ) : Single<RequestMessageSaveModel>


}