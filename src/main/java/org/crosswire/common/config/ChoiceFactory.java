package org.crosswire.common.config;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import org.crosswire.common.util.ClassUtil;
import org.crosswire.common.util.PluginUtil;
import org.jdom2.Element;

/**
 * Factory for the well known Choices.
 */
public final class ChoiceFactory {
    /**
     * Prevent instantiation
     */
    private ChoiceFactory() {
    }

    /**
     * Get a ChoiceFactory by element.
     * 
     * @param option
     *            The element to check
     * @return One of the ChoiceTypes.
     */
    public static Choice getChoice(Element option, ResourceBundle configResources) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, StartupException
    {
        Class<Choice> clazz = null;

        String type = option.getAttributeValue("type");
        if ("custom".equals(type)) {
            String clazzstr = option.getAttributeValue("class");
            clazz = (Class<Choice>) ClassUtil.forName(clazzstr);
        } else {
            clazz = map.get(type);
        }

        Choice choice = clazz.newInstance();
        choice.init(option, configResources);
        return choice;
    }

    /**
     * Method getDataMap.
     */
    public static Map<String, Object> getDataMap() {
        return datamap;
    }

    /**
     * Storage of various registered objects
     */
    private static Map<String, Object> datamap = new HashMap<String, Object>();

    /**
     * Store of the known ChoiceTypes
     */
    private static Map<String, Class<Choice>> map;

    /**
     * Setup the map of Choices
     */
    static {
        map = PluginUtil.getImplementorsMap(Choice.class);
    }
}
