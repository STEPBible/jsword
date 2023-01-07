package org.crosswire.jsword.passage;

/**
 * A Utility class containing various static methods.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public final class PassageUtil {
    /**
     * Prevent instantiation
     */
    private PassageUtil() {
    }

    /**
     * Do we remember the original string used to configure us?
     * 
     * @param persistentNaming
     *            True to keep the old string False (default) to generate a new
     *            better one
     */
    public static void setPersistentNaming(boolean persistentNaming) {
        PassageUtil.persistentNaming = persistentNaming;
    }

    /**
     * Do we remember the original string used to configure us?
     * 
     * @return True if we keep the old string False (default) if we generate a
     *         new better one
     */
    public static boolean isPersistentNaming() {
        return persistentNaming;
    }

    /**
     * By default do we remember the original string used to configure us?
     * 
     * @return false getDefaultPersistentNaming() is always false
     */
    public static boolean getDefaultPersistentNaming() {
        return false;
    }

    /**
     * Do we store the original string?
     */
    private static boolean persistentNaming = getDefaultPersistentNaming();
}
