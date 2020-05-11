package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.requestmessage.ResponseFromDeviceMessageSaveModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface RequestMessageControllerInterface {

    @POST("responsefromdevicemessage/insert.vsj")
    fun responseFromDeviceMessageInsert(
        @Body param:ResponseFromDeviceMessageSaveModel
    ) : Single<ResponseFromDeviceMessageSaveModel>


}