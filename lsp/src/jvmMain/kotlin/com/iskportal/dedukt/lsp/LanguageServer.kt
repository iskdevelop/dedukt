package com.iskportal.dedukt.lsp

import org.eclipse.lsp4j.*
import org.eclipse.lsp4j.services.*
import java.util.concurrent.CompletableFuture

/**
 * DeduKt Language Server implementation.
 * Provides LSP features for the DeduKt external DSL.
 */
class LanguageServer : LanguageServer, LanguageClientAware {
    private lateinit var client: LanguageClient
    private val textDocumentService = DeduKtTextDocumentService()
    private val workspaceService = DeduKtWorkspaceService()

    override fun initialize(params: InitializeParams): CompletableFuture<InitializeResult> {
        val capabilities = ServerCapabilities().apply {
            textDocumentSync = TextDocumentSyncKind.Full
            completionProvider = CompletionOptions()
            documentHighlightProvider = true
            hoverProvider = true
        }

        return CompletableFuture.completedFuture(InitializeResult(capabilities))
    }

    override fun shutdown(): CompletableFuture<Any> {
        return CompletableFuture.completedFuture(null)
    }

    override fun exit() {
        System.exit(0)
    }

    override fun getTextDocumentService(): TextDocumentService = textDocumentService
    override fun getWorkspaceService(): WorkspaceService = workspaceService

    override fun connect(client: LanguageClient) {
        this.client = client
    }
}

fun main() {
    val launcher = LSPLauncher.createServerLauncher(
        DeduKtLanguageServer(),
        System.`in`,
        System.out
    )

    val server = launcher.remoteProxy
    launcher.startListening()
}