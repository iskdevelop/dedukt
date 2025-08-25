package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.file.ProgressToken

interface PartialResultParams {
    /**
     * An optional token that a server can use to report partial results (e.g.
     * streaming) to the client.
     */
    val partialResultToken: ProgressToken;
}