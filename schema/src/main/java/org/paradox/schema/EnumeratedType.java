package org.paradox.schema;

import java.util.List;

import org.paradox.schema.Type;

/**
 * Type that allows a fixed set of values on an attribute.
 *  
 * @author pinaki poddar
 *
 */
public interface EnumeratedType extends Type {
	List<String> values();
}
