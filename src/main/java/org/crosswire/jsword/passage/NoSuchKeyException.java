package org.crosswire.jsword.passage;

import org.crosswire.common.util.LucidException;

/**
 * When something tries to use a key that we don't understand.
 */
public class NoSuchKeyException extends LucidException {
    /**
     * Construct the Exception with a message
     * 
     * @param msg
     *            The resource id to read
     */
    public NoSuchKeyException(String msg) {
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
    public NoSuchKeyException(String msg, Throwable ex) {
        super(msg, ex);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3257288032582185777L;
}
