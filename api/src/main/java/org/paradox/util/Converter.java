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

package org.paradox.util;

public class Converter {
	@SuppressWarnings("unchecked")
	public static <T> T convert(Object from, Class<T> to) {
		if (from == null) return (T)null;
		if (from.getClass() == to) return (T)from;
		if (to == String.class) {
			return (T)from.toString();
		}
		if (from.getClass() == String.class) {
			if (to == int.class || to == Integer.class) return (T)new Integer(Integer.parseInt(from.toString()));
			if (to == long.class || to == Long.class) return (T)new Long(Long.parseLong(from.toString()));
			if (to == double.class || to == Double.class) return (T)new Double(Double.parseDouble(from.toString()));
		}
		if (to == Object.class) {
			return (T)from;
		}
		if (Enum.class.isAssignableFrom(to)) {
			return (T)from.toString();
		}
		throw new RuntimeException("No conversion available of " + from + " of " + from.getClass() + " to " + to);
	}

}
