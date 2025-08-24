package com.iskportal.dedukt.lsp.method.io.request

import com.iskportal.dedukt.lsp.rpc.JsonRpc
import kotlinx.serialization.Serializable

/**
 * The Request messages are the incoming messages for the Language Server. They are requested by the IDE.
 * @param jsonrpc is the jsonrpc version.
 * @param id is the request identifier.
 * @param method gives information about the method of request. For example if the user changed something in a file or opened some file, etc.
 * @param params parameters of that request
 * @see JsonRpc
 * @see RequestParameter
 */
@Serializable
data class Request(
    override val jsonrpc: String = "2.0",
    val id: Int,
    val method: String,
    val params: RequestParameter? = null
): JsonRpc

