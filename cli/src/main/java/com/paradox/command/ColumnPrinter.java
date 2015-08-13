package com.paradox.command;

import java.io.PrintWriter;

/**
 * Prints in column.
 *
 * @since 1.0
 *
 */
public class ColumnPrinter {
  private PrintWriter _writer;
  
  private int[] indents;
  private int[] widths;
  
  /**
   * 
   * @param w a writer
   * @param indentAndWidth array of even length. {@code 2*i}-th element
   * is the indent of i-th column, {@code 2*i+1}-th element is the width,
   * both in unit of number of printed characters.
   */
  public ColumnPrinter(PrintWriter w, int[] indentAndWidth) {
    _writer = w;
    indents = new int[indentAndWidth.length/2];
    widths  = new int[indentAndWidth.length/2];
    for (int i = 0; i < indentAndWidth.length-1; i +=2) {
      indents[i/2] = indentAndWidth[i];
      widths[i/2]  = indentAndWidth[i+1];
    }
  }
  
  public void print(String... strings) {
    if (strings.length > indents.length) {
      throw new IllegalArgumentException("More column values");
    }
    int maxLine = 0;
    for (int i = 0; i < strings.length; i++) {
      maxLine = Math.max(maxLine, lines(strings[i],widths[i]));
    }
    String[][] lineMatrix = new String[maxLine][indents.length];
    for (int i=0; i < strings.length; i++) {
      if (strings[i] == null) continue;
      String[] lines = wrap(strings[i], widths[i]);
      int j = 0;
      for (String line : lines) {
        lineMatrix[j++][i] = line;
      }
    }
    
    for (int row=0; row < maxLine; row++) {
      for (int col=0; col < indents.length; col++) {
        String txt = lineMatrix[row][col];
        if (txt == null) {
          repeat(indents[col] + widths[col], ' ');
        } else {
          repeat(indents[col], ' ');
          _writer.print(txt);
          repeat(widths[col] - txt.length(), ' ');
        }
      }
      _writer.println();
      _writer.flush();
    }
  }
  void repeat(int n, char c) {
    for (int i = 0; i < n; i++) _writer.print(c);
  }
  String[] wrap(String txt, int w) {
    int L = txt.length();
    if (L <= w) return new String[]{txt};
    int N = lines(txt, w);
    String[] lines = new String[N];
    for (int i = 0; i < N; i++) {
      lines[i] = txt.substring(i*w, Math.min(i*w+w, txt.length()));
    }
    return lines;
  }
  
  int lines(String txt, int w) {
    int L = txt.length();
    int N = L/w;
    if (L%w > 0) N++;
    return N;
  }
  
  public static void main(String[] args) throws Exception {
    ColumnPrinter printer = new ColumnPrinter(new PrintWriter(System.out), new int[]{8,16,4,40,6,12});
    printer.print("colum0", "this is a a long text in the middle column that must span more than a line",
        "a trailing column");
  }
}
