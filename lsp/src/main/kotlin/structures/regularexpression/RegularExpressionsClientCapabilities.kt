package com.iskportal.dedukt.lsp.structures.regularexpression

/**
 * Client capabilities specific to regular expressions.
 */
interface RegularExpressionsClientCapabilities {
    /**
     * The engine's name.
     */
    val engine: String;

    /**
     * The engine's version.
     */
    val version: String?;
}