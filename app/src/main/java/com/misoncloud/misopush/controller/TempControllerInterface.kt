package com.misoncloud.misopush.controller

import com.misoncloud.misopush.model.temp.Contributors
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TempControllerInterface {

    @GET("repos/{owner}/{repo}/contributors")
    fun requestContributors(

        @Path("owner") owner:String,
        @Path("repo") repo:String

    ) : Single<Array<Contributors>>


}

