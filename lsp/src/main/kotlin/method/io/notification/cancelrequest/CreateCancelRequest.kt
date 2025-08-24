package com.iskportal.dedukt.lsp.method.io.notification.cancelrequest

import com.iskportal.dedukt.lsp.method.MethodType
import com.iskportal.dedukt.lsp.method.io.notification.Notification

/**
 * Given request id it generates a notification serializable for cancellation request.
 * @param id request id to cancel
 * @return Notification class object
 * @see Notification
 */
fun createCancelRequest(id: Int): Notification {
    return Notification("2.0", MethodType.toString(MethodType.Cancellation), CancelParams(id))
}