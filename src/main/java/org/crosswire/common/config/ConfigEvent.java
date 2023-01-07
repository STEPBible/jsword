package org.crosswire.common.config;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.EventObject;

/**
 * An event indicating that an exception has happened.
 */
public class ConfigEvent extends EventObject {
    /**
     * Constructs an ConfigEvent object.
     * 
     * @param source
     *            The event originator, or log stream
     */
    public ConfigEvent(Object source, String key, Choice model) {
        super(source);

        this.key = key;
        this.model = model;
    }

    /**
     * Returns the key.
     * 
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * Returns the choice.
     * 
     * @return the choice
     */
    public Choice getChoice() {
        return model;
    }

    /**
     * Returns the choice.
     * 
     * @return the choice
     */
    public Choice getPath() {
        return model;
    }

    /**
     * Serialization support.
     * 
     * @param is
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        // Broken but we don't serialize events
        model = null;
        is.defaultReadObject();
    }

    /**
     * The name of the choice
     */
    private String key;

    /**
     * The Choice
     */
    private transient Choice model;

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 3257006561900376375L;
}
