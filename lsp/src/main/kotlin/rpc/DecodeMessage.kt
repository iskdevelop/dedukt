package com.iskportal.dedukt.lsp.rpc

import com.iskportal.dedukt.lsp.method.io.request.Request
import kotlinx.serialization.json.Json

data class DecodeMessage(val message: ByteArray) {
    private fun extractContent(): Pair<Request, Int> {
        val separatedContentAndHeader = message.decodeToString()
            .split("\r\n\r\n")
        val contentLength = separatedContentAndHeader.first().split(": ")[1].toInt()
        val content = Json.decodeFromString<Request>(separatedContentAndHeader[1])
        return content to contentLength
    }

    val extractedContent = extractContent()
    val json = extractedContent.first
    val contentLength = extractedContent.second

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DecodeMessage

        if (!message.contentEquals(other.message)) return false

        return true
    }

    override fun hashCode(): Int {
        return message.contentHashCode()
    }

}