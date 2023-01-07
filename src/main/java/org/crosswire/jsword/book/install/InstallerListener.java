package org.crosswire.jsword.book.install;

import java.util.EventListener;

/**
 * InstallerListener are able to be notified about changes to the numbers of
 * Installers known to the system.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public interface InstallerListener extends EventListener {
    /**
     * Called whenever a new Installer is added to the system.
     * 
     * @param ev
     *            A description of the change
     */
    void installerAdded(InstallerEvent ev);

    /**
     * Called whenever an Installer is removed from the system.
     * 
     * @param ev
     *            A description of the change
     */
    void installerRemoved(InstallerEvent ev);
}
