package com.paradox.command;

import java.io.Console;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

/**
 * A command-line client. Uses jLine for console based input. The command
 * descriptions are specified in a XML descriptor compliant to a <a
 * href="./commands.xsd">Command Specification Schema</a> . See <a
 * href="./paradox-commands.xml">comamnds.xml</a> for an example. <br>
 * Provides help for registered commands. <br>
 * 
 * @author pinaki poddar
 *
 */
public abstract class AbstractCommandLineClient implements Runnable, ErrorHandler {
  private Console _console;
  private PrintStream _output;
  private PrintWriter _consoleWriter;

  private String _description;
  private String _prompt;
  private String _greetings;

  private Map<String, CommandMetaData> _metas = new TreeMap<String, CommandMetaData>();

  static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
  static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";
  static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
  static final String COMMAND_SPEC_XSD = "commands.xsd";

  protected AbstractCommandLineClient(String prompt) throws Exception {
    _prompt = prompt;
    _consoleWriter = new PrintWriter(_output = System.out, true);
    _console = System.console();

    Runtime.getRuntime().addShutdownHook(new Thread(new ShutdownHook()));

  }

  /**
   * Execution loop reads command line and executes commands.
   */
  @Override
  public final void run() {
    greet();
    String line = null;
    while ((line = _console.readLine("%s", _prompt)) != null) {
      if (line.isEmpty())
        continue;
      try {
        executeCommandLine(line);
      } catch (ParseException ex) {
        println("*** ERROR: " + ex.getMessage());
      } catch (InvocationTargetException ex) {
        println("*** ERROR: " + ex.getTargetException().getMessage());
        println("Execution Stacktrace:");
        ex.getTargetException().printStackTrace(_consoleWriter);
      } catch (Throwable t) {
        handleError(t);
      }
    }
  }

  /**
   * Execute the command registered as the given command moniker.
   * 
   * @param cmd
   *          moniker of the command
   * @param line
   *          the entire command line
   * @param options
   *          the parsed options
   * @param args
   *          the parsed arguments
   * @throws Exception
   *           raise exception from execution. This client will print it on
   *           console.
   */
  protected abstract void execute(String cmd, String line, Map<String, String> options, List<String> args)
      throws Exception;

  /**
   * Prints details about the command identified by the given moniker.
   * 
   * @param cmd
   *          moniker of a given command. If null prints the available commands
   */
  public void help(String cmd) {
    if (cmd == null) {
      prettyPrint(_metas, MAX_WIDTH, TAB);
      return;
    }
    CommandMetaData meta = _metas.get(cmd);
    if (meta == null) {
      println("*** " + cmd + " is not a known command. Type help for available commands");
      return;
    }

    printIndented(TAB, cmd, cmd.length() + 2 * TAB, meta.description, MAX_WIDTH);
    println();
    println("Usage : " + meta.getUsage());

    if (!meta._options.isEmpty()) {
      println("where options are:");
      prettyPrintOptions(meta._options, MAX_WIDTH, TAB);
    }
    if (!meta._args.isEmpty()) {
      _consoleWriter.println("arguments are:");
      prettyPrintArgs(meta._args, MAX_WIDTH, TAB);
    }
  }

  void prettyPrint(Map<String, CommandMetaData> data, int maxWidth, int tab) {
    int w1 = findLongestString(data.keySet());
    for (Map.Entry<String, CommandMetaData> e : data.entrySet()) {
      printIndented(tab, e.getKey(), w1 + 2 * tab, e.getValue().description, maxWidth);
    }
  }

  void prettyPrintOptions(List<CommandOption> data, int maxWidth, int tab) {
    int widest = 0;
    for (CommandOption e : data) {
      widest = Math.max(e.flag.length(), widest);
    }
    int margin2 = widest + 1 + 2 * tab;
    for (CommandOption e : data) {
      printIndented(tab, '-' + e.flag, margin2, e.description, maxWidth);
    }
  }

  void prettyPrintArgs(List<CommandArg> data, int maxWidth, int tab) {
    int widest = 0;
    for (CommandArg e : data) {
      widest = Math.max(e.name.length(), widest);
    }
    int margin2 = widest + 2 * tab;
    for (CommandArg e : data) {
      printIndented(tab, e.name, margin2, e.description, maxWidth);
    }
  }

  private static int TAB = 4;
  private static int MAX_WIDTH = 80;

  /**
   * Prints two column output.
   * 
   * @param margin1
   *          the column index where first column begins
   * @param col1
   *          the content for first column
   * @param margin2
   *          the column index where second column begins
   * @param col2
   *          the content for second column
   * @param maxWidth
   *          maximum width of a line
   */
  void printIndented(int margin1, String col1, int margin2, String col2, int maxWidth) {
    int col = 0;
    for (; col < margin1; col++)
      printGap();
    print(col1);
    col += col1.length();
    for (; col < margin2; col++)
      printGap();

    StringTokenizer tokenizer = new StringTokenizer(col2, " \r\n\t");
    boolean newLine = true;
    while (tokenizer.hasMoreElements()) {
      if (newLine) {
        for (; col < margin2; col++)
          printGap();
      }
      newLine = false;
      String token = tokenizer.nextToken();
      print(token);
      printGap();
      col += (token.length() + 1);
      if (col > maxWidth) {
        println();
        newLine = true;
        col = 0;
      }
    }
    if (!newLine)
      println();
  }

