package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.sample.SampleJsonModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface VersionControllerInterface {


    @GET("version/check.vsj")
    fun requestContributors(
        @Path("owner") owner:String,
        @Path("repo") repo:String
    ) : Single<Array<SampleJsonModel>>




}