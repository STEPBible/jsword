package org.crosswire.common.util;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

/**
 * Some utils to help work with Collections.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public final class CollectionUtil {
    /**
     * Dont do this
     */
    private CollectionUtil() {
    }

    /**
     * Create a List from an Iterable.
     * 
     * @param it
     *            The source of data for the list
     * @return List
     */
    public static <T> List<T> createList(Iterable<T> it) {
        List<T> reply = new ArrayList<T>();
        for (T obj : it) {
            reply.add(obj);
        }

        return reply;
    }

    /**
     * Create a Set from an Iterable.
     * 
     * @param it
     *            The source of data for the list
     * @return the created set
     */
    public static <T> Set<T> createSet(Iterable<T> it) {
        Set<T> reply = new HashSet<T>();
        for (T obj : it) {
            reply.add(obj);
        }

        return reply;
    }

    /**
     * Convert a <code>Properties</code> into a <code>Map</code>.
     * 
     * @param prop
     *            The Properties to convert
     * @return The map
     */
    public static PropertyMap properties2Map(Properties prop) {
        PropertyMap propMap = new PropertyMap();
        for (Enumeration<Object> e = prop.keys(); e.hasMoreElements(); ) {
            Object k = e.nextElement();
            Object v = prop.get(k);
            if (k instanceof String && v instanceof String) {
                propMap.put((String) k, (String) v);
            }
        }
        return propMap;
    }

    /**
     * Convert a <code>Properties</code> located at <code>propURI</code> into a
     * <code>Map</code>.
     * 
     * @param propUri
     *            The URI of the Properties to convert
     * @return The map
     */
    public static PropertyMap properties2Map(URI propUri) throws IOException {
        return NetUtil.loadProperties(propUri);
    }

}
