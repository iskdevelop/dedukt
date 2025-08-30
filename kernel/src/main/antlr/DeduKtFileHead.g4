grammar DeduKtFileHead;

import LexerGrammar;

head: packageDeclaration importDeclaration*?;

packageDeclaration : PACKAGE qualifiedPackageName;
importDeclaration : IMPORT qualifiedImportName;

qualifiedImportName: qualifiedPackageName (DOT STAR)?;

qualifiedPackageName : IDENTIFIER (DOT IDENTIFIER);