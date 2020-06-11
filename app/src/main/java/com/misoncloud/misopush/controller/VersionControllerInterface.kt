package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.version.AppVersionApiRequestModel
import com.misoncloud.misopush.model.version.AppVersionHistoryModel
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface VersionControllerInterface {


    @POST("version/check.vsj")
    fun versionCheck(
        @Body param:AppVersionApiRequestModel
    ) : Single<AppVersionHistoryModel>




}