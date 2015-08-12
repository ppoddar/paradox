package com.paradox.schema;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.paradox.schema.compiler.DefaultSchemaCompiler;

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
