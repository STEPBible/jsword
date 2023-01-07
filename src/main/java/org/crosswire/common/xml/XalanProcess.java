package org.crosswire.common.xml;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.crosswire.common.util.ClassUtil;

/**
 * Allows xalan's xslt process class to be invoked as a command line
 * application. Java 5 has renamed the main routine to _main. This class
 * normalizes the difference between Java 1.4 and 1.5 (aka 5).
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public final class XalanProcess {
    /**
     * This is a utility class so the constructor is hidden.
     */
    private XalanProcess() {
    }

    /**
     * Run xalan's xslt process main.
     * 
     * @param args
     */
    public static void main(String[] args) {
        Class<?> clazz = null;
        Method main = null;
        try {
            // Try for 1.5.x
            clazz = ClassUtil.forName("com.sun.org.apache.xalan.internal.xslt.Process");
                    main = clazz.getMethod("_main", new Class[] { String[].class});
        } catch (ClassNotFoundException e) {
            try {
                // Try for 1.4.x
                clazz = ClassUtil.forName("org.apache.xalan.xslt.Process");
                main = clazz.getMethod("main", new Class[] { String[].class});
            } catch (ClassNotFoundException e1) {
                e1.printStackTrace(System.err);
            } catch (SecurityException e1) {
                e1.printStackTrace(System.err);
            } catch (NoSuchMethodException e1) {
                e1.printStackTrace(System.err);
            }
        } catch (SecurityException e1) {
            e1.printStackTrace(System.err);
        } catch (NoSuchMethodException e) {
            e.printStackTrace(System.err);
            return;
        }

        try {
            if (main != null) {
                main.invoke(null, (Object[]) args);
            }
        } catch (IllegalArgumentException e) {
            e.printStackTrace(System.err);
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
        } catch (InvocationTargetException e) {
            e.printStackTrace(System.err);
        }
    }
}
