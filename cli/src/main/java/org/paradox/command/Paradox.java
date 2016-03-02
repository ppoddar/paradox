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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.ValueVersion;

import org.json.JSONObject;
import org.paradox.query.impl.nosql.DefaultKeyMaker;
import org.paradox.query.impl.nosql.DefaultQueryContext;
import org.paradox.query.impl.nosql.JSONValueTransformer;
import org.paradox.query.impl.nosql.QueryContextBuilder;
import org.paradox.schema.Attribute;
import org.paradox.schema.Schema;
import org.paradox.schema.UserType;
import org.paradox.schema.impl.SchemaCompiler;
import org.paradox.util.NoSQLURL;

/**
 * A command-line client.
 * 
 * @author pinaki poddar
 *
 */
public class Paradox extends AbstractCommandLineClient {
	private KVStore         _store;
	private URI             _uri;
	private URI             _schemaURI;
	private Schema          _schema;
	
	public static void main(String[] args) throws Exception {
		new Paradox().run();
	}
	
	private Paradox() {
		setGreeting("Welcome to Paradox");
		setPrompt("paradox> ");
		setHelp("help");
		
		Command get = new Command("get").setDescription("Gets the value for the given key(s)");
		get.defineArgument().setName("key(s)").setDescription("key used for  NoSQL datastore");
		
		Command loadSchema = new Command("load", "schema").setDescription("Reads a schema descriptor file to build a Schema");
		loadSchema.defineArgument().setName("schema descriptor").setDescription("A resource name. The resource defines available types and their attributes in JSON format");
		Command showSchema = new Command("show", "schema").setDescription("Shows the current schema");
		
		Command connect = new Command("connect").setDescription("Connects to a NoSQL Key-Value data store");
		connect.defineArgument().setName("url").setDescription("Connection URL format is nosql://store-name@host:port. Default host is 'localhost'." +"Default port is 5000.");
		
		Command select = new Command("select").setDescription("Executes a SQL select statement");
		select.requiresParse(false)
		      .removesIdentifier(false);
		select.setUsage("select [projection|*] from [type] (where predicate (and|or predicate)) (order by) (group by) (skip n) (limit n)");
		
		Command status = new Command("status").setDescription("Prints current state of the client");
		
		Command loadData = new Command("load", "data").setDescription("Loads data from a given JSON file");
		loadData.defineOption("-type").setName("type").setDescription("A user defined type in the schema");
		loadData.defineOption("-validate").requiresValue(false).setDescription("Validates data by the schema");
		loadData.defineArgument().setName("data file").setDescription("a file where each line contains a JSON formatted data for a given type");
		
		Command exit = new Command("exit").setDescription("Exits this program");

		
		registerCommand(get);
		registerCommand(connect);
		registerCommand(loadData);
		registerCommand(loadSchema);
		registerCommand(showSchema);
		registerCommand(select);
		registerCommand(status);
		registerCommand(exit);
		
	}
	
	
	public void connect(String urlString) throws URISyntaxException, MalformedURLException {
		NoSQLURL url = new NoSQLURL(urlString);
		KVStoreConfig config = new KVStoreConfig(url.getStoreName(), url.getHostPorts());
		try {
			KVStore newStore = KVStoreFactory.getStore(config);
			_store = newStore;
			_uri = new URI(url.getFullString());
		} catch (Throwable t) {
			throw new RuntimeException("Can not connect to [" + urlString + "] because " + t.getMessage(), t);
		}
	}
	
	public void loadSchema(String rsrc) throws URISyntaxException {
		_schema = SchemaCompiler.compile(rsrc);
		_schemaURI = new URI(rsrc);
	}
	
	public void status() {
		getWriter().println("\t" + (_store  != null ? "Connected to " + _uri       : "*** Not connetced to NoSQL store"));
		getWriter().println("\t" + (_schema != null ? "Using schema " + _schemaURI : "*** Not loaded a schema"));
	}
	
	public DefaultQueryContext getQueryContext() {
		assertActive();
		return new QueryContextBuilder(_store, _schema)
					.withKeyMaker(new DefaultKeyMaker())
					.withValueTransformer(new JSONValueTransformer())
					.build();
	}

	void assertActive() {
		if (_store  == null) throw new IllegalStateException("Not connected. See help for connect");
		if (_schema == null) throw new IllegalStateException("Schema not defined. See help for schema");
	}
	
	public KVStore getStore() {
		return _store;
	}

	
	public boolean isActive() {
		return _store != null && _schema != null;
	}


	@Override
	protected void execute(ParsedCommand parsed) throws Exception {
		Command cmd = parsed.getOriginal();
		System.err.println("Parsed command [" + parsed.getLine() + "]");
		if (cmd.recognizes("get")) {
			new Get().execute(parsed.getArgs());
		} else if (cmd.recognizes("connect")) {
			connect(parsed.getArgs(0));
		} else if (cmd.recognizes("exit")) {
			System.exit(0);
		} else if (cmd.recognizes("load schema")) {
			loadSchema(parsed.getArgs(0));
		} else if (cmd.recognizes("show schema")) {
			new SchemaPrinter().print(_schema, getWriter());
		} else if ("load data".equalsIgnoreCase(cmd.toString())) {
			BufferedReader reader = new BufferedReader(new FileReader(parsed.getArgs(0)));
			DataLoader.loadData(getQueryContext(), parsed.getOption("-type"), reader);
		} else if (cmd.recognizes("select")) {
			System.err.println("select query [" + parsed.getLine() + "]");
			new SelectQuery().execute(parsed.getLine());
		} else if (cmd.recognizes("status")) {
			status();
		} 
	}

	
	public class Get {
		public void execute(List<String> keys)	throws Exception {
			DefaultQueryContext ctx = getQueryContext();
			
			 for (String k : keys) {
				 Key key = Key.fromString(k);
				 ValueVersion vv = ctx.getStore().get(key);
				 getWriter().println(key + " \t " + ctx.getValueTransformer().decode(vv.getValue()));
			 }
		}
	}
	
	public class SelectQuery {
		public void execute(String query) throws Exception {
			long start = System.currentTimeMillis();
			Iterator<JSONObject> results = getQueryContext().executeQuery(query);
			long elapsed = System.currentTimeMillis() - start;
			int count = 0;
			for (; results.hasNext(); count++) {
				getWriter().println("\t["+ count +"]: " + results.next());
			}
			getWriter().println("Query [" + query + "] executed in " + elapsed + "ms and selected " 
			   + (count == 0 ? "no" : ""+count) + " key-value pair" + (count < 2 ? "" : "s"));
		}
	}
	
	public class SchemaPrinter {
		public void print(Schema schema, PrintWriter printer) throws Exception {
			Collection<UserType> types = schema.getUserTypes();
			for (UserType uType : types) {
				printer.println(uType.getName());
				Collection<Attribute> attrs = uType.getAttributes();
				for (Attribute attr : attrs) {
					printer.print("\t " + attr.getName() + "\t: " + attr.getType().getName());
					printer.println();
				}
			}
		}
	}
}
