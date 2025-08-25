package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.textdocument.TextDocumentIdentifier

/**
 * An identifier which optionally denotes a specific version of a text document. This information usually flows from the server to the client.
 */
interface OptionalVersionedTextDocumentIdentifier : TextDocumentIdentifier {
    /**
     * The version number of this document. If an optional versioned text document
     * identifier is sent from the server to the client and the file is not
     * open in the editor (the server has not received an open notification
     * before) the server can send `null` to indicate that the version is
     * known and the content on disk is the master (as specified with document
     * content ownership).
     *
     * The version number of a document will increase after each change,
     * including undo/redo. The number doesn't need to be consecutive.
     */
    val version: Int?
}