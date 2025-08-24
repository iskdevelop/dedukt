package com.iskportal.dedukt.lsp.structures

/**
 * Represents a location inside a resource, such as a line inside a text file.
 */
interface Location {
    val uri: DocumentUri
    val range: Range
}