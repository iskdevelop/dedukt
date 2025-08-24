package com.iskportal.dedukt.lsp.utils

import com.iskportal.dedukt.lsp.method.io.response.ErrorCode
import com.iskportal.dedukt.lsp.method.io.response.ResponseError

fun ErrorCode.toResponseError(): ResponseError {
    return ResponseError(this.code, this.message)
}