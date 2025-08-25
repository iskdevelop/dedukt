package com.iskportal.dedukt.lsp

import kotlinx.serialization.*
import kotlinx.serialization.json.*
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.File
import java.io.FileWriter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Serializable
data class JsonRpc(
    val jsonrpc: String,
    val method: String,
    val id: Int,
    val params: JsonElement = JsonObject(emptyMap()),
)

object Logger {
    private val logFile = File("/home/kid-a/projects/dedukt/log.txt")
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")

    fun log(level: String, message: String) {
        val timestamp = LocalDateTime.now().format(dateFormatter)
        val logEntry = "[$timestamp] [$level] $message\n"

        try {
            FileWriter(logFile, true).use { writer ->
                writer.write(logEntry)
            }
        } catch (e: Exception) {
            System.err.println("Failed to write to log: ${e.message}")
        }
    }

    fun info(message: String) = log("INFO", message)
    fun error(message: String) = log("ERROR", message)
    fun debug(message: String) = log("DEBUG", message)
}

fun main() {
    Logger.info("LSP Server starting...")

    val reader = BufferedReader(InputStreamReader(System.`in`))
    val json = Json { ignoreUnknownKeys = true }

    Logger.info("Starting message loop")

    while (true) {
        try {
            // Read the Content-Length header
            val headerLine = reader.readLine() ?: break
            Logger.debug("Read header line: $headerLine")

            if (!headerLine.startsWith("Content-Length:")) {
                Logger.debug("Skipping non-Content-Length header: $headerLine")
                continue
            }

            // Extract content length
            val contentLength = headerLine.substringAfter("Content-Length:")
                .trim()
                .toIntOrNull()

            if (contentLength == null) {
                Logger.error("Invalid Content-Length: $headerLine")
                continue
            }

            Logger.debug("Content length: $contentLength")

            // Read the empty line (\r\n)
            reader.readLine()

            // Read the JSON content
            val buffer = CharArray(contentLength)
            var totalRead = 0

            while (totalRead < contentLength) {
                val read = reader.read(buffer, totalRead, contentLength - totalRead)
                if (read == -1) break
                totalRead += read
            }

            val jsonContent = String(buffer, 0, totalRead)
            Logger.debug("Received JSON: $jsonContent")

            // Parse and handle the JSON-RPC message
            val message = json.decodeFromString<JsonRpc>(jsonContent)
            Logger.info("Processing message: ${message.method} (id: ${message.id})")
            handleMessage(message)

        } catch (e: Exception) {
            Logger.error("Error processing message: ${e.message}")
            System.err.println("Error processing message: ${e.message}")
        }
    }

    Logger.info("LSP Server shutting down")
}

fun handleMessage(message: JsonRpc) {
    Logger.info("Handling method: ${message.method}")
    Logger.debug("Message ID: ${message.id}")
    Logger.debug("Message params: ${message.params}")

    // Add your LSP message handling logic here
    when (message.method) {
        "initialize" -> {
            Logger.info("Received initialize request")
            handleInitialize(message)
        }
        "textDocument/didOpen" -> {
            Logger.info("Document opened notification")
            handleDidOpen(message)
        }
        "textDocument/hover" -> {
            Logger.info("Hover request received")
            handleHover(message)
        }
        else -> {
            Logger.info("Unhandled method: ${message.method}")
        }
    }
}

fun handleInitialize(message: JsonRpc) {
    Logger.info("Processing initialize request for client")
    // Handle initialize request
}

fun handleDidOpen(message: JsonRpc) {
    Logger.info("Processing document open notification")
    // Handle document open notification
}

fun handleHover(message: JsonRpc) {
    Logger.info("Processing hover request")
    // Handle hover request
}