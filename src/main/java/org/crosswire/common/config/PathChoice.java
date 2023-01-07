package org.crosswire.common.config;

import java.io.File;

import org.crosswire.common.util.Convert;

/**
 * A class to convert between strings and objects of a type.
 */
public class PathChoice extends AbstractReflectedChoice {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<File[]> getConversionClass() {
        return File[].class;
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
        File[] paths = (File[]) orig;
        String[] names = new String[paths.length];
        for (int i = 0; i < paths.length; i++) {
            names[i] = paths[i].getAbsolutePath();
        }

        return Convert.stringArray2String(names, File.pathSeparator);
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
        String[] names = Convert.string2StringArray(orig, File.pathSeparator);
        File[] paths = new File[names.length];
        for (int i = 0; i < names.length; i++) {
            paths[i] = new File(names[i]);
        }

        return paths;
    }
}
