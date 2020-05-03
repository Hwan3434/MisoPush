package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.sample.SampleJsonModel
import io.reactivex.Single
import retrofit2.http.*

interface SampleControllerInterface {


//    @Headers("content-type: application/json")
    @POST("sample/json.vsj")
    fun sampleJson(
        @Body pModel: SampleJsonModel
    ) : Single<SampleJsonModel>


}

