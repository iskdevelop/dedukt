package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.textedit.ChangeAnnotationIdentifier
import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

/**
 * Rename file operation
 */
interface RenameFile {
    /**
     * A renaming
     */
    val kind: String

    /**
     * The old (existing) location.
     */
    val oldUri: DocumentUri

    /**
     * The new location.
     */
    val newUri: DocumentUri

    /**
     * Rename options.
     */
    val options: RenameFileOptions?

    /**
     * An optional annotation identifier describing the operation.
     *
     * @since 3.16.0
     */
    val annotationId: ChangeAnnotationIdentifier?
}