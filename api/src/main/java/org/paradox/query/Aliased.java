package org.paradox.query;

public interface Aliased {
	/**
	 * Affirms if this expression has been aliased.
	 */
	boolean isAliased();
	
	public String getAlias();
	
	public void setAlias(String alias);
}
