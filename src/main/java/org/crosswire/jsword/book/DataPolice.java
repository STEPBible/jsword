package org.crosswire.jsword.book;

import org.crosswire.jsword.passage.Key;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * When we can't convert some source data then the user doesn't really care and
 * just wants it to work, but it would be good to have some way to get the
 * problems fixed, so as a start point we report them through this class.
 */
public final class DataPolice {
    /**
     * Prevent instantiation
     */
    private DataPolice() {
    }

    /**
     * Report a message against the current book and key.
     * 
     * @param book
     *            the book against which to report
     * @param key
     *            the key against which to report
     * @param message
     *            the police report.
     */
    public static void report(Book book, Key key, String message) {
        StringBuilder buf = new StringBuilder();
        BookMetaData bmd = book.getBookMetaData();
        if (bmd != null) {
            buf.append(bmd.getInitials());
        }
        if (bmd != null && key != null) {
            buf.append(':');
        }
        if (key != null) {
            buf.append(key.getOsisID());
        }
        buf.append(": ");
        buf.append(message);
        log.info(buf.toString());
    }

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(DataPolice.class);
}
