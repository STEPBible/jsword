package org.crosswire.common.util;

/**
 * This is the URI equivalent of FilenameFilter in the java.io package.
 * @see java.io.FilenameFilter
 */
public interface URIFilter {
    /**
     * Tests if a specified file should be included in a file list.
     * 
     * @param name
     *            the name of the file.
     * @return <code>true</code> if and only if the name should be included in
     *         the file list; <code>false</code> otherwise.
     */
    boolean accept(String name);
}
