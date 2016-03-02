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

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.paradox.schema.EnumeratedType;
import org.paradox.schema.NamingPolicy;
import org.paradox.schema.Schema;
import org.paradox.schema.Type;
import org.paradox.schema.UserType;

/**
 * Compiles a schema from a schema specification in JSON format. 
 * <p>
 * The format is described with a example, highlighting some of the schema capabilities
 * <pre>
 * {
    "name": "TestSchema",
    "description": "A Person-Address schema used for testing",
    "types": {
        "Person": {
            "attributes": {
                "ssn"  : {"type": "long"},
                "name" : {"indexed":true},
                "email": {"type": "string[]"},
                "age"  : {"type": "integer"},
                "bestFriend":{"type":"Person"},
                "address": {"type":"Address"},
                "phones": {"type": "map", "key-type":"Phone", "value-type":"number"},
            },
            "identifiers": ["ssn"]
        },
        "Address": {
            "attributes": {
               "street": {},
               "city"  : {"type:"string"},
               "owner" : {"type":"Person"},
               "state" :  {"type":"State"}
            }
        }
    },
    "enums": {
        "State": {
            "values": ["CA","TX","NY"]
        },
        "Phone": {
            "values": ["Home", "Office", "Cell"],
            "case-sensitive":false
        }
    }
}
 * </pre> 
 * <br>
 * <ul>
 * <li> The schema has name and an optional description specified via {@code "name"} and {@code "description"} properties of the JSON.
 * <li> Types are specified  via {@code "types"} property. The value of {@code "types"} property is a single JSON object whose
 * property names are the user-defined type names e.g. {@code Person} or {@code Address} in the example above.
 * <li>The attributes of each type is described via the {@code "attributes"} property of the JSON object which is the
 * value of individual type-named property. For example, the JSON object value for property  {@code "Address"} has a
 * property named {@code "attributes"} which, in turn, consists of 4 JSON values named {@code "street", "city", "owner"} and {@code "state"}.
 * <li>Each attribute definition specifies type of the attribute. For example, {@code "city"} is of type {@code "string"}
 * while {@code "owner"} is of type {@code "Person"}.
 * <li>Similar to the user-defined types, {@code "enums"} defines the enumerated types. Enumerated Types do not have
 * attributes, but have a sequence of allowed values.
 * </ul>
 * <p>
 * Few more salient features of this schema as noted in the example above
 * <dl>
 * 		<dt>Primary Key</dt>
 * 		<dd>The schema definition s geared towards the assumption that the instances adhering to this schema would be 
 * 			persisted. Hence, a type definition can specify a {@code "identifiers"} property with an array of strings
 *          as value. The elements of the array are some of the attribute names defined for the type. The order 
 *          of the elements is significant, because a user of the schema may use this information to form a key
 *          from the values of the identifier attributes.<br>
 *          Some types may not be identifiable as they always appear as part of some other types. {@code Address} is
 *          one such type in the example above.</dd>
 * 
 *      <dt>Indexed Attribute</dt>
 *      <dd> An attribute can be qualified to be indexed. For example, the {@code Person.name} attribute has been specified 
 * to use an index {@code "name" : {"indexed":true}}.</dd>
 * 
 * 		<dt>Container Type</dt>
 * 		"email": {"type": "string[]"},
 * 		<dt>Map Type</dt>
 * "phones": {"type": "map", "key-type":"Phone", "value-type":"number"}
 * 		<dt>Reference Type</dt>
 * 		"bestFriend":{"type":"Person"}
 * 		<dt>Implicit Type</dt>
 * 		"street": {}
 * 		<dt>Primitive Type</dt>
 *          "age": {"type": "integer"},
 * 
 * @author pinaki poddar
 *
 */
public class DefaultSchemaCompiler extends SchemaCompiler {
	static final String KEYWORD_SCHEMA_NAME  = "name";
	static final String KEYWORD_TYPES        = "types";
	static final String KEYWORD_ENUMS        = "enums";
	static final String KEYWORD_ATTRIBUTES   = "attributes";
	static final String KEYWORD_IDENTIFIERS  = "identifiers";
	
	/**
	 * Creates a Schema from the given resource containing the schema description.
	 *  
	 */
	@Override
	public Schema parse(InputStream input) {
		try {
			
			JSONObject jsonSchema = new JSONObject(new JSONTokener(input));
			Schema schema = new DefaultSchema(jsonSchema.getString(KEYWORD_SCHEMA_NAME));

			JSONObject types = jsonSchema.getJSONObject(KEYWORD_TYPES);
			JSONObject enums = jsonSchema.getJSONObject(KEYWORD_ENUMS);
			JSONArray typeNames = types.names();
			JSONArray enumNames = enums.names();
			
			for (int i = 0; i < typeNames.length(); i++) {
				String typeName = typeNames.getString(i);
				schema.newType(typeName);
			}
			for (int i = 0; i < enumNames.length(); i++) {
				String enumName = enumNames.getString(i);
				schema.newEnumeratedType(enumName);
			}
			
			for (int i = 0; i < typeNames.length(); i++) {
				String typeName = typeNames.getString(i);
				JSONObject jsonType = types.getJSONObject(typeName);
				UserType type = (UserType)schema.getType(typeName);
				
				populateType(schema, type, jsonType);
			}
			
			for (int i = 0; i < enumNames.length(); i++) {
				String typeName = enumNames.getString(i);
				JSONObject jsonType = enums.getJSONObject(typeName);
				EnumeratedType type = (EnumeratedType)schema.getType(typeName);
				
				populateEnum(schema, type, jsonType);
			}

			return schema;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
	
	void populateEnum(Schema schema, EnumeratedType e, JSONObject jsonEnum) throws JSONException {
		
	}
	
	void populateType(Schema schema, UserType type, JSONObject jsonType) throws JSONException {
		JSONObject jsonAttrs  = jsonType.optJSONObject(KEYWORD_ATTRIBUTES);
		JSONArray identifiers = jsonType.optJSONArray(KEYWORD_IDENTIFIERS);
		List<String> idNames = new ArrayList<String>();
		for (int j = 0; identifiers != null && j < identifiers.length(); j++) {
			idNames.add(identifiers.getString(j));
		}
		JSONArray attrNames = jsonAttrs.names();
		for (int j = 0; j < attrNames.length(); j++) {
			String attr = attrNames.getString(j);
			JSONObject jsonAttr = jsonAttrs.getJSONObject(attr);
			String attrTypeName =  null; 
			if (jsonAttr.has("type")) {
				attrTypeName = jsonAttr.optString("type");
			} else {
				attrTypeName = "string";
			}
			
			Type attrType = defineContainerType(schema, attrTypeName);
			
			type.newAttribute(attr, attrType);
		}
	}
	
	Type defineContainerType(Schema schema, String typeName) {
		if (schema.containsType(typeName)) {
			return schema.getType(typeName);
		}
		NamingPolicy naming = schema.getNamingPolicy();
		if (naming.isPluralTypeName(typeName)) {
			String elementTypeName = naming.getComponentTypeName(typeName);
			Type elementType = schema.getType(elementTypeName);
			if (elementType == null) {
				elementType = defineContainerType(schema, elementTypeName);
			}
			return schema.newContainerType(elementType);
		} else {
			throw new RuntimeException("Unknown type " + typeName);
		}
	}
}
