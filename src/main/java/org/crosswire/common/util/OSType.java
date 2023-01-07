package org.crosswire.common.util;

import java.io.File;
import java.net.URI;

/**
 * Types of Operating Systems for which specialized behavior is needed.
 */
public enum OSType {
    MAC("Mac") {
        @Override
        public URI getUserArea() {
            return NetUtil.lengthenURI(getUserHome(), MAC_USER_DATA_AREA);
        }

        @Override
        public URI getUserAreaFolder(String hiddenFolderName, String visibleFolderName) {
            return NetUtil.lengthenURI(getUserArea(), visibleFolderName);
        }
    },

    WIN32("Win") {
        @Override
        public URI getUserArea() {
            if ("Windows 10".equalsIgnoreCase(System.getProperty("os.name"))) {
                return NetUtil.lengthenURI(getUserHome(), WIN32_V10_USER_DATA_AREA);
            }
            return NetUtil.lengthenURI(getUserHome(), WIN32_USER_DATA_AREA);
        }

        @Override
        public URI getUserAreaFolder(String hiddenFolderName, String visibleFolderName) {
            return NetUtil.lengthenURI(getUserArea(), visibleFolderName);
        }
    },

    DEFAULT("*nix") {
        @Override
        public URI getUserArea() {
            return getUserHome();
        }

        @Override
        public URI getUserAreaFolder(String hiddenFolderName, String visibleFolderName) {
            return NetUtil.lengthenURI(getUserArea(), hiddenFolderName);
        }
    };

    /**
     * Simple ctor
     */
    private OSType(String name) {
        this.name = name;
    }

    /**
     * Get the user area for this OSType.
     *
     * @return the user area
     */
    public abstract URI getUserArea();

    /**
     * A folder in the user area. This osType will determine which to use in
     * constructing the URI to the folder.
     *
     * @param hiddenFolderName
     *            is typically a "unix" hidden folder name such as .jsword.
     * @param visibleFolderName
     *            is an visible folder name, such as JSword.
     *
     * @return the user area folder
     */
    public abstract URI getUserAreaFolder(String hiddenFolderName, String visibleFolderName);

    public static URI getUserHome() {
        return NetUtil.getURI(new File(System.getProperty("user.home")));
    }

    /**
     * Get the machine's OSType.
     *
     * @return the machine's OSType
     */
    public static OSType getOSType() {
        return osType;
    }

    /**
     * Lookup method to convert from a String
     */
    public static OSType fromString(String name) {
        for (OSType v : values()) {
            if (name.startsWith(v.name)) {
                return v;
            }
        }

        return DEFAULT;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The name of the type
     */
    private String name;

    /**
     * The Windows user settings parent directory
     */
    private static final String WIN32_USER_DATA_AREA = "Application Data";
    private static final String WIN32_V10_USER_DATA_AREA = "AppData/Roaming";

    /**
     * The Mac user settings parent directory
     */
    private static final String MAC_USER_DATA_AREA = "Library/Application Support";

    /**
     * The machine's osType
     */
    private static OSType osType = fromString(System.getProperty("os.name"));
}
