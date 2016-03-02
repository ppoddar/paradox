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

import org.paradox.schema.ContainerType;
import org.paradox.schema.Type;

class AbstractContainerType extends AbstractType implements ContainerType {
	private final Type   _elementType;

	AbstractContainerType(Type e) {
		super(e.getSchema(), e.getSchema().getNamingPolicy().createPluralTypeName(e.getName()), makeFlag(e));
		_elementType = e;
	}
	
	public final Type getElementType() {
		return _elementType;
	}
	
	private static int makeFlag(Type e) {
		int flag = FLAG_PLURAL;
		if (e.isEnumerated()) flag |= FLAG_ENUM;
		if (e.isPrimitive()) flag |= FLAG_PRIMITIVE;
		if (e.isUserDefined()) flag |= FLAG_USER;
		return flag;
	}
	
}
