package org.crosswire.jsword.book.install.sword;

import java.util.regex.Pattern;

import org.crosswire.jsword.JSOtherMsg;
import org.crosswire.jsword.book.install.Installer;
import org.crosswire.jsword.book.install.InstallerFactory;

/**
 * A Factory for instances of HttpSwordInstaller.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class HttpSwordInstallerFactory implements InstallerFactory {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.install.InstallerFactory#createInstaller()
     */
    public Installer createInstaller() {
        return new HttpSwordInstaller();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.book.install.InstallerFactory#createInstaller(java
     * .lang.String)
     */
    public Installer createInstaller(String installerDefinition) {
        String[] parts = commaPattern.split(installerDefinition, 6);
        switch (parts.length) {
        case 4:
            return createOldInstaller(parts);
        case 6:
            return createInstaller(parts);
        default:
            throw new IllegalArgumentException(JSOtherMsg.lookupText("Not enough / symbols in url: {0}", installerDefinition));
        }

    }

    private Installer createInstaller(String[] parts) {
        AbstractSwordInstaller reply = new HttpSwordInstaller();

        reply.setHost(parts[0]);
        reply.setPackageDirectory(parts[1]);
        reply.setCatalogDirectory(parts[2]);
        if (parts[3].length() > 0) {
            reply.setProxyHost(parts[3]);
            if (parts[4].length() > 0) {
                reply.setProxyPort(Integer.valueOf(parts[4]));
            }
        }

        return reply;
    }

    private Installer createOldInstaller(String[] parts) {
        AbstractSwordInstaller reply = new HttpSwordInstaller();

        reply.setHost(parts[0]);
        reply.setPackageDirectory(parts[1] + '/' + PACKAGE_DIR);
        reply.setCatalogDirectory(parts[1] + '/' + LIST_DIR);
        if (parts[2].length() > 0) {
            reply.setProxyHost(parts[2]);
            if (parts[3].length() > 0) {
                reply.setProxyPort(Integer.valueOf(parts[3]));
            }
        }

        return reply;
    }

    /**
     * The relative path of the dir holding the zip files
     */
    protected static final String PACKAGE_DIR = "packages/rawzip";

    /**
     * The relative path of the dir holding the index file
     */
    private static final String LIST_DIR = "raw";

    private Pattern commaPattern = Pattern.compile(",");
}
