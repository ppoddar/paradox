package com.paradox.command;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import oracle.kv.KVStore;
import oracle.kv.KVStoreConfig;
import oracle.kv.KVStoreFactory;
import oracle.kv.Key;
import oracle.kv.ValueVersion;

import org.json.JSONObject;

import com.oracle.nosql.query.DefaultKeyMaker;
import com.oracle.nosql.query.DefaultQueryContext;
import com.oracle.nosql.query.QueryContextBuilder;
import com.oracle.nosql.query.json.JSONResultPacker;
import com.oracle.nosql.query.json.JSONValueTransformer;
import com.oracle.paradox.DataLoader;
import com.paradox.nosql.query.KVQueryContext;
import com.paradox.schema.Attribute;
import com.paradox.schema.Schema;
import com.paradox.schema.UserType;
import com.paradox.schema.impl.SchemaCompiler;

/**
 * A command-line client for SQL query on NoSQL.
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
	
	public Paradox() throws Exception {
		super();
		URL url = getClass().getResource("paradox-commands.xml");
		if (url == null)
			throw new RuntimeException("Can not load commands.xml");
		init(url.openStream(), new File(System.getProperty("user.home"), ".paradox-history"));
	}
	
	
	public void connect(String urlString) throws URISyntaxException {
		URI url = new URI(urlString);
		if (!"nosql".equals(url.getScheme()))
			throw new URISyntaxException(urlString, "Invalid scheme [" + url.getScheme() + "]. Scheme must be 'nosql'");
		String storeName = url.getUserInfo() == null ? "kvlite"    : url.getUserInfo();
		String host      = url.getHost() == null     ? "localhost" : url.getHost();
		int port         = url.getPort() == -1       ? 5000        : url.getPort();
		KVStoreConfig config = new KVStoreConfig(storeName, host+':'+port);
		try {
			KVStore newStore = KVStoreFactory.getStore(config);
			_store = newStore;
			_uri = url;
		} catch (Throwable t) {
			throw new RuntimeException("Can not connect to [" + urlString + "] because " + t.getMessage(), t);
		}
	}
	
	public void loadSchema(String rsrc) throws URISyntaxException {
		_schema = SchemaCompiler.compile(rsrc);
		_schemaURI = new URI(rsrc);
	}
	
	public void status() {
		println("\t" + (_store  != null ? "Connected to " + _uri       : "*** Not connetced to NoSQL store"));
		println("\t" + (_schema != null ? "Using schema " + _schemaURI : "*** Not loaded a schema"));
	}
	
	public DefaultQueryContext<JSONObject> getQueryContext() {
		assertActive();
		return new QueryContextBuilder<JSONObject>(_store, _schema)
					.withKeyMaker(new DefaultKeyMaker())
					.withValueTransformer(new JSONValueTransformer())
					.withResultPacker(JSONResultPacker.class)
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
	protected void execute(String cmd, String line,
			Map<String, String> options, List<String> args) throws Exception {
		if ("get".equalsIgnoreCase(cmd.toString())) {
			new Get().execute(args);
		} else if ("connect".equalsIgnoreCase(cmd.toString())) {
			connect(args.get(0));
		} else if ("exit".equalsIgnoreCase(cmd.toString())) {
			System.exit(0);
		} else if ("schema".equalsIgnoreCase(cmd.toString())) {
			if (args.size() > 0) {
				loadSchema(args.get(0));
			} else if (_schema != null) {
				new SchemaPrinter().print(_schema, getPrinter());
			} else {
				handleError(new IllegalStateException("No schema is loaded. See help schema"));
			}
		} else if ("data".equalsIgnoreCase(cmd.toString())) {
			BufferedReader reader = new BufferedReader(new FileReader(args.get(0)));
			DataLoader.loadData(getQueryContext(), options.get("type"), reader);
		} else if ("select".equalsIgnoreCase(cmd.toString())) {
			new SelectQuery().execute(line);
		} else if ("status".equalsIgnoreCase(cmd)) {
			status();
		} 
		
	}

	
	public class Get {
		public void execute(List<String> keys)	throws Exception {
			DefaultQueryContext<JSONObject> ctx = getQueryContext();
			
			 for (String k : keys) {
				 Key key = Key.fromString(k);
				 ValueVersion vv = ctx.getStore().get(key);
				 println(key + " \t " + ctx.getValueTransformer().decode(vv.getValue()));
			 }
		}
	}
	
	public class SelectQuery {
		public void execute(String cmdLine) throws Exception {
			long start = System.currentTimeMillis();
			Iterator<JSONObject> results = getQueryContext().executeQuery(cmdLine);
			long elapsed = System.currentTimeMillis() - start;
			int count = 0;
			for (; results.hasNext(); count++) {
				println("\t["+ count +"]: " + results.next());
			}
			println("Query executed in " + elapsed + "ms and selected " 
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
