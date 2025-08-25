package com.iskportal.dedukt.lsp.structures.file

/**
 * Options to create a file.
 */
interface CreateFileOptions {
    /**
     * Overwrite existing file. Overwrite wins over `ignoreIfExists`
     */
    val overwrite: Boolean?

    /**
     * Ignore if exists.
     */
    val ignoreIfExists: Boolean?
}