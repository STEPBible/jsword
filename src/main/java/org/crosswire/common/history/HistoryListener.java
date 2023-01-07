package org.crosswire.common.history;

import java.util.EventListener;

/**
 * A listener of HistoryEvents.
 */

public interface HistoryListener extends EventListener {
    void historyChanged(HistoryEvent e);
}
