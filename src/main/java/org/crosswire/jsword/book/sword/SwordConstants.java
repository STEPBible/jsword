package org.crosswire.jsword.book.sword;

/**
 * A Constants to help the SwordBookDriver to read Sword format data.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Mark Goodwin [mark at thorubio dot org]
 * @author Joe Walker [joe at eireneh dot com]
 * @author The Sword project (don't know who - no credits in original files
 *         (canon.h))
 */
public final class SwordConstants {
    /**
     * Prevent instantiation
     */
    private SwordConstants() {
    }

    /**
     * New testament data files
     */
    public static final String FILE_NT = "nt";

    /**
     * Old testament data files
     */
    public static final String FILE_OT = "ot";

    /**
     * Index file extensions
     */
    public static final String EXTENSION_VSS = ".vss";

    /**
     * Extension for index files
     */
    public static final String EXTENSION_INDEX = ".idx";

    /**
     * Extension for data files
     */
    public static final String EXTENSION_DATA = ".dat";

    /**
     * Extension for config files
     */
    public static final String EXTENSION_CONF = ".conf";

    /**
     * The data directory
     */
    public static final String DIR_DATA = "modules";

    /**
     * The configuration directory
     */
    public static final String DIR_CONF = "mods.d";

    /**
     * The configuration directory
     */
    public static final String DIR_CONF_OVERRIDE = "jsword-mods.d";

}
