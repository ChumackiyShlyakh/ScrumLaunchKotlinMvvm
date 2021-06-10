package com.omnianobis.kotlinmvvmdagger.data.network.services

import com.omnianobis.kotlinmvvmdagger.data.entity.network.ItemResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface ApiServices {

    @GET("/en/web/good-radio-online/api-get-category")
    fun getListAsync(): Deferred<List<ItemResponse>>

}