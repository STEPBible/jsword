package org.crosswire.jsword.passage;

/**
 * A default implementation of KeyVisitor that does nothing, for use in
 * inheritance where you want to save space by not overriding all methods.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
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
