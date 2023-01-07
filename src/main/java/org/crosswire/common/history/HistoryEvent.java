package org.crosswire.common.history;

import java.util.EventObject;

/**
 * An Event in History.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class HistoryEvent extends EventObject {
    /**
     * Constructs an HistoryEvent object.
     * 
     * @param source
     *            The event originator (typically <code>this</code>)
     */
    public HistoryEvent(Object source) {
        super(source);
    }

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3258132436104852535L;
}
