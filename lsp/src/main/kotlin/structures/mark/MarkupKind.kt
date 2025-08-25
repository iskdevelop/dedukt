package com.iskportal.dedukt.lsp.structures

/**
 * Describes the content type that a client supports in various
 * result literals like `Hover`, `ParameterInfo` or `CompletionItem`.
 *
 * Please note that `MarkupKinds` must not start with a `$`. These kinds
 * are reserved for internal usage.
 */
enum class MarkupKind(markupKindString: String) {
    /**
     * Plain text is supported as a content format
     */
    PlainText("plaintext"),

    /**
     * Markdown is supported as a content format
     */
    Markdown("markdown");
}