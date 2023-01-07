package org.crosswire.common.config;

import org.crosswire.common.util.LucidException;

/**
 * Something in the startup config files failed to start properly.
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
