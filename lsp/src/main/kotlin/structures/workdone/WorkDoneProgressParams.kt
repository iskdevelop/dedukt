package com.iskportal.dedukt.lsp.structures

interface WorkDoneProgressParams {
    /**
     * An optional token that a server can use to report work done progress.
     */
    val workDoneToken: ProgressToken?;
}