package org.crosswire.common.config;

import org.crosswire.common.util.ClassUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to convert between strings and objects of a type.
 */
public class ClassChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<?> getConversionClass() {
        return Class.class;
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
        if (orig == null) {
            return null;
        }

        return ((Class<?>) orig).getName();
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
        try {
            return ClassUtil.forName(orig);
        } catch (ClassNotFoundException ex) {
            log.warn("Class not found: {}", orig, ex);
            return null;
        }
    }

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(ClassChoice.class);
}
