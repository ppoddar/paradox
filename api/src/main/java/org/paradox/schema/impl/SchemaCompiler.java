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

package org.paradox.schema.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.paradox.schema.Schema;

/**
 * Compiles a resource content into a {@link Schema}.
 * 
 * @author pinaki poddar
 *
 */
public abstract class SchemaCompiler {
	private static Map<String,SchemaCompiler> _compilers;
	static {
		_compilers = new HashMap<String,SchemaCompiler>();
		_compilers.put("json", new DefaultSchemaCompiler());
	}
	/**
	 * Compiles the content of the given resource to build a schema.
	 * The extension of the given resource is used to decide the concrete implementation that can interpret the content 
	 * to build a Schema.
	 * 
	 * @param rsrc a resource identifier. typically a file/resource name available on the classpath. 
	 * @return a Schema created from the description found in the resource
	 * @throws RuntimeException if no available compiler can identify the resource by its extension.
	 */
	public static Schema compile(String rsrc) {
		InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(rsrc);
		if (input == null) {
			File file = new File(rsrc);
			if (file.exists() && !file.isDirectory()) {
				try {
					input = new FileInputStream(file);
				} catch (IOException ex) {
					
				}
			} else {
				throw new RuntimeException("Can not load resource [" + rsrc + "]");
			}
		}
		String extension = getExtension(rsrc);
		if (extension == null || !_compilers.containsKey(extension.toLowerCase())) {
			throw new RuntimeException("No registered schema compiler to compile [" + rsrc 
					+ "]. Compilers are available for " + _compilers.keySet() + " extensions");
		}
		return _compilers.get(extension).parse(input);
	}
	
	private static String getExtension(String rsrc) {
		if (rsrc == null) return null;
		int dot = rsrc.lastIndexOf('.');
		return dot == -1 ? null : rsrc.substring(dot+1);
	}
	
	/**
	 * Parses the stream to generate a schema.
	 * @param stream a non-null input stream
	 * @return a schema populated from the input description.
	 */
	protected abstract Schema parse(InputStream stream);

}
