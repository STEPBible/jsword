package org.crosswire.jsword.passage;

/**
 * A default implementation of KeyVisitor that does nothing, for use in
 * inheritance where you want to save space by not overriding all methods.
 */
public class DefaultKeyVisitor implements KeyVisitor {
    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.KeyVisitor#visitLeaf(org.crosswire.jsword
     * .passage.Key)
     */
    public void visitLeaf(Key key) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.KeyVisitor#visitBranch(org.crosswire.jsword
     * .passage.Key)
     */
    public void visitBranch(Key key) {
    }
}
