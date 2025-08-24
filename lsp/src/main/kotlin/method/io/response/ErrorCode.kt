package com.iskportal.dedukt.lsp.method.io.response

/**
 * Error Codes and Messages based on LSP Specification 3.17.0
 * [LSP Specification Documentation](https://microsoft.github.io/language-server-protocol/specifications/lsp/3.17/specification/)
 */
enum class ErrorCode(val code: Int, val message: String) {
    // Defined by JSON-RPC
    ParseError(-32700, "Parse error"),
    InvalidRequest(-32600, "Invalid request"),
    MethodNotFound(-32601, "Method not found"),
    InvalidParams(-32602, "Invalid params"),
    InternalError(-32603, "Internal error"),

    /**
     * This is the start range of JSON-RPC reserved error codes.
     * It doesn't denote a real error code. No LSP error codes should
     * be defined between the start and end range. For backwards
     * compatibility the `ServerNotInitialized` and the `UnknownErrorCode`
     * are left in the range.
     *
     * @since 3.16.0
     */
    JsonrpcReservedErrorRangeStart(-32099, "Json-Rpc reserved error range start"),



    /**
     * Error code indicating that a server received a notification or
     * request before the server received the `initialize` request.
     */
    ServerNotInitialized(-32002, "Server not initialized"),
    UnknownErrorCode(-32001, "Unknown error"),

    /**
     * This is the end range of JSON-RPC reserved error codes.
     * It doesn't denote a real error code.
     *
     * @since 3.16.0
     */
    JsonrpcReservedErrorRangeEnd(-32000, "Jsonrpc reserved error range end"),

    /**
     * This is the start range of LSP reserved error codes.
     * It doesn't denote a real error code.
     *
     * @since 3.16.0
     */
    LspReservedErrorRangeStart(-32899, "Lsp reserved error range start"),

    /**
     * A request failed, but it was syntactically correct, e.g. the
     * method name was known and the parameters were valid. The error
     * message should contain human-readable information about why
     * the request failed.
     *
     * @since 3.17.0
     */
    RequestFailed(-32803, "Request failed"),

    /**
     * The server cancelled the request. This error code should
     * only be used for requests that explicitly support being
     * server cancellable.
     *
     * @since 3.17.0
     */
    ServerCancelled(-32802, "Server cancelled"),

    /**
     * The server detected that the content of a document got
     * modified outside normal conditions. A server should
     * NOT send this error code if it detects a content change
     * in its unprocessed messages. The result even computed
     * on an older state might still be useful for the client.
     *
     * If a client decides that a result is not of any use anymore
     * the client should cancel the request.
     */
    ContentModified(-32801, "Content modified"),

    /**
     * The client has canceled a request and a server has detected
     * the cancel.
     */
    RequestCancelled(-32800, "Request cancelled"),

    /**
     * This is the end range of LSP reserved error codes.
     * It doesn't denote a real error code.
     *
     * @since 3.16.0
     */
    LspReservedErrorRangeEnd(-32800, "Lsp reserved error range end"),;

    fun getCode(): Int {
        return this.code
    }

    fun getMessage(): String {
        return this.message
    }

    fun getError(): Pair<Int, String> {
        return this.code to this.message
    }


}