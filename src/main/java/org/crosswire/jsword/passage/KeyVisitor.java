package org.crosswire.jsword.passage;

/**
 * An interface for components wanting to visit all the nodes in a Key tree.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */
public interface KeyVisitor {
    /**
     * We've found a leaf node in a Key tree, and are giving the visitor a
     * chance to do processing based on it.
     * 
     * @param key
     *            The found leaf node.
     */
    void visitLeaf(Key key);

    /**
     * We've found a branch node in a Key tree, and are giving the visitor a
     * chance to do processing based on it.
     * 
     * @param key
     *            The found branch node.
     */
    void visitBranch(Key key);
}
