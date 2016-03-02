package org.paradox.schema;

import java.util.Collection;

//import com.oracle.schema.impl.AttributePath;


import org.paradox.schema.ContainerType;
import org.paradox.schema.EnumeratedType;

/**
 * Group of related {@link Type}s.
 * <br>
 * The types in a schema creates a closure on type reference. <em>Closure</em> implies that if type {@code A} 
 * belongs to Schema {@code S} and {@code A} refers to another type {@code B}, then  type {@code B} <b>must</b>
 * belong to the same schema {@code S}.
 * <p>
 * A schema holds different categories of types.    
 * <dl>
 *    <dt>Primitive Type</dt> 
 *       <dd>are the basis set of types in a schema. For example, a typical schema may have 
 * {@code integer} and {@code string} as its basis set. Primitive types are <em>immutable</em> and have no 
 * visible attributes. This category of types can not be created via this interface. 
 *       </dd>
 * 
 *    <dt>User Type</dt> 
 *    	<dd>are types that user/application declare. For example, a {@code Person} or {@code Address}.
 *          These category of types are additively mutable i.e. new attributes can be added. 
 *      </dd>
 *      
 *    <dt>Container Type</dt> 
 *       <dd>are derived from other types. For example, {@code map} or {@code array} of some 
 *       other type. The container types are composable i.e. the element type of a container type {@code C} can be 
 *       another container type including {@code C} itself.
 *       A container type has no visible attributes, nor new attribute can be added to them.
 *       </dd>
 *       
 *    <dt>Enumerated Type</dt>
 *    	<dd>can hold <em>only</em> a fixed set of values. An Enumerated type has no visible attribute, 
 *       nor new attribute can be added to them.
 *     </dd>
 * </dl>
 * <p>
 * Schema acts as a factory for different categories of types described above, except Primitive types which are
 * predefined by the concrete implementation.
 * <p>
 * <b>Naming Policy</b>: Each type (generally, {@link SchemaElement schema element} has an immutable name. The name is
 * unique within its scope. For example, a Type {@code T} is uniquely named with its scope i.e. the Schema to which 
 * {@code T} belongs. Similarly, all attributes of a type must be uniquely named.
 * <p>
 * Moreover, a {@link NamingPolicy naming policy} dictates which name tokens are syntactically valid as a type or 
 * attribute name. 
 * 
 * @author pinaki poddar
 *
 */
public interface Schema extends SchemaElement<Type> {
	/**
	 * Gets the type of a given name.
	 * 
	 * @param typeName a type name.
	 * @return a type of any category. Null if no type of given name exists.
	 */
	Type getType(String typeName);
	
	/**
	 * Gets the user-defined type of a given name.
	 * @param typeName a type name.
	 * @return a user-defined type. Null if no type of given name exists.
	 */
	UserType getUserType(String typeName);
	
	/**
	 * Affirms if the given name is a recognized type name of any category.
	 */
	boolean containsType(String typeName);
	
	/**
	 * Creates a new user type.
	 * @param name a name which must be valid by current {@link #getNamingPolicy() naming policy}.
	 * @return a newly created user type. The user type at this point has no attribute.
	 * 
	 * @throws IllegalArgumentException if the name is invalid according to the naming policy.
	 * IllegalStateException if a type of same name already exists in this schema.
	 */
	UserType newType(String name);
	
	/**
	 * Creates a new container type from the given element type.
	 * The name of the type is determined by the {@link #getNamingPolicy() naming policy}.
	 * For example, an implementation may describe an array of integer as {@code integer[]} whereas another\
	 * may call the same as {@code [integer]}.
	 * @param elementType element type contained by the new container type
	 * @return a container type
	 */
	ContainerType newContainerType(Type elementType);
	
	/**
	 * Creates an enumerated type of given name
	 * @param name name of the enumerated type
	 * @return an enumerated type
	 */
	EnumeratedType newEnumeratedType(String name);
	
	/**
	 * Gets the policy of naming types/attributes.
	 */
	NamingPolicy getNamingPolicy();
	
	/**
	 * Affirms if the given user type exists in this schema.
	 * @param type a user type name
	 */
	void validateType(String type) throws SchemaValidationException;
	
	/**
	 * Validates the given path starting from the given user type name exists in this schema.
	 * @param rootType a type name
	 * @param path a path expression
	 */
	void validatePath(String rootType, String path) throws SchemaValidationException;
	
	/**
	 * Affirms if this schema can validate type or paths.
	 */
	boolean isValidating();
	
//	AttributePath resolve(UserType type, String dotSeparatedPath) throws SchemaValidationException;
	
	public Collection<UserType> getUserTypes();
	
	
}
