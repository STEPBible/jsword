package org.crosswire.common.config;

import java.io.File;

/**
 * A class to convert between files and objects of a type.
 */
public class FileChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<File> getConversionClass() {
        return File.class;
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
            return "";
        }

        return ((File) orig).getAbsolutePath();
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
        return new File(orig);
    }
}
