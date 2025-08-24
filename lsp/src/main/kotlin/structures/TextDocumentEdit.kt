package com.iskportal.dedukt.lsp.structures

interface TextDocumentEdit {
    /**
     * The text document to change.
     */
    val textDocument: OptionalVersionedTextDocumentIdentifier

    /**
     * The edits to be applied.
     *
     * @since 3.16.0 - support for AnnotatedTextEdit. This is guarded by the
     * client capability `workspace.workspaceEdit.changeAnnotationSupport`
     */
    val edits: List<TextEdit>
}