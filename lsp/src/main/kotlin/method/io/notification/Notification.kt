package com.iskportal.dedukt.lsp.method.io.notification

import com.iskportal.dedukt.lsp.rpc.JsonRpc
import kotlinx.serialization.Serializable


/**
 * Notification is a special form of message that the Language server provides to an IDE. It doesn't depend on any request from IDE.
 * @param jsonrpc is version of jsonrpc
 * @param method is the notification method
 * @param params are the parameters of the notification.
 * @see JsonRpc
 * @see NotificationParams
 */
@Serializable
data class Notification(
    override val jsonrpc: String,
    val method: String,
    val params: NotificationParams? = null
) : JsonRpc


