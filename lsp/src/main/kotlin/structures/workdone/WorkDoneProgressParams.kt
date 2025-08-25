package com.iskportal.dedukt.lsp.structures.workdone

import com.iskportal.dedukt.lsp.structures.file.ProgressToken

interface WorkDoneProgressParams {
    /**
     * An optional token that a server can use to report work done progress.
     */
    val workDoneToken: ProgressToken?;
}