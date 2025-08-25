package com.iskportal.dedukt.lsp.structures.workspace

import com.iskportal.dedukt.lsp.structures.textdocument.TextDocumentEdit
import com.iskportal.dedukt.lsp.structures.textedit.ChangeAnnotation
import com.iskportal.dedukt.lsp.structures.textedit.TextEdit
import com.iskportal.dedukt.lsp.structures.uri.DocumentUri

interface WorkspaceEdit {
    /**
     * Holds changes to existing resources.
     */
    val changes: Map<DocumentUri, List<TextEdit>>

    /**
     * Depending on the client capability
     * `workspace.workspaceEdit.resourceOperations` document changes are either
     * an array of `TextDocumentEdit`s to express changes to n different text
     * documents where each text document edit addresses a specific version of
     * a text document. Or it can contain above `TextDocumentEdit`s mixed with
     * create, rename and delete file / folder operations.
     *
     * Whether a client supports versioned document edits is expressed via
     * `workspace.workspaceEdit.documentChanges` client capability.
     *
     * If a client neither supports `documentChanges` nor
     * `workspace.workspaceEdit.resourceOperations` then only plain `TextEdit`s
     * using the `changes` property are supported.
     * TODO: This value should be checked later on because the typing is not correct.
     */
    val documentChanges: List<TextDocumentEdit>

    /**
     * A map of change annotations that can be referenced in
     * `AnnotatedTextEdit`s or create, rename and delete file / folder
     * operations.
     *
     * Whether clients honor this property depends on the client capability
     * `workspace.changeAnnotationSupport`.
     *
     * @since 3.16.0
     */
    val changeAnnotations: Map<String, ChangeAnnotation>
}