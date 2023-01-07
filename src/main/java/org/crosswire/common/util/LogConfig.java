package org.crosswire.common.util;

import java.io.IOException;
import java.util.logging.LogManager;

/**
 * Loads a java logging configuration file using the JSword methodology.
 */
public class LogConfig {
    public LogConfig() throws SecurityException, IOException {
        LogManager.getLogManager().readConfiguration(ResourceUtil.getResourceAsStream("CWLogging.properties"));
    }
}
