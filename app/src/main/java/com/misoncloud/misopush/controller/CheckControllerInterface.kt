package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.check.KeepAliveRequestModel
import com.misoncloud.misopush.model.check.KeepAliveResponseModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface CheckControllerInterface {

    @POST("check/alive.vsj")
    fun keepAlive(
        @Body param: KeepAliveRequestModel
    ) : Single<KeepAliveResponseModel>


}