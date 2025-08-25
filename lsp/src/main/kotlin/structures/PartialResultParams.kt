package com.iskportal.dedukt.lsp.structures

interface PartialResultParams {
    /**
     * An optional token that a server can use to report partial results (e.g.
     * streaming) to the client.
     */
    val partialResultToken: ProgressToken;
}