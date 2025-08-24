package com.iskportal.dedukt.lsp.method.io.notification.cancelrequest

import com.iskportal.dedukt.lsp.method.io.notification.NotificationParams
import kotlinx.serialization.Serializable

/**
 * The base protocol offers support for request cancellation. To cancel a request, a notification message with the following properties is sent:
 * @param id request id to cancel.
 */
@Serializable
data class CancelParams(
    val id: Int
): NotificationParams