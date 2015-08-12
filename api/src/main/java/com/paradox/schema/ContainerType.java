package com.paradox.schema;

import com.paradox.schema.Type;

/**
 * Type that is composed of other type(s), for example, Array or Map.
 * 
 * @author pinaki poddar
 *
 */
public interface ContainerType extends Type {
	/**
	 * Gets the element type.
	 */
	Type getElementType();

}
