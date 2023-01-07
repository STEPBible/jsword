package org.crosswire.common.progress;

import java.util.EventObject;

/**
 * A WorkEvent happens whenever a task makes some progress in doing measurable
 * work.
 */
public class WorkEvent extends EventObject {
    /**
     * Initialize a WorkEvent
     */
    public WorkEvent(Progress source) {
        super(source);
    }

    /**
     * Accessor for the Job
     */
    public Progress getJob() {
        return (Progress) getSource();
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3976736990807011378L;
}
