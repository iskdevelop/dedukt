package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.range.Range
import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

/**
 * Represents a location inside a resource, such as a line inside a text file.
 */
interface Location {
    val uri: DocumentUri
    val range: Range
}