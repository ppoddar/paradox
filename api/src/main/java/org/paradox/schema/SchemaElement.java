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
 * The generic element in a {@link Schema} description. 
 * At its broadest generalization, Each element has a name, occurs in an defining scope and
 * may have children that are referred by their name.  
 * 
 * @author pinaki poddar
 *
 * @param <T> type of its children
 */
public interface SchemaElement<T> {
	/**
	 * Gets the immutable name of this receiver. 
	 * @return a non-null name that is unique within the scope of this receiver.
	 */
	String getName();
	
	/**
	 * Gets the scope in which this receiver has been defined.
	 * @return can be null for a Schema itself. For a type, the scope is schema. For attribute the scope is a Type.
	 */
	SchemaElement<?> getScope();
	
	/**
	 * Gets the child of the given name.
	 * @return null if no such child exists
	 */
	T getChild(String childName);
	
	/**
	 * Affirms if this receiver has defined a child of the given name.
	 */
	boolean hasChild(String childName);
	
}
