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
 * The basic unit of a {@link Schema}. Each type {@link #getSchema() belongs} to a Schema.
 * <br>
 * A plural type is composed of another type as elements. For example, an array of integer.
 *  
 * @author pinaki poddar
 *
 */
public interface Type extends SchemaElement<Attribute> {
	/**
	 * Gets the schema that owns this type.
	 */
	Schema getSchema();
	
	/**
	 * Affirms if this type is plural. 
	 */
	boolean isPlural();
	
	/**
	 * Affirms if this type is enumerated.
	 */
	boolean isEnumerated();
	
	
	/**
	 * Affirms if this type is primitive. 
	 */
	boolean isPrimitive();
	
	/**
	 * Affirms if this type is defined by the user.
	 */
	boolean isUserDefined();
}
