package com.iskportal.dedukt.lsp.structures.file

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