package org.crosswire.common.config;

import java.util.ResourceBundle;

import org.crosswire.common.util.Convert;
import org.jdom2.Element;

/**
 * A class to convert between strings and objects of a type.
 */
public class StringArrayChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#init(org.jdom2.Element)
     */
    @Override
    public void init(Element option, ResourceBundle configResources) throws StartupException {
        super.init(option, configResources);
        separator = option.getAttributeValue("separator");
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<String[]> getConversionClass() {
        return String[].class;
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
        return Convert.stringArray2String((String[]) orig, separator);
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
        return Convert.string2StringArray(orig, separator);
    }

    private String separator = " ";
}
