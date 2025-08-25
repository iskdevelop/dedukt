package com.iskportal.dedukt.lsp.structures.textdocument

import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

/**
 * An item to transfer a text document from the client to the server.
 */
interface TextDocument {
    /**
     * The text document's URI.
     */
    val uri: DocumentUri

    /**
     * The text document's language identifier.
     */
    val languageId: String

    /**
     * The version number of this document (it will increase after each
     * change, including undo/redo).
     */
    val version: Int

    /**
     * The content of the opened text document.
     */
    val text: String
}