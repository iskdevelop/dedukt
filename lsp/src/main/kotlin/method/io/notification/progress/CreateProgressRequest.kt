package com.iskportal.dedukt.lsp.method.io.notification.progress

import com.iskportal.dedukt.lsp.method.MethodType
import com.iskportal.dedukt.lsp.method.io.notification.Notification

/**
 * Given token generates progress notification
 */
fun createProgressRequest(token: String): Notification {
    return Notification("2.0", MethodType.toString(MethodType.Progress), ProgressParams(token))
}