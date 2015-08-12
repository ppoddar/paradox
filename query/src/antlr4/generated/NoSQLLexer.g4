lexer grammar NoSQLLexer;

@header {
package antlr4.generated;
}

LETTER      : 'a'..'z'|'A'..'Z' ;
DIGIT       : '0'..'9' ;
UNDERSCORE  : '_' ;
WILDCARD    : '*';
DOUBLEQUOTE : '"';  // single quote is defined later after lexer mode switching rule
BACKSLASH   : '\\' ;
/** ------------------ escaped characters -------------------- */
R           : 'r' ;   
F           : 'f' ;
N           : 'n' ;
T           : 't' ;
B           : 'b' ;
ZERO        : '0' ;

// Lexer Tokens
// Meta-characters
COLON  : ':';        // prefix for Bind Parameter name 
COMMA  : ',';        // projection term separator
DOT    : '.';        // field path separator
LPAREN : '(';        // operator left parenthesis
RPAREN : ')';        // operator right parenthesis

EQUALS       : '=';
EQUALS_IGNORECASE: '~=';
GREATER      : '>';
GREATER_OR_EQUAL : '>=';
LESS       : '<';
LESS_OR_EQUAL  : '<=';
LIKE         : 'LIKE';

// Keywords
// ANTLR grammar does not have native support for case-sensitivity of keywords
// Case-sensitivity is incorporated by overriding the lexer input stream
AND     : 'AND';
AS      : 'AS';
ASC     : 'ASC' ;
AVG     : 'AVG' ;
COUNT   : 'COUNT';
DESC    : 'DESC';
EXISTS  : 'EXISTS';
FROM    : 'FROM';
GROUP_BY: 'GROUP BY';
IS_NULL : 'IS NULL';
IS_NOT_NULL : 'IS NOT NULL';
LIMIT   : 'LIMIT';
MAX     : 'MAX';
MIN     : 'MIN';
NOT     : 'NOT';
OR      : 'OR';
ORDER_BY: 'ORDER BY';
SELECT  : 'SELECT';
SKIP    : 'SKIP';
SUM     : 'SUM';
WHERE   : 'WHERE';

// Ignore Whitespace in common mode but not inside String Literals
WS : (' '|'\t'|'\r'|'\n')+ -> skip ; 

// --------   Basic character set that can appear in a String Literal ----- 
// ------- Switching Lexer mode inside a single quote to preserve white spaces --- 
OPENSTRING: '\'' -> mode(STRINGMODE), pushMode(STRINGMODE);
mode STRINGMODE;

// ------- String literal is any sequence of characters preserving spaces and escaping --- 
STRING_LITERAL : ~['\'']*;
CLOSESTRING: '\'' -> popMode, mode(DEFAULT_MODE);