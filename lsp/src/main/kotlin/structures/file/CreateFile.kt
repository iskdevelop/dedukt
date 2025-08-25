package com.iskportal.dedukt.lsp.structures.file

import com.iskportal.dedukt.lsp.structures.textedit.ChangeAnnotationIdentifier
import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

/**
 * Create file operation
 */
interface CreateFile {
    /**
     * A creation
     */
    val kind: String

    /**
     * The resource to create.
     */
    val uri: DocumentUri

    /**
     * Additional options
     */
    val options: CreateFileOptions?;

    /**
     * An optional annotation identifier describing the operation.
     *
     * @since 3.16.0
     */
    val annotationId: ChangeAnnotationIdentifier?
}