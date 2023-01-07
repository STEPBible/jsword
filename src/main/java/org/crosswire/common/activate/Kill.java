package org.crosswire.common.activate;

/**
 * Enumeration of how memory is returned.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
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
