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

package org.paradox.schema.impl;

import org.paradox.schema.Attribute;
import org.paradox.schema.Constraint;
import org.paradox.schema.Type;

class AttributeImpl extends AbstractSchemaElement<Constraint> implements Attribute {
	private final Type   _type;

	AttributeImpl(Type owner, String name, Type type) {
		super(owner, name);
		_type  = type;
	}
	
	public Type getType() {
		return _type;
	}
	
	public Type getOwner() {
		return (Type)getScope();
	}
}
