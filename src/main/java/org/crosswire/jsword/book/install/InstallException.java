package org.crosswire.jsword.book.install;

import org.crosswire.common.util.LucidException;

/**
 * Something went wrong with a Book.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public class InstallException extends LucidException {
    /**
     * Construct the Exception with a message
     * 
     * @param msg
     *            The resource id to read
     */
    public InstallException(String msg) {
        super(msg);
    }

    /**
     * Construct the Exception with a message and a nested Exception
     * 
     * @param msg
     *            The resource id to read
     * @param ex
     *            The nested Exception
     */
    public InstallException(String msg, Throwable ex) {
        super(msg, ex);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3258132440416335669L;
}
