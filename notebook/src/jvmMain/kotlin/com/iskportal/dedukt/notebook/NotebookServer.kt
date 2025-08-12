package com.iskportal.dedukt.notebook

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.server.response.*
import io.ktor.server.http.content.*
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import java.time.Duration

/**
 * DeduKt Notebook Server.
 * Provides web-based notebook interface for interactive computation.
 */
fun main() {
    embeddedServer(Netty, port = 8080) {
        install(WebSockets) {
            pingPeriod = Duration.ofSeconds(15)
            timeout = Duration.ofSeconds(15)
            maxFrameSize = Long.MAX_VALUE
            masking = false
        }

        routing {
            staticResources("/", "static")

            get("/") {
                call.respondText("DeduKt Notebook Server - Coming Soon!")
            }

            webSocket("/ws") {
                for (frame in incoming) {
                    if (frame is Frame.Text) {
                        val text = frame.readText()
                        send(Frame.Text("Echo: $text"))
                    }
                }
            }
        }
    }.start(wait = true)
}