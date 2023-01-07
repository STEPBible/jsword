package org.crosswire.jsword.book.filter.gbf;

/**
 * A class that packages start and end Tags together.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public interface TagBuilder {
    /**
     * Is the <code>name</code> one that we can create a Tag for?. If so then we
     * return a Tag, but if not we return null.
     * 
     * @param name
     *            The tag name to test
     * @return a new tag or null if the name isn't one we know about
     */
    Tag createTag(String name);
}
