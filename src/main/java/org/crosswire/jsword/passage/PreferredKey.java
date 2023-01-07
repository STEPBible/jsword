package org.crosswire.jsword.passage;

/**
 * For any time when a component wishes to express a preference for a Key. This
 * interface will often be optional to allow objects to not specify a
 * preference.
 */
public interface PreferredKey {
    /**
     * What Key would this object like us to use?
     * 
     * @return The preferredKey
     */
    Key getPreferred();
}
