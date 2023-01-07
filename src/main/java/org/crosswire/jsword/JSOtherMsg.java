package org.crosswire.jsword;

import org.crosswire.common.util.MsgBase;

/**
 * Compile safe Msg resource settings.
 */
public final class JSOtherMsg extends MsgBase {
    /**
     * Get the internationalized text, but return key if key is unknown.
     * The text requires one or more parameters to be passed.
     * 
     * @param key
     * @param params
     * @return the formatted, internationalized text
     */
    public static String lookupText(String key, Object... params) {
        return msg.lookup(key, params);
    }

    private static MsgBase msg = new JSOtherMsg();
}
