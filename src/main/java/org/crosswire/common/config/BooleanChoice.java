package org.crosswire.common.config;

import org.crosswire.common.util.Convert;

/**
 * A class to convert between strings and objects of a type.
 */
public class BooleanChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<Boolean> getConversionClass() {
        return Boolean.TYPE;
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
        return Convert.boolean2String(((Boolean) orig).booleanValue());
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
        return Boolean.valueOf(Convert.string2Boolean(orig));
    }
}
