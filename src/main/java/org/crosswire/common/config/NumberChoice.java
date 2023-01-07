package org.crosswire.common.config;

import org.crosswire.common.util.Convert;

/**
 * A class to convert between strings and objects of a type.
 */
public class NumberChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<Integer> getConversionClass() {
        return Integer.TYPE;
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
        return Convert.int2String(((Integer) orig).intValue());
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
        return Integer.valueOf(Convert.string2Int(orig));
    }
}
