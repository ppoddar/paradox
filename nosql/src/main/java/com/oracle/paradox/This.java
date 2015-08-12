package com.oracle.paradox;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

public class This {

	public This() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		try {
			Enumeration<URL> resources = This.class.getClassLoader().getResources("META-INF/MANIFEST.MF");
			while (resources.hasMoreElements()) {
			    try {
			      Manifest manifest = new Manifest(resources.nextElement().openStream());
			      if (This.class.getName().equals(manifest.getMainAttributes().getValue("Main-Class"))) {
			    	  System.err.println("Entries:" + manifest.getEntries());
			    	  System.err.println("Main Attributes:");
			    	  Attributes attrs = manifest.getMainAttributes();
			    	  for (Map.Entry<Object, Object> attr : attrs.entrySet()) {
			    		  System.err.println(attr.getKey() + ":" + attr.getValue());
			    	  }
			    	  
			      }
			    } catch (IOException ex) {
			      
			    }
			}
		} catch (Exception ex) {
			
		}

	}

}