  int findLongestString(Set<String> strings) {
    int L = 0;
    for (String s : strings) {
      L = Math.max(L, s == null ? 0 : s.length());
    }
    return L;
  }

  protected PrintWriter getPrinter() {
    return _consoleWriter;
  }

  public void println(String message) {
    _consoleWriter.println(message);
    _consoleWriter.flush();
  }

  void print(String message) {
    _consoleWriter.print(message);
    _consoleWriter.flush();
  }

  void printGap() {
    print(" ");
  }

  void println() {
    println("");
  }

  public void handleError(Throwable t) {
    println("*** ERROR: " + t.getClass().getName() + ": " + t.getMessage());
    if (t.getCause() != null && t.getCause() != t) {
      handleError(t.getCause());
    }
  }

  void greet() {
    println();
    println("\t\t" + _greetings);
    println();
  }

  protected void setPrompt(String p) {
    if (p != null)
      _prompt = p;
  }

  /**
   * Reads the contents of the given input as an XML document for command
   * metadata.
   * 
   * @param in
   * @throws Exception
   */
  protected void readCommandSpecifications(InputStream in) throws Exception {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(true);
    factory.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
    InputStream schema = AbstractCommandLineClient.class.getResourceAsStream(COMMAND_SPEC_XSD);
    factory.setAttribute(JAXP_SCHEMA_SOURCE, schema);

    DocumentBuilder parser = factory.newDocumentBuilder();
    parser.setErrorHandler(this);
    Element root = parser.parse(in).getDocumentElement();
    if (!_xmlErrors.isEmpty()) {
      for (SAXParseException ex : _xmlErrors) {
        System.err.println(ex);
      }
      throw new RuntimeException(_xmlErrors.get(0));
    }
    _greetings = root.getAttribute("greetings");
    _prompt = root.getAttribute("prompt");
    _description = readTextContent(root, "description");

    NodeList commandsList = root.getElementsByTagName("command");
    for (int i = 0; i < commandsList.getLength(); i++) {
      CommandMetaData meta = new CommandMetaData((Element) commandsList.item(i));
      _metas.put(meta.key, meta);
    }
  }

  private static enum ParseState {
    READ_OPTION, READ_OPTION_VALUE, READ_KEY, READ_ARGS
  };

  /**
   * Parses the command line according to command metadata and invokes execution
   * of the command to the concrete subclass with the parsed option values and
   * arguments
   * 
   * @param line
   *          a command line
   */
  protected void executeCommandLine(String line) throws Exception {
    StringTokenizer tokenizer = new StringTokenizer(line);
    Map<String, String> optionValues = new HashMap<String, String>();
    List<String> args = new ArrayList<String>();
    String cmd = null;
    CommandMetaData meta = null;
    CommandOption option = null;
    ParseState state = ParseState.READ_KEY;
    while (tokenizer.hasMoreElements()) {
      String token = tokenizer.nextToken();
      switch (state) {
      case READ_KEY:
        cmd = token;
        meta = _metas.get(token);
        if (meta == null) {
          help(token);
          return;
        } else if ("help".equalsIgnoreCase(cmd)) {
          help(tokenizer.hasMoreElements() ? tokenizer.nextToken() : null);
        }
        if (!meta.requiresParse) {
          execute(cmd, line, optionValues, args);
          return;
        }
        state = ParseState.READ_OPTION;
        break;
      case READ_OPTION:
        if (token.startsWith("-")) {
          option = meta.getOption(token.substring(1));
          if (option != null) {
            optionValues.put(option.flag, null);
            if (option.requiresValue && !tokenizer.hasMoreElements()) {
              throw new ParseException("Missing value for option [" + token + "]", 0);
            }
            state = option.requiresValue ? ParseState.READ_OPTION_VALUE : ParseState.READ_OPTION;
          } else {
            throw new ParseException("Unknow option [" + token + "]", 0);
          }
        } else {
          state = ParseState.READ_ARGS;
          args.add(token);
        }
        break;
      case READ_OPTION_VALUE:
        optionValues.put(option.flag, token);
        state = ParseState.READ_OPTION;
        break;
      case READ_ARGS:
        args.add(token);
        break;
      }
    }
    boolean validated = false;
    try {
      validated = meta.validate(optionValues, args);
    } catch (ParseException ex) {
      println("*** ERROR: " + ex.getMessage());
      println("Type 'help " + cmd + "' for command syntax and usage");
    }
    if (validated) { // finally
      try {
        execute(cmd, line, optionValues, args);
      } catch (Throwable t) {
        throw new InvocationTargetException(t);
      }
    }
  }

