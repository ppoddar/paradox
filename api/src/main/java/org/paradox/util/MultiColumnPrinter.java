package org.paradox.util;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Prints data in multiple columns.
 * 
 *
 * @since 1.0
 *
 */
public class MultiColumnPrinter {
  private final ColumnSpec[] _columnSpecs;
  private int _pos;
  private final PrintWriter _writer;
  
  public MultiColumnPrinter() {
	  this(new PrintWriter(System.out), new ColumnSpec(0,80));
  }
  public MultiColumnPrinter(ColumnSpec... specs) {
	  this(new PrintWriter(System.out), new ColumnSpec(0,80));
  }
  public MultiColumnPrinter(PrintWriter writer) {
	  this(writer, new ColumnSpec(0,80));
  }
  public MultiColumnPrinter(PrintWriter writer, ColumnSpec...specs) {
		  _writer = writer;
		  if (specs == null || specs.length == 0)
			  throw new IllegalArgumentException("Must have ata least one column specification");
		  _columnSpecs = specs;
	  }
  /**
   * Print given string on the same line without honoring
   * column boundaries. 
   * @param s a string to print
   */
  public void print(String s) {
    _writer.print(s);
    _pos += s.length();
    _writer.flush();
  }
  
  /**
   * Print each string in column.
   * @param columns the strings to be printed in columns.
   * All strings of a line must be supplied together.
   */
  public void printColumn(String...columns) {
    goToColumn(0);
    List<String[]> textMatrix = new ArrayList<String[]>();
    int col = columns.length;
    int row = 0;
    for (int j = 0; j < col; j++) {
      List<String> parts = _columnSpecs[j].split(columns[j]);
      row = Math.max(row, parts.size());
      textMatrix.add(new String[0]);
      textMatrix.set(j,parts.toArray(new String[parts.size()]));
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (textMatrix.get(j).length <= i) {
          if (j >= col-1) newLine(); else goToColumn(j+1);
          continue;
        }
        
        String s = textMatrix.get(j)[i];
        print(s);
        if (j < col-1) goToColumn(j+1);
        else newLine();
      }
    }
  }
  
  /**
   * cursor goes to next line.
   */
  private void newLine() {
    _pos = 0;
    _writer.println();
    moveHorizontal(_columnSpecs[0]._start);
    
  }
  
  /**
   * cursor moves to right, if possible.
   * @param to the target cursor position
   * @throws IllegalArgumentException if the target position is left of
   * current cursor position.
   */
  private void moveHorizontal(int to) {
    if (to < _pos)
      throw new IllegalArgumentException("Can not move back from " + _pos + " to " + to);
    for (int i = _pos; i < to; i++) {
      print(" ");
    }
  }
  
  /**
   * moves cursor to the beginning of the given column.
   * @param col 0-based column index
   */
  void goToColumn(int col) {
      moveHorizontal(_columnSpecs[col]._start);
  }
  
  
  public static void main(String[] args) throws Exception {
    ColumnSpec[] specs = new ColumnSpec[]{
           new ColumnSpec(4,12), 
           new ColumnSpec(16, 36),
           new ColumnSpec(53, 20),
           new ColumnSpec(74, 80)};
    MultiColumnPrinter printer = new MultiColumnPrinter(specs);
    
    printer.printColumn("column 1 is moderately long to test first column wrapping", 
        "column 2 is a very long line that is expected to be wrapped" +
      " across multiple lines", "column 3 is short", "last column");
  }
  
  
  /**
   * A column specification.
   */
  public static class ColumnSpec {
    final int _start;
    final int _width;
    
    /**
     * Start column and width (in character unit).
     * @param s
     * @param w
     */
    public ColumnSpec(int s, int w) {
      _start = s;
      _width = w;
    }
    /**
     * Splits the given string such that no part
     * is longer than given width.
     * @param s
     * @param w maximum width in number of character 
     * @return
     */
    List<String> split(String s) {
      List<String> parts = new ArrayList<String>();
      while (s.length() > _width) {
        int L = _width;
        while (L > 0 && !Character.isWhitespace(s.charAt(L))) --L;
        parts.add(s.substring(0,L));
        s = s.substring(L);
      }
      if (s.length() > 0) parts.add(s);
      return parts;
    }
  }
}
