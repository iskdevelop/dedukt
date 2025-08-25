package com.iskportal.dedukt.lsp.structures.mark

/**
 * Client capabilities specific to the used markdown parser.
 *
 * @since 3.16.0
 */
interface MarkdownClientCapabilities {
    /**
     * The name of the parser.
     */
    val parser: String

    /**
     * The version of the parser.
     */
    val version: String?

    /**
     * A list of HTML tags that the client allows / supports in
     * Markdown.
     *
     * @since 3.17.0
     */
    val allowedTags: List<String>?
}