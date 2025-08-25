package com.iskportal.dedukt.lsp.structures

/**
 * Delete file options
 */
interface DeleteFileOptions {
    /**
     * Delete the content recursively if a folder is denoted.
     */
    val recursive: Boolean?

    /**
     * Ignore the operation if the file doesn't exist.
     */
    val ignoreIfNotExists: Boolean?
}