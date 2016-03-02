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

import org.paradox.schema.NamingPolicy;

public class DefaultNamingPolicy implements NamingPolicy {
	public static final String PLURAL_NAME_MARKER = "[]";
	
	@Override
	public boolean isValidTypeName(String typeName) {
		if (typeName == null || typeName.length() == 0) return false;
		if (isPluralTypeName(typeName)) {
			return isValidTypeName(getComponentTypeName(typeName));
		}
		if (!Character.isJavaIdentifierStart(typeName.charAt(0))) return false;
		for (int i = 1; i < typeName.length(); i++) {
			if (!Character.isJavaIdentifierPart(typeName.charAt(i))) return false;
		}
		return true;
	}

	@Override
	public boolean isValidAttributeName(String attrName) {
		if (attrName == null || attrName.length() == 0) return false;
		if (!(Character.isJavaIdentifierStart(attrName.charAt(0)) || attrName.charAt(0) == '$')) return false;
		for (int i = 1; i < attrName.length(); i++) {
			if (!(Character.isJavaIdentifierPart(attrName.charAt(i)) || attrName.charAt(0) == '$')) return false;
		}
		return true;
	}

	@Override
	public boolean isPluralTypeName(String typeName) {
		return typeName != null 
			&& (typeName.endsWith(PLURAL_NAME_MARKER) || "map".equalsIgnoreCase(typeName));
	}

	public String getSingularTypeName(String typeName) {
		if (isPluralTypeName(typeName)) {
			return getSingularTypeName(getComponentTypeName(typeName));
		}
		return typeName;
	}

	public String getComponentTypeName(String typeName) {
		if (isPluralTypeName(typeName)) {
			return typeName.substring(0, typeName.length() - PLURAL_NAME_MARKER.length());
		}
		return null;
	}

	public int getTypeDimension(String typeName) {
		if (isPluralTypeName(typeName)) {
			return 1 + getTypeDimension(getComponentTypeName(typeName));
		}
		return 0;
	}

	@Override
	public String createPluralTypeName(String name) {
		return name + PLURAL_NAME_MARKER;
	}
}
