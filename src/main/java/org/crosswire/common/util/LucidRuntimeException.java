package org.crosswire.common.util;


/**
 * EventExceptions are generally used for passing problems through the event
 * system which does not allow checked exceptions through.
 * 
 * <p>
 * So LucidRuntimeException is a LucidException in all but inheritance -
 * LucidException inherits from Exception and so is checked, where EventEception
 * inherits from RuntimeException and so is not checked. In general you would
 * create a subclass of LucidException before you used it, however
 * EventExceptions would be used directly.
 * </p>
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 * @see LucidException
 */
public class LucidRuntimeException extends RuntimeException {

    /**
     * All LucidRuntimeException are constructed with references to resources in
     * an i18n properties file.
     * 
     * @param msg
     *            The resource id to read
     */
    public LucidRuntimeException(String msg) {
        super(msg);
    }

    /**
     * All LucidRuntimeException are constructed with references to resources in
     * an i18n properties file.
     * 
     * @param msg
     *            The resource id to read
     */
    public LucidRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3906091143962965817L;

}
