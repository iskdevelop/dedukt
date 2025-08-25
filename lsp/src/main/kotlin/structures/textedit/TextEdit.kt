package com.iskportal.dedukt.lsp.structures.textedit

import com.iskportal.dedukt.lsp.structures.range.Range

/**
 * A textual edit applicable to a text document.
 */
interface TextEdit {
    /**
     * The range of the text document to be manipulated. To insert
     * text into a document create a range where start === end.
     */
    val range: Range

    /**
     * The string to be inserted. For delete operations use an
     * empty string.
     */
    val newText: String
}