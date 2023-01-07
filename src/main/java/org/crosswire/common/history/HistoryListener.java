package org.crosswire.common.history;

import java.util.EventListener;

/**
 * A listener of HistoryEvents.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 */

public interface HistoryListener extends EventListener {
    void historyChanged(HistoryEvent e);
}
