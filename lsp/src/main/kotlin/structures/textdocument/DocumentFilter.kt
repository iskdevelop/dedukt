package com.iskportal.dedukt.lsp.structures.textdocument

interface DocumentFilter {
    /**
     * A language id, like `typescript`.
     */
    val language: String

    /**
     * A Uri scheme, like `file` or `untitled`.
     */
    val scheme: String

    /**
     * A glob pattern, like `*.{ts,js}`.
     */
    val pattern: String?
}