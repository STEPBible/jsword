package org.crosswire.common.util;

import java.util.EventListener;

/**
 * ReporterListener informs users of problems and messages.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
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
