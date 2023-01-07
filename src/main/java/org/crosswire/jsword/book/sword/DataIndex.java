package org.crosswire.jsword.book.sword;

/**
 * Data files are indexed by offset and size.
 */
public class DataIndex {
    /**
     * This data index is defined by an offset into a file and the size of the
     * data to retrieve.
     * 
     * @param offset
     *            The position in the file to which to seek
     * @param size
     *            The number of bytes to read from the file.
     */
    public DataIndex(int offset, int size) {
        this.offset = offset;
        this.size = size;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        return offset;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    private int offset;
    private int size;
}
