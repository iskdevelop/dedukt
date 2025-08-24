package com.iskportal.dedukt.lsp.structures

/**
 * Represents a link between a source and a target location.
 */
interface LocationLink {

    /**
     * Span of the origin of this link.
     *
     * Used as the underlined span for mouse interaction. Defaults to the word
     * range at the mouse position.
     */
    val originSelectionRange: Range?

    /**
     * The target resource identifier of this link.
     */
    val targetUri: DocumentUri

    /**
     * The full target range of this link. If the target for example is a symbol
     * then target range is the range enclosing this symbol not including
     * leading/trailing whitespace but everything else like comments. This
     * information is typically used to highlight the range in the editor.
     */
    val targetRange: Range

    /**
     * The range that should be selected and revealed when this link is being
     * followed, e.g the name of a function. Must be contained by the
     * `targetRange`. See also `DocumentSymbol#range`
     */
    val targetSelectionRange: Range
}