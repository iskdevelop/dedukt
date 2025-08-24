package com.iskportal.dedukt.lsp.structures

/**
 * Position in a text document expressed as zero-based line and zero-based character offset. A position is between two characters like an ‘insert’ cursor in an editor. Special values like for example -1 to denote the end of a line are not supported.
 *
 */
interface Position {
    /**
     * Line position in a document (zero-based).
     */
    val line: PositiveInt;

    /**
     * Character offset on a line in a document (zero-based). The meaning of this
     * offset is determined by the negotiated `PositionEncodingKind`.
     *
     * If the character value is greater than the line length it defaults back
     * to the line length.
     */
    val character: PositiveInt
}