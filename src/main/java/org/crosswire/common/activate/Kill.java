package org.crosswire.common.activate;

/**
 * Enumeration of how memory is returned.
 */
public enum Kill {
    /** Try as hard as possible to conserve memory */
    EVERYTHING  {
        @Override
        public void reduceMemoryUsage() {
            Activator.deactivateAll();
        }
    },

    /** Reduce memory usage, but only where sensible */
    LEAST_USED,

    /** Reduce memory usage, but only if we really need to */
    ONLY_IF_TIGHT;

    public void reduceMemoryUsage() {
        throw new IllegalArgumentException("Not implemented");
    }
}
