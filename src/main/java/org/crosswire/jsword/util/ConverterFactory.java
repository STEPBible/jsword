package org.crosswire.jsword.util;

import java.util.Map;

import org.crosswire.common.util.PluginUtil;
import org.crosswire.common.xml.Converter;
import org.crosswire.jsword.JSOtherMsg;

/**
 * A factory for Converters.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 * @see org.crosswire.common.xml.Converter
 */
public final class ConverterFactory {
    /**
     * Prevent instantiation
     */
    private ConverterFactory() {
    }

    /**
     * Generate a converter for the current converter name
     */
    public static Converter getConverter() {
        try {
            Class<Converter> clazz = PluginUtil.getImplementorsMap(Converter.class).get(name);
            assert clazz != null : JSOtherMsg.lookupText("No converter called: {0}", name);
            return clazz.newInstance();
        } catch (InstantiationException e) {
            assert false : e;
        } catch (IllegalAccessException e) {
            assert false : e;
        }
        return null;
    }

    /**
     * Get a map of the known converters, by looking up the answers in Project
     */
    public static Map<String, Class<Converter>> getKnownConverters() {
        return PluginUtil.getImplementorsMap(Converter.class);
    }

    /**
     * For config to set the currently preferred converter implementation
     */
    public static void setCurrentConverterName(String name) {
        ConverterFactory.name = name;
    }

    /**
     * For config to read the currently preferred converter implementation
     */
    public static String getCurrentConverterName() {
        return name;
    }

    /**
     * Current default converter implementation
     */
    private static String name = "Configurable";
}
