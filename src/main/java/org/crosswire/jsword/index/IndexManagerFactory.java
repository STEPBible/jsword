package org.crosswire.jsword.index;

import java.io.IOException;

import org.crosswire.common.util.PluginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Factory class for IndexManagers.
 */
public final class IndexManagerFactory {
    /**
     * Prevent instantiation
     */
    private IndexManagerFactory() {
    }

    /**
     * Create a new IndexManager.
     */
    public static IndexManager getIndexManager() {
        return instance;
    }

    /**
     * The singleton
     */
    private static IndexManager instance;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(IndexManagerFactory.class);

    /**
     * Setup the instance
     */
    static {
        try {
            instance = PluginUtil.getImplementation(IndexManager.class);
        } catch (IOException e) {
            log.error("createIndexManager failed", e);
        } catch (ClassCastException e) {
            log.error("createIndexManager failed", e);
        } catch (ClassNotFoundException e) {
            log.error("createIndexManager failed", e);
        } catch (IllegalAccessException e) {
            log.error("createIndexManager failed", e);
        } catch (InstantiationException e) {
            log.error("createIndexManager failed", e);
        }
    }
}
