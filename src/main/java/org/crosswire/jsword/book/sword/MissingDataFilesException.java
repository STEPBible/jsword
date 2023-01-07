package org.crosswire.jsword.book.sword;

import org.crosswire.jsword.book.BookException;

/**
 * Indicates that the files are missing, and therefore this book should be excluded
 */
public class MissingDataFilesException extends BookException {
    /**
     * Instantiates a new missing data files exception.
     *
     * @param msg the msg
     */
    public MissingDataFilesException(String msg) {
        super(msg);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = -130074367541462750L;
}
