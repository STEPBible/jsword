package org.crosswire.common.progress;

import java.util.EventListener;

/**
 * Implement WorkListener and call myClassObj.addProgressListener() to receive
 * WorkEvents when ever we make progress.
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
