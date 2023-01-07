package org.crosswire.common.config;

import java.util.ResourceBundle;

import org.jdom2.Element;

/**
 * Choice is the fundamental building block of the config system.
 * 
 * Every Choice must be able to:
 * <ul>
 * <li>get and set itself using a String</li>
 * <li>provide some simple help about itself</li>
 * <li>elect a user level for itself (Beginner, Intermediate, Advanced)</li>
 * <li>provide a GUI editor for itself</li>
 * </ul>
 */
public interface Choice {
    /**
     * String value to associate with the name (key)
     */
    void init(Element option, ResourceBundle configResources) throws StartupException;

    /**
     * The key of the option.
     * 
     * @return String The key string as supplied in config.xml
     */
    String getKey();

    /**
     * The full path of the option.
     * 
     * @return String The path string as supplied in config.properties
     */
    String getFullPath();

    /**
     * Sets the full path of the option.
     * 
     * @param fullPath
     *            The path string as supplied in config.properties
     */
    void setFullPath(String fullPath);

    /**
     * The type by which UIs can pick an appropriate editor
     * 
     * @return String The type string as supplied in config.xml
     */
    String getType();

    /**
     * The class that this Choice works on. Used to decide how to display the
     * choice to the user.
     * 
     * @return The Class that this Choice works using.
     */
    Class<? extends Object> getConversionClass();

    /**
     * String value to associate with the name (key)
     * 
     * @return value of this Choice
     */
    String getString();

    /**
     * String value to associate with this Field. This method can throw any
     * Exception since almost anything could go wrong at this point. The Config
     * dialog ought to cope with any errors.
     * 
     * @param value
     *            The new value for this Choice
     */
    void setString(String value) throws ConfigException;

    /**
     * Gets a brief description of what is going on
     * 
     * @return Some help text
     */
    String getHelpText();

    /**
     * Sets a brief description of what is going on
     * 
     * @param helptext
     *            Some help text
     */
    void setHelpText(String helptext);

    /**
     * Is this Choice OK to write out to a file, or should we use settings in
     * this run of the program, but forget them for next time. A typical use of
     * this is for password configuration.
     * 
     * @return True if it is safe to store the value in a config file.
     */
    boolean isSaveable();

    /**
     * Whether this should be visible in a Config Editor.
     * 
     * @return hidden or visible
     */
    boolean isHidden();

    /**
     * Whether this should be ignored altogether in a Config Editor.
     * 
     * @return hidden or visible
     */
    boolean isIgnored();

    /**
     * Do we need to restart the program in order for this change to have
     * effect?
     * 
     * @return True if a restart is required
     */
    boolean requiresRestart();
}
