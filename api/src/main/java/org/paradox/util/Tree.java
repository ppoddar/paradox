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

package org.paradox.util;

import java.util.Iterator;
import java.util.List;

/**
 * An N-ary tree.
 * <br>
 * Each node carries data of identical (parameterized) type.
 * Can be {@link #search(List)} searched on associated data as key. 
 */
public interface Tree<T> {
	/** Breadth-first traversal mode */
	public static final int BREADTH_FIRST = 1;
	/** Depth-first traversal mode */
	public static final int DEPTH_FIRST   = 2;
	
  /**
   * Gets the data associated with the receiver.
   * @return can be null
   */
  T get();
  
  /**
   * Find a tree that matches the given data.
   * @param t data to be matched
   * @return a matching tree node or null
   */
  Tree<T> find(T t);
  
  /**
   * Find a tree that matches the given path.
   * @param path a series of data points
   * @return a series of tree nodes such that data at the
   * its i-th element is equal to the i-th element of the
   * given list
   * 
   */
  Tree<T> search(List<T> path);
  
  /**
   * Gets the tree of the given path
   * @param indices list of indices
   * @return
   */
  Tree<T> getByPath(int... indices);
  
  /**
   * Gets the tree of the given path
   * @param indices list of indices
   * @return
   */
  Tree<T> getByPath(List<Integer> indices);
  
  /**
   * Gets the depth as number of intermediate nodes 
   * to {@link #getRoot() root} node.
   * @return 0 for root node, positive for any other
   */
  int getDepth();
  
  /**
   * Gets the highest number of intermediate nodes to a leaf.
   * @return 0 for leaf, positive otherwise
   */
  int getHeight();
  
  /**
   * A depth-first iterator on values.
   * @return
   */
  Iterator<Tree<T>> iterator();
  
  /**
   * 
   * @param mode BREADTH_FIRST or DEPTH_FIRST
   * @param leaf if true only the leaf nodes
   * @return
   */
  Iterator<Tree<T>> iterator(int mode);
  
  /**
   * Gets the index of the given child.
   * @param child
   * @return 
   * @throws IllegalArgumentException if not a child
   */
  int indexOf(Tree<T> child);
  
  /** Gets the i-th child.
   * 
   * @param i
   * @return
   * @throws IllegalStateException if the receiver is a {@link #isLeaf() leaf).
   */
  Tree<T> getChild(int i);
  
  /**
   * Gets the parent node. The parent node of {@link #isRoot() root}
   * is null.
   * @return null for {@link #isRoot() root} node. Not null otherwise.
   */
  Tree<T> getParent();
  
  
  /**
   * Gets the root node. The root node of {@link #isRoot() root}
   * is itself.
   * @return never null.
   */
  Tree<T> getRoot();
  
  /** Gets the number of children nodes.
   * 
   * @param i
   * @return
   */
  int getChildCount();
  
  /**
   * Adds the given child to this receiver.
   * 
   * @param child must be not null. Must either have no parent 
   * or have this receiver as parent.
   */
  void addChild(Tree<T> child);
  
  /**
   * Set the given parent.
   * 
   * @param parent must not be null. 
   * @throws IllegalStateException if this receiver already 
   * has a non-null parent not same as teh given parent.
   */
  void setParent(Tree<T> parent);
  
  /**
   * Affirms if this receiver has no parent.
   * @return
   */
  boolean isRoot();
  
  /**
   * Affirms if this receiver has no child node.
   * @return
   */
  boolean isLeaf();
  
 
}
