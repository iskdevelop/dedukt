grammar Declarations;
import LexerGrammar, Context;

// type X<T,W,in M, out U> where T <: A, B in M :> WW2 : in SomeType :: out Typed
objectDeclaration : modelName IDENTIFIER objectSpecification;
objectSpecification: typeParameters? parametersDeclaration? subType? applicableTo? context?;

// -------- PARAMETER DECLARATION -------- \\
parametersDeclaration: WHERE (subTypeDeclaration | superTypeDeclaration) (subTypeDeclaration | superTypeDeclaration)*?;
superTypeDeclaration: types SUPERTYPE types;
subTypeDeclaration : types SUBTYPE types;
// TODO: Boolean Expressions for dependent type conditional parameterization.
//  It should be implemented when Expressions are ready.

// -------- TYPE USE AND PARAMETER -------- \\
// <SomeName, in SomeName, out SomeName, *>
typeParameters : LANGLE types  RANGLE;
// SomName, SomeName ...
types: typeUse (COMMA typeUse)*?;
// SomeName or in SomeName or out SomeName or *
typeUse : (covariantType | contravariantType | dependentType | IDENTIFIER | STAR);
// Dependent Type
dependentType : IDENTIFIER COLON IDENTIFIER;
// in SomeName
covariantType : IN IDENTIFIER;
// out SomeName
contravariantType : OUT IDENTIFIER;

// -------- Subtyping -------- \\
subType: COLON types;
applicableTo : DOUBLECOLON types;

modelName : FUN | TYPE | NOTATION | AXIOM | STRUCTURE | THEORY;


// Variable
variableDeclaration: VAL IDENTIFIER;
