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

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.paradox.schema.Attribute;
import org.paradox.schema.Constraint;
import org.paradox.schema.Schema;
import org.paradox.schema.Type;
import org.paradox.schema.UserType;

class DataType extends AbstractType implements UserType {
	private Set<Constraint> _constraints;
	
	DataType(Schema schema, String name, int flags) {
		super(schema, name, flags);
	}
	
	@Override
	public Attribute getAttribute(String name) {
		return getAttribute(name, false);
	}
	
	public Attribute getAttribute(String name, boolean mustExist) {
		Attribute attr = getChild(name);
		if (attr == null && mustExist) {
			throw new RuntimeException(name + " does not exist in " + this);
		}
		return attr;
	}
	
	
	@Override
	public Collection<Attribute> getAttributes() {
		return getChildren();
	}
	
	@Override
	public Attribute newAttribute(String name, Type type) {
		Attribute attr = new AttributeImpl(this, name, type);
		addChild(attr);
		return attr;
	}
	
	@Override
	public void addConstraint(Constraint c) {
		if (_constraints == null)
			_constraints = new HashSet<Constraint>();
		_constraints.add(c);
	}

	@Override
	public List<Attribute> getIdAttributes() {
		if (_constraints == null) return null;
		for (Constraint c : _constraints) {
			if (c instanceof IdentityConstraint) 
				return c.getAttributes();
		}
		return null;
	}
}
