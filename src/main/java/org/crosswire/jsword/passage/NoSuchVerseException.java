package org.crosswire.jsword.passage;


/**
 * When something tries to use a verse that we don't understand.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class NoSuchVerseException extends NoSuchKeyException {
    /**
     * Construct the Exception with a message
     * 
     * @param msg
     *            The resource id to read
     */
    public NoSuchVerseException(String msg) {
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
    public NoSuchVerseException(String msg, Throwable ex) {
        super(msg, ex);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3257572797638129463L;
}
