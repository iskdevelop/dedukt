lexer grammar LexerGrammar;

// Lexer rules
IMPORT : 'import' ;
STATIC : 'static' ;
PACKAGE: 'package';
VAL: 'val';
AXIOM : 'axiom';

// TYPE
TYPE : 'type';
WHERE : 'where';
IN: 'in';
OUT: 'out';
SUBTYPE : '<:';
SUPERTYPE: ':>';

// FUNCTION
FUN : 'fun';

// Notation
NOTATION: 'notation';

// STRUCTURE
STRUCTURE : 'structure';
// THEORY
THEORY : 'theory';

DOT : '.' ;
SEMICOLON : ';' ;
COLON: ':';
DOUBLECOLON: '::';
COMMA: ',';
STAR : '*' ;
ASSIGN: '=';
ARROW: '->';
LANGLE: '<';
RANGLE: '>';
LBRACE : '{';
RBRACE : '}';
LPAREN : '(';
RPAREN : ')';

// Standard identifier (more restrictive)
IDENTIFIER
    : [a-zA-Z_$] [a-zA-Z0-9_$]*
    ;

// Super identifier - catches anything that's not whitespace or other defined tokens
// Must come AFTER all other token definitions

DIGIT :[0-9]+;
WS : [ \t\r\n]+ -> skip ;
SPACE: ' ';

SUPERIDENTIFIER
    : ~[{};:,*=<>().]+
    ;