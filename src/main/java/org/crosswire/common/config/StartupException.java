package org.crosswire.common.config;

import org.crosswire.common.util.LucidException;

/**
 * Something in the startup config files failed to start properly.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class StartupException extends LucidException {
    /**
     * @param msg
     */
    public StartupException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param cause
     */
    public StartupException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3616451198199345203L;
}
