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

// Lexer Tokens
// Meta-characters
COLON  : ':';        // prefix for Bind Parameter name 
COMMA  : ',';        // projection term separator
DOT    : '.';        // field path separator
LPAREN : '(';        // operator left parenthesis
RPAREN : ')';        // operator right parenthesis

EQUALS       : '=';
NOT_EQUALS : '!=';
EQUALS_IGNORECASE: '~=';
GREATER      : '>';
GREATER_OR_EQUAL : '>=';
LESS       : '<';
LESS_OR_EQUAL  : '<=';
LIKE         : 'LIKE';

// Keywords
AND     : A N D;
AS      : A S;
ASC     : A S C ;
AVG     : A V G;
COUNT   : C O U N T;
DESC    : D E S C;
EXISTS  : E X I S T S;
FROM    : F R O M;
GROUP_BY: G R O U P B Y;
IS_NULL : I S N U L L;
IS_NOT_NULL : I S N O T N U L L;
LIMIT   : L I M I T;
MAX     : M A X;
MIN     : M I N;
NOT     : N O T;
OR      : O R;
ORDER_BY: O R D E R B Y;
SELECT  : S E L E C T;
SKIP    : S K I P;
SUM     : S U M;
WHERE   : W H E R E;

fragment A: 'a'|'A';
fragment B: 'b'|'B';
fragment C: 'c'|'C';
fragment D: 'd'|'D';
fragment E: 'e'|'E';
fragment F: 'f'|'F';
fragment G: 'g'|'G';
fragment H: 'h'|'H';
fragment I: 'i'|'I';
fragment J: 'j'|'J';
fragment K: 'k'|'K';
fragment L: 'l'|'L';
fragment M: 'm'|'M';
fragment N: 'n'|'N';
fragment O: 'o'|'O';
fragment P: 'p'|'P';
fragment Q: 'q'|'Q';
fragment R: 'r'|'R';
fragment S: 's'|'S';
fragment T: 't'|'T';
fragment U: 'u'|'U';
fragment V: 'v'|'V';
fragment W: 'w'|'W';
fragment X: 'x'|'X';
fragment Y: 'y'|'Y';
fragment Z: 'z'|'Z';

IDENTIFIER : [a-zA-Z]+;

// Ignore Whitespace in common mode but not inside String Literals
WS : (' '|'\t'|'\r'|'\n')+ -> skip ; 

// --------   Basic character set that can appear in a String Literal ----- 
// ------- Switching Lexer mode inside a single quote to preserve white spaces --- 
OPENSTRING: '\'' -> mode(STRINGMODE), pushMode(STRINGMODE);
mode STRINGMODE;

// ------- String literal is any sequence of characters preserving spaces and escaping --- 
STRING_LITERAL : ~['\'']*;
CLOSESTRING: '\'' -> popMode, mode(DEFAULT_MODE);