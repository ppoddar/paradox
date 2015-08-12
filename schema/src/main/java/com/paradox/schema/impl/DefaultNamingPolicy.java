package com.paradox.schema.impl;

import com.paradox.schema.NamingPolicy;

class DefaultNamingPolicy implements NamingPolicy {
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
