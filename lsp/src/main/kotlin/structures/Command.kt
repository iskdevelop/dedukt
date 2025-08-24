package com.iskportal.dedukt.lsp.structures

interface Command {
    /**
     * Title of the command, like `save`.
     */
    val title: String
    /**
     * The identifier of the actual command handler.
     */
    val command: String
    /**
     * Arguments that the command handler should be
     * invoked with.
     */
    val arguments: List<Any>?;
}