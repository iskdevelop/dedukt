grammar Application;
import LexerGrammar, Context, Declarations;

orderedExpression : LPAREN WS? (orderedExpression | baseExpression)* WS? RPAREN;


baseExpression
    : (SUPERIDENTIFIER
    | IDENTIFIER
    | DIGIT);