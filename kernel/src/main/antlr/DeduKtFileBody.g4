grammar DeduKtFileBody;
import Declarations,Context;



body
    : statement*?
    ;
statement
    : declaration
    ;


declaration
    : objectDeclaration
    | variableDeclaration
    ;
