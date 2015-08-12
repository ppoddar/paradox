package com.paradox.query.parser;

import java.io.*;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;

/**
 * Specializes ANTLR input to ignore character case for keywords.
 * ANTLR grammar does not have a provision for case-insensitive keywords
 * and hence this specialized input processing.
 * 
 * @author pinaki poddar
 *
 */
public class CaseInsensitiveANTLRStringStream  extends ANTLRInputStream {
	
    public CaseInsensitiveANTLRStringStream(String queryString) throws IOException {
        super(queryString);
    }
 
    public int LA(int i) {
        if ( i == 0 ) return 0; // undefined
        if ( i < 0 ) {
            i++; // e.g., translate LA(-1) to use offset 0
        }
        return ((p+i-1) >= n) ? CharStream.EOF : Character.toUpperCase(data[p+i-1]);
    }
}
