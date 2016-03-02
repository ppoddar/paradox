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

import java.util.Iterator;
import java.util.LinkedList;

import org.paradox.schema.Attribute;
import org.paradox.schema.Type;

class DefaultAttributePath implements AttributePath {
	private final LinkedList<Attribute> _segments = new LinkedList<Attribute>();
	
	DefaultAttributePath(Attribute attr) {
		append(attr);
	}
	
	@Override
	public Type getType() {
		return _segments.getLast().getType();
	}

	@Override
	public int length() {
		return _segments.size();
	}

	@Override
	public Iterator<Attribute> segments() {
		return _segments.iterator();
	}
	
	void append(Attribute attr) {
		_segments.add(attr);
	}
	
	@Override
	public AttributePath subpath() {
		DefaultAttributePath next = new DefaultAttributePath(_segments.get(1));
		for (int i = 2; i < length(); i++) {
			next.append(_segments.get(i));
		}
		return next;
	}
	
	@Override
	public Attribute getAttribute() {
		return _segments.getLast();
	}

}
