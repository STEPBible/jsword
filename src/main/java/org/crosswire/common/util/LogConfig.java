package org.crosswire.common.util;

import java.io.IOException;
import java.util.logging.LogManager;

/**
 * Loads a java logging configuration file using the JSword methodology.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class LogConfig {
    public LogConfig() throws SecurityException, IOException {
        LogManager.getLogManager().readConfiguration(ResourceUtil.getResourceAsStream("CWLogging.properties"));
    }
}
