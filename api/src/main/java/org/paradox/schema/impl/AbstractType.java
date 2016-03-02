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
import org.paradox.schema.Schema;
import org.paradox.schema.Type;

abstract class AbstractType extends AbstractSchemaElement<Attribute> implements Type {
	static final byte FLAG_PRIMITIVE = 0x1  << 1;
	static final byte FLAG_USER      = 0x1  << 2;
	static final byte FLAG_ENUM      = 0x1  << 3;
	static final byte FLAG_PLURAL    = 0x1  << 4;

	private final int    _flags;

	protected AbstractType(Schema schema, String name, int flags) {
		super(schema, name);
		if (schema == null) throw new IllegalArgumentException("Null schema");
		_flags  = flags;
	}
	
	@Override
	public final Schema getSchema() {
		return (Schema)getScope();
	}
	
	@Override
	public final boolean isPrimitive() {
		return isSet(FLAG_PRIMITIVE);
	}
	@Override
	public final boolean isPlural() {
		return isSet(FLAG_PLURAL);
	}
	@Override
	public final boolean isEnumerated() {
		return isSet(FLAG_ENUM);
	}
	@Override
	public final boolean isUserDefined() {
		return isSet(FLAG_USER);
	}
	
	
	
	protected boolean isSet(byte flag) {
		return (_flags & flag) != 0;
	}
	
}
