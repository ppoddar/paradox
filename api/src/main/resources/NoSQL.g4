// -------------------------------------------------------
//          ANTLR4 Parser grammer rules for SQL Select Statement
// -------------------------------------------------------
grammar NoSQL;

@header {
	package antlr4.generated;
}

options {
    tokenVocab=NoSQLLexer;
}

// -------------------- Main Select statement
selectStatement : selectClause (whereClause)? (orderByClause)? (groupByClause)? (limitClause)? (skipClause)?;

selectClause  : SELECT projections FROM typeName  (alias)?;

whereClause   : WHERE predicate ;

orderByClause : ORDER_BY orderByTerm (COMMA orderByTerm)*  ;

groupByClause : GROUP_BY fieldPath;

limitClause   : LIMIT integerValue ;

skipClause    : SKIP integerValue ;



projections   : rootPath 
	| fieldPath (COMMA fieldPath)* 
	| aggregateTerm (COMMA aggregateTerm)* ;

typeName      : IDENTIFIER;      //  LETTER (LETTER | DIGIT | UNDERSCORE)*;
rootPath        : WILDCARD ;
fieldName     : IDENTIFIER; // (LETTER | UNDERSCORE) (LETTER | DIGIT | UNDERSCORE)* ;
fieldPath       : fieldName (DOT fieldName)*;
aggregateTerm : (sum | min | max | avg | count) (AS alias)?;

alias         : LETTER (LETTER | DIGIT)*;

predicate          : predicateTerm ((and|or))* ;
predicateTerm  : unaryPredicate | binaryPredicate ;
unaryPredicate  : not | isNull | isNotNull | exists ;
binaryPredicate: equals 
    | notEquals
	| equalsIgnoreCase 
	| greater 
	| greaterOrEqual 
	| less 
	| lessOrEqual 
	| like;

and  : AND predicateTerm;
or     : OR  predicateTerm;

equals         : fieldPath EQUALS  ( value | bindParam )  ;
notEquals    : fieldPath NOT_EQUALS  ( value | bindParam )  ;
equalsIgnoreCase : fieldPath EQUALS_IGNORECASE  ( value | bindParam )  ;

greater             : fieldPath GREATER ( numericValue | bindParam ) ;
greaterOrEqual : fieldPath GREATER_OR_EQUAL ( numericValue | bindParam ) ;
less                  : fieldPath LESS ( numericValue | bindParam );
lessOrEqual      : fieldPath LESS_OR_EQUAL ( numericValue | bindParam ) ;
like                   : fieldPath LIKE ( stringValue | bindParam ); 

not          : NOT LPAREN predicateTerm RPAREN ;
isNull      : IS_NULL fieldPath;
isNotNull : IS_NOT_NULL fieldPath;
exists      : EXISTS fieldPath ;

sum  : SUM LPAREN fieldPath RPAREN ;
min  : MIN LPAREN fieldPath RPAREN ;
max  : MAX LPAREN fieldPath RPAREN ;
count: COUNT LPAREN fieldPath RPAREN ;
avg  : AVG LPAREN fieldPath RPAREN ;

value          : stringValue | numericValue ;
stringValue    : OPENSTRING STRING_LITERAL CLOSESTRING;
numericValue   : integerValue | decimalValue ;
integerValue   : DIGIT+ ;
decimalValue   : integerValue DOT (integerValue) ;
bindParam      : COLON paramKey;
paramKey       : LETTER (LETTER | DIGIT)* ;

orderByTerm    : fieldPath (asc|desc)? ;
asc            : ASC;
desc           : DESC;