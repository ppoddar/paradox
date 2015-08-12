package com.paradox.util;

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
