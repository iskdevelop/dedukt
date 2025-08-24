package com.iskportal.dedukt.lsp.structures

/**
 * Represents a related message and source code location for a diagnostic.
 * This should be used to point to code locations that cause or are related to
 * a diagnostics, e.g when duplicating a symbol in a scope.
 */
interface DiagnosticRelatedInformation {
    /**
     * The location of this related diagnostic information.
     */
    val location: Location

    /**
     * The message of this related diagnostic information.
     */
    val message: String
}