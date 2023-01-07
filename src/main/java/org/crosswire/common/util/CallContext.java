package org.crosswire.common.util;


/**
 * This singleton class provides a way for a method to determine which class
 * called it.
 * <p>
 * It has been tested to work in command line and WebStart environments.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public final class CallContext {
    /**
     * Prevent instantiation
     */
    private CallContext() {
    }

    /**
     * Singleton accessor
     */
    public static CallContext instance() {
        return resolver;
    }

    /**
     * When called from a method it will return the class calling that method.
     */
    public static Class<?> getCallingClass() {
        return getCallingClass(1); // add 1 for this method
    }

    /**
     * When called from a method it will return the i-th class calling that
     * method, up the call chain. If used with a -1 it will return the class
     * making the call -2 and -3 will return this class
     * 
     * @throws ArrayIndexOutOfBoundsException
     *             if the index is not valid
     */
    public static Class<?> getCallingClass(int i) {
        try {
            return Class.forName(Thread.currentThread().getStackTrace()[CALL_CONTEXT_OFFSET + i].getClassName());
        } catch (ClassNotFoundException e) {
            return CallContext.class;
        }
    }

    // may need to change if this class is redesigned
    /**
     * Offset needed to represent the caller of the method that called this
     * method.
     * 
     */
    private static final int CALL_CONTEXT_OFFSET = 3;

    private static CallContext resolver = new CallContext();;
}
