package com.iskportal.dedukt.lsp.structures.position

/**
 * A set of predefined position encoding kinds.
 *
 * @since 3.17.0
 */
enum class PositionEncodingKind(val stringEncodingKind: PositionEncodingKindType) {

    /**
     * Character offsets count UTF-8 code units (e.g bytes).
     */
    UTF8("utf-8"),

    /**
     * Character offsets count UTF-16 code units.
     *
     * This is the default and must always be supported
     * by servers
     */
    UTF16("utf-16"),

    /**
     * Character offsets count UTF-32 code units.
     *
     * Implementation note: these are the same as Unicode code points,
     * so this `PositionEncodingKind` may also be used for an
     * encoding-agnostic representation of character offsets.
     */
    UTF32("utf-32");
    companion object {
        private val stringToPositionEncodingKind = values().associateBy(PositionEncodingKind::stringEncodingKind)

        // Method to get MethodType from string
        fun fromString(positionEncoding: PositionEncodingKindType): PositionEncodingKind? {
            return stringToPositionEncodingKind[positionEncoding]
        }

        // Method to get string from MethodType
        fun toString(positionEncoding: PositionEncodingKind): PositionEncodingKindType {
            return positionEncoding.stringEncodingKind
        }
    }
}