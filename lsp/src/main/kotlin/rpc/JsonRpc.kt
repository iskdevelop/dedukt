package com.iskportal.dedukt.lsp.rpc

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.encodeToJsonElement


/**
 * JsonRpc is the root interface for communication of LSP. It is in this project as interface message is in the LSP documentation
 * [LSP Specification Documentation](https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/)
 */
interface JsonRpc {
    val jsonrpc: String
}