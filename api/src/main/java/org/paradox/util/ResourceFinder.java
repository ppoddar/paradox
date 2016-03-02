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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ResourceFinder {
	
	/**
	 * Loads a input resource stream.
	 * 
	 * @param rsrc a resource identifier.  
	 * @return an InputStream
	 * @throws RuntimeException if no resource can be loaded by the given identifier
	 */
	public static InputStream load(String rsrc) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		//loader.getResource(rsrc).openStream();
		InputStream input = loader.getResourceAsStream(rsrc);
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
		return input;
	}

}
