package org.crosswire.common.config;

import org.crosswire.common.util.LucidException;

/**
 * Something went wrong while setting config options.
 */
public class ConfigException extends LucidException {
    /**
     * @param msg
     */
    public ConfigException(String msg) {
        super(msg);
    }

    /**
     * @param msg
     * @param cause
     */
    public ConfigException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3258135764670689593L;
}
