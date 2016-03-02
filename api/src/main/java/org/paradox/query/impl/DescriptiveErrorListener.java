/**

      Copyright ©2016. Author Pinaki Poddar. All Rights Reserved. 

	Permission to use, copy, modify, and distribute this software and its documentation 
	for educational, research, and not-for-profit purposes, without fee and without a 
	signed licensing agreement, is hereby granted, provided that the above copyright notice, 
	this paragraph and the following two paragraphs appear in all copies, modifications, 
	and distributions. 


	IN NO EVENT SHALL THE AUTHOR BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT, SPECIAL, INCIDENTAL, 
	OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS, ARISING OUT OF THE USE OF THIS SOFTWARE 
	AND ITS DOCUMENTATION, EVEN IF THE AUTHOR HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

	THE AUTHOR SPECIFICALLY DISCLAIMS ANY WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
	WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE AND 
	ACCOMPANYING DOCUMENTATION, IF ANY, PROVIDED HEREUNDER IS PROVIDED "AS IS". THE AUTHOR HAS 
	NO OBLIGATION TO PROVIDE MAINTENANCE, SUPPORT, UPDATES, ENHANCEMENTS, OR MODIFICATIONS.
*/

package org.paradox.query.impl;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.Vocabulary;

public class DescriptiveErrorListener extends BaseErrorListener {
	private final String _sql;

	DescriptiveErrorListener(String sql) {
		_sql = sql;
	}

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		Token token = null;
		if (e != null) {
			token = e.getOffendingToken();
		} else if (offendingSymbol instanceof Token) {
			token = (Token) offendingSymbol;
		}
		Vocabulary lexicon = recognizer.getVocabulary();
		String message = msg;
		if (token != null) {
			int n = token.getStartIndex();
			int l = token.getText().length();
			message = "Encountered " + lexicon.getDisplayName(token.getType()) + " token [" + token.getText()
					+ "] in SQL [" + _sql.substring(0, n) + '^' + token.getText() + '^' + _sql.substring(n + l)
					+ "] expecting  one of " + e.getExpectedTokens().toString(lexicon);
		} else {
			message = "Encountered " + msg + " due to " + offendingSymbol + " in "
					+ _sql.substring(0, charPositionInLine) + '^' + _sql.substring(charPositionInLine);
		}
		System.err.println(message);
		if (e != null) {
			throw new RecognitionException(message, recognizer, e.getInputStream(), (ParserRuleContext) e.getCtx());
		} else {
			throw new RecognitionException(message, recognizer, null, null);
		}
	}
}
