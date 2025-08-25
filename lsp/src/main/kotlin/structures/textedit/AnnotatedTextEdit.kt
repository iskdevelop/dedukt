package com.iskportal.dedukt.lsp.structures

/**
 * A special text edit with an additional change annotation.
 *
 * @since 3.16.0.
 */
interface AnnotatedTextEdit : TextEdit {
    /**
     * The actual annotation identifier.
     */
    val annotationId: ChangeAnnotationIdentifier
}