package org.crosswire.common.progress;

import java.util.EventListener;

/**
 * Implement WorkListener and call myClassObj.addProgressListener() to receive
 * WorkEvents when ever we make progress.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public interface WorkListener extends EventListener {
    /**
     * This method is called to indicate that some progress has been made. The
     * amount of progress is indicated by ev.getPercent()
     * 
     * @param ev
     *            Describes the progress
     */
    void workProgressed(WorkEvent ev);

    void workStateChanged(WorkEvent ev);
}
