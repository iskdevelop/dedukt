package com.iskportal.dedukt.lsp.structures

/**
 * Text documents are identified using a URI. On the protocol level, URIs are passed as strings.
 */
interface TextDocumentIdentifier {
    /**
     * The text document's URI.
     */
    val uri: DocumentUri
}