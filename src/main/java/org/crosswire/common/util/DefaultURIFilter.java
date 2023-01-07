package org.crosswire.common.util;

/**
 * An URIFilter that accepts all names.
 */
public class DefaultURIFilter implements URIFilter {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.util.URIFilter#accept(java.lang.String)
     */
    public boolean accept(String name) {
        return true;
    }
}
