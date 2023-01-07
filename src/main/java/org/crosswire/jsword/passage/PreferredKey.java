package org.crosswire.jsword.passage;

/**
 * For any time when a component wishes to express a preference for a Key. This
 * interface will often be optional to allow objects to not specify a
 * preference.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public interface PreferredKey {
    /**
     * What Key would this object like us to use?
     * 
     * @return The preferredKey
     */
    Key getPreferred();
}
