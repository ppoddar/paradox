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
 * An attribute (or property) of a {@linkplain UserType user-defined type}.
 * <p>
 * An attribute is <em>of</em> a type. The attribute type determines what value can be held
 * in this attribute. 
 * <br>
 * An attribute belongs to an {@link #getOwner() owning type} and 
 * its name is unique within the {@link #getScope() scope} of the owning type.
 * <br>
 * @author pinaki poddar
 *
 */
public interface Attribute extends SchemaElement<Constraint> {
	/**
	 * Gets the name of this attribute.
	 * The name of an attribute is unique among the attributes of its owning type.
	 * 
	 * @see NamingPolicy#isValidAttributeName(String)
	 */
	String getName();
	
	/**
	 * Gets the owner who owns this attribute.
	 * @return the owning type. Never null.
	 */
	Type getOwner();
	
	
	/**
	 * Gets the type of this attribute. This type determines what values can be held in this attribute for a data
	 * record.
	 * @return the type of data held in this attribute. Never null.
	 */
	Type getType();
	
}
