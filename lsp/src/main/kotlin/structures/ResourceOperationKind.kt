package com.iskportal.dedukt.lsp.structures

enum class ResourceOperationKind(resourceOperationKindString: String) {

    /**
     * Supports creating new files and folders.
     */
    Create("create"),

    /**
     * Supports renaming existing files and folders.
     */
    Rename("rename"),

    /**
     * Supports deleting existing files and folders.
     */
    Delete("delete");
}