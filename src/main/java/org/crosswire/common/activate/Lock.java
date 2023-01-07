package org.crosswire.common.activate;

/**
 * This class only exists to dissuade you from calling activate() directly on an
 * Activatable object.
 */
public class Lock {
    /**
     * You might be wanting to construct a Lock if you want to call
     * Activatable.activate() directly, in which case you stand a chance of
     * breaking the Activator, so let the activator call activate(), and just
     * ask the Activator to do the job for you.
     */
    Lock() {
        // no instantiation needed
    }
}
