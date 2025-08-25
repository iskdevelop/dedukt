package com.iskportal.dedukt.lsp.structures.diagnostic

/**
 * Structure to capture a description for an error code.
 *
 * @since 3.16.0
 */
interface CodeDescription {
    /**
     * An URI to open with more information about the diagnostic error.
     */
    val href: URI;
}