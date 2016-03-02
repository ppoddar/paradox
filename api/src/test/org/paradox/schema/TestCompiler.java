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

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.paradox.schema.Schema;
import org.paradox.schema.SchemaValidationException;
import org.paradox.schema.Type;
import org.paradox.schema.impl.DefaultSchemaCompiler;

public class TestCompiler {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCompileFromJSON() {
		Schema schema = DefaultSchemaCompiler.compile("person-address-schema.json");
		Assert.assertNotNull(schema);
		Assert.assertEquals("Test Schema", schema.getName());
		Assert.assertTrue(schema.containsType("Person"));
		Assert.assertTrue(schema.containsType("Address"));
		Assert.assertTrue(schema.containsType("integer"));
		Assert.assertTrue(schema.containsType("string"));
		Assert.assertNull(schema.getUserType("integer"));
		Assert.assertNull(schema.getUserType("string"));
		schema.validatePath("Person", "ssn");
		schema.validatePath("Person", "bestFriend.ssn");
		try {
			schema.validatePath("Person", "bestFriend.sssn");
			Assert.fail("Expected not to validate invalid path " + "Person.bestFriend.sssn");
		} catch (SchemaValidationException ex) {
			
		}
		
		Type personType = schema.getType("Person");
		Assert.assertTrue(personType.isUserDefined());
		Assert.assertFalse(personType.isPrimitive());
		Assert.assertFalse(personType.isPlural());
		Assert.assertFalse(personType.isEnumerated());

		Type integerType = schema.getType("integer");
		Assert.assertFalse(integerType.isUserDefined());
		Assert.assertTrue(integerType.isPrimitive());
		Assert.assertFalse(integerType.isPlural());
		Assert.assertFalse(integerType.isEnumerated());
		
		Type stateType = schema.getType("State");
		Assert.assertFalse(stateType.isUserDefined());
		Assert.assertFalse(stateType.isPrimitive());
		Assert.assertFalse(stateType.isPlural());
		Assert.assertTrue(stateType.isEnumerated());

		/**
		 * 
		Type  emailType = ((UserType)personType).getAttribute("email").getType();
		Assert.assertFalse(emailType.isUserDefined());
		Assert.assertFalse(emailType.isPrimitive());
		Assert.assertTrue(emailType.isPlural());
		Assert.assertFalse(emailType.isEnumerated());
		*/
		Assert.assertFalse(schema.containsType("Type does not exist"));
		
	}

}
