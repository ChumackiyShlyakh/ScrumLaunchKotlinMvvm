package com.omnianobis.kotlinmvvmdagger.data.entity.network

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("message") val message: String?
)