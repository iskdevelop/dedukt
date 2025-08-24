package com.iskportal.dedukt.lsp.structures

enum class DiagnosticSeverity(severityCode: Int) {
    /**
     * Reports an error.
     */
    Error(1),
    /**
     * Reports a warning.
     */
    Warning(2),
    /**
     * Reports an information.
     */
    Information(3),
    /**
     * Reports a hint.
     */
    Hint(4);

    companion object {
        // TODO
    }
}