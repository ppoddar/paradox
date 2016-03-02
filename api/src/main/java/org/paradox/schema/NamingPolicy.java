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

package org.paradox.schema;

/**
 * Policy and restrictions for naming {@link SchemaElement schema elements}.
 * <p>
 * The {@link Schema type system} being described uses naming policy to represent
 * container types. 
 * 
 * @author pinaki poddar
 *
 */
public interface NamingPolicy {
	/**
	 * Affirms if the given name is syntactically valid as a type name.
	 */
	boolean isValidTypeName(String typeName);

	/**
	 * Affirms if the given name is syntactically valid as an attribute name.
	 */
	boolean isValidAttributeName(String attrName);
	
	/**
	 * Affirms if the given name denotes a type name for container type.
	 * An array type name e.g. {@code string[]} will return {@code true}.
	 * 
	 */
	boolean isPluralTypeName(String typeName);
	
	/**
	 * Gets the name of the element type name for the given type name.
	 * A multi-dimensional array type name e.g. {@code Person[][]} will return 
	 * {@code Person[]}.
	 * @return null if the given name does not denote a container type.
	 */
	String  getComponentTypeName(String typeName);
	
	/**
	 * Creates a name for a container type from the given element type name.
	 */
	String createPluralTypeName(String name);
}
