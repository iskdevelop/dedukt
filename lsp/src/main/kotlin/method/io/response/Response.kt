package com.iskportal.dedukt.lsp.method.io.response

import com.iskportal.dedukt.lsp.rpc.JsonRpc
import kotlinx.serialization.Serializable

/**
 * Response is the data class that would be encoded and sent over to IDE for use.
 * @param jsonrpc jsonrpc version
 * @param id is the identifier of request
 * @param result is the result object if available
 * @param error is the error object if available
 * @see JsonRpc
 * @see ResponseCode
 * @see ResponseError
 */
@Serializable
data class Response(
    override val jsonrpc: String,
    val id: Int,
    val result: ResponseCode? = null,
    val error: ResponseError? = null
): JsonRpc

