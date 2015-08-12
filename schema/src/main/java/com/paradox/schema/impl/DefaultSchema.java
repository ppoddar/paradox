package com.paradox.schema.impl;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.paradox.schema.Attribute;
import com.paradox.schema.ContainerType;
import com.paradox.schema.EnumeratedType;
import com.paradox.schema.NamingPolicy;
import com.paradox.schema.Schema;
import com.paradox.schema.SchemaValidationException;
import com.paradox.schema.Type;
import com.paradox.schema.UserType;

public class DefaultSchema extends AbstractSchemaElement<Type> implements Schema {
	private final NamingPolicy _naming;
	private static final String[] BASE_TYPES = {"string", "integer", "long", "object", "map"};
	
	public DefaultSchema(String name) {
		super(null, name);
		_naming = new DefaultNamingPolicy();
		for (String t : BASE_TYPES) {
			addChild(new DefaultPrimitiveType(this, t));
		}
	}
	
	@Override
	public Type getType(String typeName) {
		return getChild(typeName);
	}
	@Override
	public UserType getUserType(String typeName) {
		Type type = getChild(typeName);
		try {
			return UserType.class.cast(type);
		} catch (ClassCastException ex) {
			return null;
		}
	}

	@Override
	public boolean containsType(String typeName) {
		return hasChild(typeName);
	}

	@Override
	public NamingPolicy getNamingPolicy() {
		return _naming;
	}
	
	@Override
	public UserType newType(String typeName) {
		DataType newType = new DataType(this, typeName, AbstractType.FLAG_USER);
		addChild(newType);
		return newType;
	}
	
	public ContainerType newContainerType(Type elementType) {
		ContainerType newType = new AbstractContainerType(elementType);
		addChild(newType);
		return newType;
	}

	@Override
	public EnumeratedType newEnumeratedType(String name) {
		EnumeratedType e = new AbstractEnumeratedType(this, name);
		addChild(e);
		return e;
	}
	
	public String getDefaultAttributeType() {
		return "string";
	}

	@Override
	public void validateType(String typeName) {
		if (getUserType(typeName) == null)
			throw new SchemaValidationException("Unknown type [" + typeName + "]");
	}

	@Override
	public void validatePath(String rootType, String path) {
		UserType root = getUserType(rootType);
		if (root == null) throw new SchemaValidationException("Unknown root [" + rootType + "] for path " + path);
		String[] paths = path.split("\\.");
		validatePath(root, paths, 0);
	}
	
	void validatePath(UserType type, String[] paths, int idx) {
		String attrName = paths[idx];
		Attribute attr = type.getAttribute(attrName);
		if (attr == null) throw new SchemaValidationException("Unknown attribute [" + attrName + "] for path [" 
				+ join('.', paths) + "] from [" + (idx == 0 ? " type " + type.getName() : " attribute " + paths[idx-1]) + "]");
		if (idx == paths.length-1) return;
		if (!attr.getType().isUserDefined()) throw new SchemaValidationException("Can not navigate from [" + attrName 
				+ "] for path [" + join('.', paths) + "] from [" 
				+ (idx == 0 ? " type " + type.getName() : " attribute " + paths[idx-1]) + "]");
		validatePath((UserType)attr.getType(), paths, idx+1);
	}
	
//	@Override
	public AttributePath resolve(UserType type, String dotSeparatedPath) throws SchemaValidationException {
		String[] segments = dotSeparatedPath.split("\\.");
		UserType base = type;
		DefaultAttributePath path = null;
		for (int i = 0; i < segments.length; i++) {
			Attribute attr = base.getAttribute(segments[i]);
			if (attr == null) {
				throw new SchemaValidationException("No attribute " + segments[i] + " in " + base.getName() 
						+ " while resolving path " + dotSeparatedPath);
			}
			if (path == null) {
				path = new DefaultAttributePath(attr);
			} else {
				path.append(attr);
			}
			if (attr.getType().isUserDefined()) {
				base = (UserType) attr.getType();
			} else if (i == segments.length-1) {
				
			} else {
				throw new SchemaValidationException("Can not navigate after " + segments[i] + " because its type " 
						+ attr.getType().getName() + " can not be navigated further "
						+ " while resolving path " + dotSeparatedPath);
			}
		}

		return path;
	}

	

	@Override
	public boolean isValidating() {
		return true;
	}	
	
	String join(char ch, String[] paths) {
		StringBuilder buf = new StringBuilder();
		if (paths == null || paths.length == 0)
			return buf.toString();
		buf.append(paths[0]);
		for (int i = 1; i < paths.length; i++) {
			buf.append(ch).append(paths[i]);
		}
		return buf.toString();
	}

	@Override
	public Collection<UserType> getUserTypes() {
		Collection<Type> all = getChildren();
		List<UserType> result = new ArrayList<UserType>();
		for (Type t : all) {
			if (t instanceof UserType)
				result.add((UserType)t);
		}
		return result;
	}
}
