package com.iskportal.dedukt.lsp.structures

interface WorkDoneProgressEnd {

    val kind: String

    /**
     * Optional, a final message indicating to for example indicate the outcome
     * of the operation.
     */
    val message: String?
}