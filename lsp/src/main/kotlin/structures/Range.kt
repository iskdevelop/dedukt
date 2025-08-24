package com.iskportal.dedukt.lsp.structures

/**
 * A range in a text document expressed as (zero-based) start and end positions. A range is comparable to a selection in an editor. Therefore, the end position is exclusive. If you want to specify a range that contains a line including the line ending character(s) then use an end position denoting the start of the next line. For example:
 * @param start start position of the range
 * @param end end position of the range
 */
interface Range {
    val start: Position
    val end: Position
}