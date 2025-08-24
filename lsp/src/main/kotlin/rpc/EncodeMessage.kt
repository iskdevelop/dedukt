package com.iskportal.dedukt.lsp.rpc

import com.iskportal.dedukt.lsp.method.io.response.Response
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

data class EncodeMessage(val message: Response) {

    val json = Json {
        encodeDefaults = true
    }
    val length: Int = messageToString().length
    fun get(): String = "Content-Length: $length\r\n\r\n${this.messageToString()}"
    fun messageToString(): String {
        return json.encodeToJsonElement(message).toString()
    }
}

