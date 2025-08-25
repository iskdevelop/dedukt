package com.iskportal.dedukt.lsp.structures

/**
 * Additional information that describes document changes.
 *
 * @since 3.16.0
 */
interface ChangeAnnotation {
    /**
     * A human-readable string describing the actual change. The string
     * is rendered prominent in the user interface.
     */
    val label: String

    /**
     * A flag which indicates that user confirmation is needed
     * before applying the change.
     */
   val needsConfirmation: Boolean?

    /**
     * A human-readable string which is rendered less prominent in
     * the user interface.
     */
   val description: String?
}