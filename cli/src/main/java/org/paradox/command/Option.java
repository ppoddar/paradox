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

package org.paradox.command;

class Option {
	private String key;
	private String name;
	private String description;
	private boolean requiresValue = true;
	private boolean mandatory;

	Option(String key) {
		this.key = key;
	}
	
	String key() {
		return key;
	}
	
	String name() {
		return name;
	}
	
	boolean requiresValue() {
		return requiresValue;
	}
	
	boolean mandatory() {
		return mandatory;
	}
	
	String description() {
		return description;
	}
	
	Option setName(String name) {
		this.name = name;
		return this;
	}
	
	Option setDescription(String d) {
		this.description = d;
		return this;
	}
	Option requiresValue(boolean flag) {
		requiresValue = flag;
		return this;
	}
	
}
