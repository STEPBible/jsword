package org.crosswire.common.config;

import java.util.ResourceBundle;

import org.crosswire.jsword.JSOtherMsg;
import org.jdom2.Element;

/**
 * A class to convert between strings and objects of a type.
 */
public class StringOptionsChoice extends AbstractReflectedChoice implements MultipleChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#init(org.jdom2.Element)
     */
    @Override
    public void init(Element option, ResourceBundle configResources) throws StartupException {
        super.init(option, configResources);
        Element map = option.getChild("map");
        if (map == null) {
            throw new StartupException(JSOtherMsg.lookupText("Missing {0} element in config.xml", "map"));
        }

        String name = map.getAttributeValue("name");
        array = (String[]) ChoiceFactory.getDataMap().get(name);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.MultipleChoice#getOptions()
     */
    public String[] getOptions() {
        String[] copy = new String[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<String> getConversionClass() {
        return String.class;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.common.config.AbstractReflectedChoice#convertToString(java
     * .lang.Object)
     */
    @Override
    public String convertToString(Object orig) {
        return (String) orig;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.common.config.AbstractReflectedChoice#convertToObject(java
     * .lang.String)
     */
    @Override
    public Object convertToObject(String orig) {
        return orig;
    }

    /**
     * The options that we are presenting the user with
     */
    private String[] array;
}
