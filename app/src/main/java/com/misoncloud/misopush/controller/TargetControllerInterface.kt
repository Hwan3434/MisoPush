package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.target.TargetSaveModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface TargetControllerInterface {

    @POST("target/insert.vsj")
    fun targetInsert(
        @Body param:TargetSaveModel
    ) : Single<TargetSaveModel>


    @POST("target/delete/device.vsj")
    fun targetDeleteDevice(
        @Body param:TargetSaveModel
    ) : Single<TargetSaveModel>

    @POST("target/update/devicetoken.vsj")
    fun targetUpdateDevicetoken(
        @Body param:TargetSaveModel
    ) : Single<TargetSaveModel>



}