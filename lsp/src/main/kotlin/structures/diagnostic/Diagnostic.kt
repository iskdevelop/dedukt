package com.iskportal.dedukt.lsp.structures

import com.iskportal.dedukt.lsp.structures.range.Range

interface Diagnostic {
    /**
     * The range at which the message applies.
     */
    val range: Range

    /**
     * The diagnostic's severity. To avoid interpretation mismatches when a
     * server is used with different clients it is highly recommended that
     * servers always provide a severity value. If omitted, it’s recommended
     * for the client to interpret it as an Error severity.
     */
    val severity: DiagnosticSeverity

    /**
     * The diagnostic's code, which might appear in the user interface.
     */
    val code: Int?

    /**
     * An optional property to describe the error code.
     *
     * @since 3.16.0
     */
    val codeDescription: CodeDescription

    /**
     * A human-readable string describing the source of this
     * diagnostic, e.g. 'typescript' or 'super lint'.
     */
    val source: String

    /**
     * The diagnostic's message.
     */
    val message: String

    /**
     * Additional metadata about the diagnostic.
     *
     * @since 3.15.0
     */
    val tags: List<DiagnosticTag>?

    /**
     * An array of related diagnostic information, e.g. when symbol-names within
     * a scope collide all definitions can be marked via this property.
     */
    val relatedInformation: List<DiagnosticRelatedInformation>?;

    /**
     * A data entry field that is preserved between a
     * `textDocument/publishDiagnostics` notification and
     * `textDocument/codeAction` request.
     *
     * @since 3.16.0
     */
    val data: Any
}