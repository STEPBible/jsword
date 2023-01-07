package org.crosswire.common.config;

import java.util.EventListener;

/**
 * ConfigListener.
 */
public interface ConfigListener extends EventListener {
    /**
     * Called whenever Config.add() is called
     */
    void choiceAdded(ConfigEvent ev);

    /**
     * Called whenever Config.remove() is called
     */
    void choiceRemoved(ConfigEvent ev);
}
