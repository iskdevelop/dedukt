package com.iskportal.dedukt

import DeduKtLexer
import DeduKtParser
import DeduKtVisitor
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.*

class DeduKtPrintableTree(val tree: ParseTree) {
    override fun toString() = treeString(tree, "")

    private fun treeString(node: ParseTree, prefix: String): String {
        if(node is DeduKtParser.PrimaryExprContext && node.childCount == 1)
            return visitPrimary(node)

        if(node is TerminalNode) return visitTerminal(node)
        if(node !is RuleNode) return ""

        val name = DeduKtParser.ruleNames[node.ruleContext.ruleIndex]
        val builder = StringBuilder(name)

        for(i in 0..<node.childCount) {
            val atEnd = (i == node.childCount - 1)
            val symbol = if(atEnd) "└──" else "├──"

            val child = node.getChild(i)
            val childSymbol = if(atEnd) " " else "│"
            val childStr = treeString(child, "$prefix$childSymbol   ")

            builder.append("\n$prefix$symbol $childStr")
        }

        return "$builder"
    }

    private fun visitPrimary(node: DeduKtParser.PrimaryExprContext): String {
        val name = DeduKtParser.ruleNames[node.ruleContext.ruleIndex]
        val childStr = visitTerminal(node.getChild(0) as TerminalNode)
        return "$name ── $childStr"
    }

    private fun visitTerminal(node: TerminalNode): String {
        val id = DeduKtLexer
            .ruleNames[node.symbol.type - 1]
            .let { if("T__" in it) 'P' else it[0] }

        return "$id'$node'"
    }

}

fun main() {
    val input = "1234 + 43 - 1"
    val inputStream = CharStreams.fromString(input)

    val lexer = DeduKtLexer(inputStream)
    val tokens = CommonTokenStream(lexer)

    val parser = DeduKtParser(tokens)
    val parseTree = parser.fileStat()

    val printableTree = DeduKtPrintableTree(parseTree)
    print(printableTree)
}
