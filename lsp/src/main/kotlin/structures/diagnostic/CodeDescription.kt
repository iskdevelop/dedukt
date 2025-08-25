package com.iskportal.dedukt.lsp.structures.diagnostic

import com.iskportal.dedukt.lsp.structures.uri.Uri

/**
 * Structure to capture a description for an error code.
 *
 * @since 3.16.0
 */
interface CodeDescription {
    /**
     * `A URI to open with more information about the diagnostic error.
     */
    val href: Uri;
}