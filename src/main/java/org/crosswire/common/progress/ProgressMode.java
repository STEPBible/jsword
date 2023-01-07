package org.crosswire.common.progress;

/**
 * Progress can be  one of several modes, which correspond to the <code>Progress.beginJob()</code> calls.
 */
public enum ProgressMode {
    /**
     * Progress is working toward 100% and is supplying work from 0 to 100.
     */
    PERCENT,
    /**
     * Progress is working toward a number of units. It might be 100.
     */
    UNITS,
    /**
     * Progress is predicted on the basis of prior runs. The caller has supplied a useful map of the sections for last run.
     */
    PREDICTIVE,
    /**
     * Progress is entirely indeterminate. The user has not supplied a useful map of the sections for last run.
     */
    UNKNOWN
}
