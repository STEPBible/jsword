package org.crosswire.jsword.index;

/**
 * The IndexPolicyAdapter provides for application resilience against
 * change to IndexPolicy. It defines a reasonable set of defaults for
 * a desktop application, but may not be appropriate for memory limited
 * devices, such as phones, tablets, pdas. The defaults are documented
 * in {@link IndexPolicy}.
 * 
 */
public class IndexPolicyAdapter implements IndexPolicy {

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isStrongsIndexed()
     */
    public boolean isStrongsIndexed() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isMorphIndexed()
     */
    public boolean isMorphIndexed() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isNoteIndexed()
     */
    public boolean isNoteIndexed() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isTitleIndexed()
     */
    public boolean isTitleIndexed() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isXrefIndexed()
     */
    public boolean isXrefIndexed() {
        return true;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#getRAMBufferSize()
     */
    public int getRAMBufferSize() {
        return 16;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.index.IndexPolicy#isSerial()
     */
    public boolean isSerial() {
        return false;
    }

}
