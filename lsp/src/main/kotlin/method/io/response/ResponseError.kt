package com.iskportal.dedukt.lsp.method.io.response

import kotlinx.serialization.Serializable

@Serializable
data class ResponseError(
    val code: Int,
    val message: String,
    val data: ResponseErrorData? = null
)

