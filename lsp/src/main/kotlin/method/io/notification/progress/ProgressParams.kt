package com.iskportal.dedukt.lsp.method.io.notification.progress

import com.iskportal.dedukt.lsp.method.io.notification.NotificationParams
import kotlinx.serialization.Serializable

@Serializable
data class ProgressParams<T>(
    val token: String,
    val value: T? = null
) : NotificationParams
