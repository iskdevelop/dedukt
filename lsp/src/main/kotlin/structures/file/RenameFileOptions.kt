package com.iskportal.dedukt.lsp.structures

/**
 * Rename file options
 */
interface RenameFileOptions {
    /**
     * Overwrite target if existing. Overwrite wins over `ignoreIfExists`
     */
    val overwrite: Boolean?

    /**
     * Ignores if target exists.
     */
    val ignoreIfExists: Boolean?
}