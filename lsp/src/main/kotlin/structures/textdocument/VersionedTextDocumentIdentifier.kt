package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.textdocument.TextDocumentIdentifier

/**
 * An identifier to denote a specific version of a text document. This information usually flows from the client to the server.
 */
interface VersionedTextDocumentIdentifier : TextDocumentIdentifier {
    /**
     * The version number of this document.
     *
     * The version number of a document will increase after each change,
     * including undo/redo. The number doesn't need to be consecutive.
     */
    val version: Int
}