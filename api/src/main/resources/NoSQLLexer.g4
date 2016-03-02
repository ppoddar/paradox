lexer grammar NoSQLLexer;

@header {
package antlr4.generated;
}

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
AND     : [Aa][Nn][Dd];
AS      : [Aa][Ss];
ASC     : [Aa][Ss][Cc];
AVG     : [Aa][Vv][Gg];
COUNT   : [Cc][Oo][Uu][Nn][Tt];
DESC    : [Dd][Ee][Ss][Cc];
EXISTS  : [Ee][Xx][Ii][Ss][Tt][Ss];
FROM    : [Ff][Rr][Oo][Mm];
BY      : [Bb][Yy];
IS      : [Ii][Ss];
NULL    : [Nn][Uu][Ll][Ll];
GROUP_BY: [Gg][Rr][Oo][Uu][Pp] BY;
IS_NULL : IS NULL;
IS_NOT_NULL : IS NOT NULL;
LIMIT   : [Ll][Ii][Mm][Ii][Tt];
MAX     : [Mm][Aa][Xx];
MIN     : [Mm][Ii][Nn];
NOT     : [Nn][Oo][Tt];
OR      : [Oo][Rr];
ORDER_BY: [Oo][Rr][Dd][Ee][Rr] BY;
SELECT  : [Ss][Ee][Ll][Ee][Cc][Tt];
SKIP    : [Ss][Kk][Ii][Pp];
SUM     : [Ss][Uu][Mm];
WHERE   : [Ww][Hh][Ee][Rr][Ee];
/**
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
*/
IDENTIFIER : LETTER (LETTER|DIGIT)*; //[a-zA-Z]+;
LETTER      : 'a'..'z'|'A'..'Z' ;
DIGIT       : '0'..'9' ;

// Ignore Whitespace in common mode but not inside String Literals
WS : (' '|'\t'|'\r'|'\n')+ -> skip ; 

// --------   Basic character set that can appear in a String Literal ----- 
// ------- Switching Lexer mode inside a single quote to preserve white spaces --- 
OPENSTRING: '\'' -> mode(STRINGMODE), pushMode(STRINGMODE);
mode STRINGMODE;

// ------- String literal is any sequence of characters preserving spaces and escaping --- 
STRING_LITERAL : ~['\'']*;
CLOSESTRING: '\'' -> popMode, mode(DEFAULT_MODE);