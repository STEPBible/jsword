package org.crosswire.common.util;

import java.util.EventListener;

/**
 * ReporterListener informs users of problems and messages.
 */
public interface ReporterListener extends EventListener {
    /**
     * Called whenever Reporter.informUser() is passed an Exception
     * 
     * @param ev
     *            The event describing the Exception
     */
    void reportException(ReporterEvent ev);

    /**
     * Called whenever Reporter.informUser() is passed a message
     * 
     * @param ev
     *            The event describing the message
     */
    void reportMessage(ReporterEvent ev);
}
