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

import java.util.Collection;
import java.util.List;

/**
 * A user-defined type.
 * <p>
 * A user-defined type has zero or more {@link Attribute attributes}. The user-defined type is designed on the
 * assumption that instances would be persisted. Hence, a user-defined type also designates a list of its attributes
 * that participate to form a primary key. The order of these attributes is significant from generating a compound key.
 * 
 * @see KeyMaker
 * 
 * @author pinaki poddar
 *
 */
public interface UserType extends Type {
	/**
	 * Gets the attribute of given name, or null if absent.
	 * @param attrName name of an attribute
	 */
	Attribute getAttribute(String attrName);
	
	/**
	 * Gets the attributes without any specific order
	 */
	Collection<Attribute> getAttributes();
	
	
	/**
	 * Gets the attributes whose values form the identifier of an instance of this type.
	 * The order of attribute can be important for hierarchical key.
	 * @see KeyMaker
	 * @return empty list if this receiver has no identifier attributes.
	 */
	List<Attribute> getIdAttributes();
	
	
	void addConstraint(Constraint constraint);
	
	Attribute newAttribute(String name, Type type);
	
}
