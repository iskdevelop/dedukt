# Introduction 

**DeduKt Pure** (or simply DeduKt referring to the language and not the project) is inspired by languages like **Kotlin**, **Go**, and **Haskell**, combining their expressive strengths with a custom syntax designed for symbolic reasoning, proof verification, and numerical evaluation. This language is versatile, extending from basic symbolic manipulations (such as differentiation and simplification) to complex mathematical constructs (like tensor operations or modular arithmetic).

The core philosophy behind DeduKt is a **structure-first** approach, where mathematical constructs are treated as composable structures, rather than isolated functions or expressions. This model enables **symbolic computation**, enabling **rigorous proof generation** and **intelligent reasoning** over algebraic expressions.

This document provides an overview of **DeduKt’s syntax** and **grammar**. It covers the basic lexical structure, operators, expressions, and advanced constructs used within the language. It is intended for both developers building DeduKt-based tools and end-users looking to understand the language’s capabilities and syntax.
# Notation
This section, similar to Kotlin Specification document uses a BNF-based notation similar to EBNF with the following conventions:
- Any sequence of characters given in single quotes and mono-scape font denote a terminal sequence.
- Special terminal sequences that needs specification are given in angle brackets `<...>`.
- Normal parentheses are used sparingly to specify priority between other operations.
- A sequence of rules $A$ and $B$ : $(A B)$.
- Choice between rules $A$ and $B$: $(A|B)$.
- Optional use of rule $A$: $[A]$
- Repetition of rule $A$; ${A}$

> Rule names starting with capital letters denote lexical rules, while rule names starting with lowercase letters denote syntactic rules.
## Lexical Grammar
### White spaces and Comments

| Name                 | Syntax                                                                                |
| -------------------- | ------------------------------------------------------------------------------------- |
| Line Feed (LF)       | $<\text{unicode character Line Feed U+000A}>$                                         |
| Carriage Return (CR) | $<\text{unicode character Carriage Return U+000D}>$                                   |
| ShebangLine          | $'\# !' \ \{<\text{ any character excluding CR and LF}>\}$                            |
| DelimitedComment     | $'/*' \ \{ DeliminatedComment \vert <\text{any character}> \} \ '*/'$                 |
| LineComment          | $'//' \ \{ < \text{any character excluding LF and CR}>\}$                             |
| WS                   | $<\text{one of the following characters: SPACE u+0020, TAB U+0009 Form Feed U+000C}>$ |
| NL                   | $LF \vert (CR \  [LF])$                                                               |
| Hidden               | $DeliminatedComment \vert LineComment \vert WS$                                       |
### Keywords and Operators

| Name     | Syntax                           |
| -------- | -------------------------------- |
| Reserved | $'\dots'$                        |
| Dot      | $'.'$                            |
| Comma    | $','$                            |
| LParen   | $'('$                            |
| RParen   | $')'$                            |
| LSquare  | $'['$                            |
| RSquare  | $']'$                            |
| LCurl    | $'\{'$                           |
| RCurl    | $'\}'$                           |
| Conj     | $'\&\&' \vert '\text{and}'$      |
| Disj     | $'\vert\vert' \vert '\text{or}'$ |
|          |                                  |
|          |                                  |
|          |                                  |
|          |                                  |
|          |                                  |
|          |                                  |
|          |                                  |
|          |                                  |

### Syntax Examples


```kotlin
rule OperatorSimplification {
	transform {
		Expression:1 Operator:2 Expression:3 -> :2 :1 :3
	}
}

axiom Commutativity {
	equivalence {
		Expression:1 Operator:2 Expression:3,
		Expression:3 Operator:2 Expression:1
	}
}


abstract type Operator<T: Number, U: Number> {
	syntax: Rule
	rewritingRule: Rule	
}

type BinaryOperator :: Operator<2,1>

operator + : BinaryOperator {
	syntax {
		%1 this %2,
		this %1 %2,
		
	}
}
```