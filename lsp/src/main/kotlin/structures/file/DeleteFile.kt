package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.textedit.ChangeAnnotationIdentifier
import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

/**
 * Delete file operation
 */
interface DeleteFile {
    /**
     * A deletion
     */
    val kind: String

    /**
     * The file to delete.
     */
    val uri: DocumentUri

    /**
     * Delete options.
     */
    val options: DeleteFileOptions?

    /**
     * An optional annotation identifier describing the operation.
     *
     * @since 3.16.0
     */
    val annotationId: ChangeAnnotationIdentifier?
}