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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * Prints in column.
 *
 * @since 1.0
 *
 */
public class ColumnPrinter extends PrintWriter {
  private int[] indents;
  private int[] widths;
  
  public ColumnPrinter(File file, int[] indentAndWidth) throws FileNotFoundException {
	  super(file);
	  init(indentAndWidth);
  }
  public ColumnPrinter(OutputStream out, int[] indentAndWidth) {
	  super(out);
	  init(indentAndWidth);
  }
  public ColumnPrinter(Writer w, int[] indentAndWidth) {
	  super(w);
	  init(indentAndWidth);
  }
  /**
   * 
   * @param w a writer
   * @param indentAndWidth array of even length. {@code 2*i}-th element
   * is the indent of i-th column, {@code 2*i+1}-th element is the width,
   * both in unit of number of printed characters.
   */
  private void init(int[] indentAndWidth) {
    indents = new int[indentAndWidth.length/2];
    widths  = new int[indentAndWidth.length/2];
    for (int i = 0; i < indentAndWidth.length-1; i +=2) {
      indents[i/2] = indentAndWidth[i];
      widths[i/2]  = indentAndWidth[i+1];
    }
  }
  public void printLine(String s)  {
	  repeat(indents[0], ' ');
	  println(s);
  }
  /**
   * Prints the given strings in each column.
   * @param strings
   */
  public void printColumn(String... strings) {
    if (strings.length > indents.length) {
      throw new IllegalArgumentException("Available columns " + indents.length + " Supplied columns " + strings.length);
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
          print(txt);
          repeat(widths[col] - txt.length(), ' ');
        }
      }
      println();
      flush();
    }
  }
  void repeat(int n, char c) {
    for (int i = 0; i < n; i++) print(c);
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
  
//  public static void main(String[] args) throws Exception {
//    ColumnPrinter printer = new ColumnPrinter(System.out, new int[]{8,16,4,40,6,12});
//    printer.printColumn("colum0", "this is a a long text in the middle column that must span more than a line",
//        "a trailing column");
//  }
}
