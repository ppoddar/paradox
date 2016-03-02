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

package org.paradox.util;

import java.net.MalformedURLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A URL syntax for NoSQL datastore.
 * @author pinaki poddar
 *
 */
public class NoSQLURL {
	private final String _original;
	private final String _storeName;
	private String[] _hostports;
	
	public static final String DEFAULT_HOST_PORT = "localhost:5000";
	
	/**
	 * Parses the given string according to the following NoSQL database URL syntax.
	 * <pre>
	 * URL        := [protocol]<store-name>[host-spec]
	 * protocol   := 'nosql://'
	 * store-name := word
	 * host-spec  := '@' + host-port [, host-port]*
	 * host-port  := host:port
	 * host       := word
	 * port       := number
	 * 
	 * word is any sequence of non-white space characters except special characters
	 * special characters are any of the following characters :/?;
	 * </pre>
	 * 
	 * @param url a database URL in NoSQL database URL syntax.
	 *        Example: {@code nosql://store@localhost:8090}.
	 *        <br>
	 *        protocol and host specification are defaulted to
	 *        {@code nosql} and {@code localhost:5000} respectively.
	 *        So minimal URL is simply a store name.
	 *        
	 * @throws MalformedURLException
	 */
	public NoSQLURL(String url) throws MalformedURLException {
		if (url == null)
			throw new NullPointerException ("Database URL must not be null");
		if (!Pattern.matches(_urlSyntax, url))
			throw new MalformedURLException (url);
		_original = url;
		
		Matcher matcher = Pattern.compile(_urlSyntax).matcher(url);
		matcher.find();
		_storeName = matcher.group(2);
		if (_storeName == null || _storeName.isEmpty())
			throw new MalformedURLException (url);
		_hostports = matcher.group(3) == null 
				? new String[] {DEFAULT_HOST_PORT} 
				: matcher.group(3).substring(1).split(",");
		
	}
	
	/**
	 * Gets the name of the store.
	 * 
	 * @return store name. Never null or empty.
	 */
	public String getStoreName() {
		return _storeName;
	}
	
	@Override
	public String toString() {
		return _original;
	}
	
	/**
	 * Gets the hosts and ports.
	 * 
	 * @return never null or empty.
	 */
	public String[] getHostPorts() {
		return _hostports;
	}
	
	public String getFullString() {
		StringBuilder buf = new StringBuilder().append(protocol).append(getStoreName());
		buf.append('@').append(getHostPorts()[0]);
		for (int i = 1; i < getHostPorts().length; i++) 
			buf.append(',').append(getHostPorts()[i]);
		return buf.toString();
	}
	
	// URL syntax
	
	private static String SPECIAL_CHARS = ":/@;";
	private static String protocol = "nosql://";
	private static String number = "\\d+";
	private static String word   = "[^" + SPECIAL_CHARS + "\\s]+";
	private static String host = word + ':' + number;
	private static String hostSpec = '@' + host + many(optional(',' + host));
	private static String storeName = word;
	private static String _urlSyntax = group(protocol) + '?' 
			                         + group(storeName) + "{1}?" 
				                     + group(hostSpec) + "?";
	
	private static String group(String s) {
		return '(' + s + ')';
	}
	
	private static String optional(String s) {
		return '[' + s + ']';
	}
	private static String many(String s) {
		return  s + '*';
	}
}
