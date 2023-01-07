package org.crosswire.jsword.book.install;

/**
 * An abstract factory to allow generic creation of Installers.
 */
public interface InstallerFactory {
    /**
     * Create a new Installer with default values for editing via bean
     * properties.
     * 
     * @return A new Installer implemented to fit with this Factory
     */
    Installer createInstaller();

    /**
     * Create a new Installer with values from the given url to use for initial
     * values.
     * 
     * @param url
     *            The configuration string
     * @return A new Installer implemented to fit with this Factory
     */
    Installer createInstaller(String url);
}