  /**
   * Metadata about a command sourced from a XML element.
   *
   */
  public static class CommandMetaData {
    String key;
    List<CommandOption> _options = new ArrayList<CommandOption>();
    List<CommandArg> _args = new ArrayList<CommandArg>();
    String description;
    String usage;
    boolean requiresParse = true;

    public CommandMetaData(Element e) {
      key = e.getAttribute("key");
      requiresParse = readBooleanAttribute(e, "parse", true);
      description = readTextContent(e, "description");
      usage = readTextContent(e, "usage");
      NodeList children = e.getChildNodes();
      for (int i = 0; i < children.getLength(); i++) {
        Node c = children.item(i);
        if (c instanceof Element) {
          Element child = (Element) c;
          String tag = child.getTagName();
          if ("option".equals(tag)) {
            _options.add(new CommandOption(child));
          } else if ("arg".equals(tag)) {
            _args.add(new CommandArg(child));
          }
        }
      }
    }

    public void addOption(CommandOption option) {
      _options.add(option);
    }

    CommandOption getOption(String flag) {
      for (CommandOption option : _options) {
        if (flag.equals(option.flag)) {
          return option;
        }
      }
      return null;
    }

    boolean validate(Map<String, String> optionValues, List<String> args) throws ParseException {
      for (CommandOption option : _options) {
        if (!option.optional && !optionValues.containsKey(option.flag)) {
          throw new ParseException("Missing mandatory option [-" + option.flag + "]", 0);
        }
      }
      int argMin = 0;
      for (CommandArg arg : _args) {
        argMin += arg.minOccurs;
      }
      if (args.size() < argMin) {
        throw new ParseException("Insufficient arguments. Minimum " + argMin + " required, " + args.size()
            + " supplied", 0);
      }
      return true;
    }

    public String getUsage() {
      if (!requiresParse)
        return usage;
      StringBuffer buf = new StringBuffer();
      buf.append(key).append(" ");
      for (CommandOption option : _options) {
        buf.append(option);
        buf.append(" ");
      }
      for (CommandArg arg : _args) {
        buf.append(arg);
        buf.append(" ");
      }
      return buf.toString();
    }

  }

  public static class CommandOption {
    String flag;
    String name;
    String description;
    boolean optional;
    boolean requiresValue;
    Class<?> type;

    public CommandOption(Element e) {
      flag = e.getAttribute("flag");
      name = e.hasAttribute("name") ? e.getAttribute("name") : flag;
      requiresValue = readBooleanAttribute(e, "requiresValue", true);
      optional = readBooleanAttribute(e, "optional", false);
      description = readTextContent(e, "description");
    }

    public String toString() {
      StringBuilder buf = new StringBuilder();
      buf.append(optional ? '(' : '[');
      buf.append('-').append(flag);
      if (requiresValue)
        buf.append(" <").append(name).append('>');
      buf.append(optional ? ')' : ']');

      return buf.toString();
    }
  }

  public static class CommandArg {
    String name;
    String description;
    int maxOccurs;
    int minOccurs;

    CommandArg(Element e) {
      name = e.getAttribute("name");
      maxOccurs = readIntAttribute(e, "maxOccurs", 1);
      minOccurs = readIntAttribute(e, "minOccurs", 0);
      description = readTextContent(e, "description");
    }

    public String toString() {
      if (maxOccurs == 1)
        return name;
      char cardinality = maxOccurs > 1 ? '+' : '*';
      return '(' + name + ')' + cardinality;
    }

  }

  static int readIntAttribute(Element e, String attr, int def) {
    if (e.hasAttribute(attr)) {
      try {
        return Integer.parseInt(e.getAttribute(attr));
      } catch (NumberFormatException ex) {

      }
    }
    return def;
  }

  static boolean readBooleanAttribute(Element e, String attr, boolean def) {
    if (e.hasAttribute(attr)) {
      return Boolean.parseBoolean(e.getAttribute(attr));
    }
    return def;
  }

  /**
   * Reads the content of a text-only child node of the given parent.
   */
  static String readTextContent(Element parent, String child) {
    NodeList nodes = parent.getElementsByTagName(child);
    return (nodes.getLength() > 0) ? nodes.item(0).getTextContent() : "";
  }

  private List<SAXParseException> _xmlErrors = new ArrayList<SAXParseException>();

  @Override
  public void error(SAXParseException ex) {
    _xmlErrors.add(ex);
  }

  @Override
  public void fatalError(SAXParseException ex) {
    _xmlErrors.add(ex);
  }

  @Override
  public void warning(SAXParseException ex) {
    _xmlErrors.add(ex);
  }

  private class ShutdownHook implements Runnable {

    @Override
    public void run() {
      _consoleWriter.println("Bye...");
    }
  }

}
