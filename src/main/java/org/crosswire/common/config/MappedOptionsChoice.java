package org.crosswire.common.config;

import java.util.Iterator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import org.crosswire.jsword.JSOtherMsg;
import org.jdom2.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A class to convert between strings and objects of a type.
 */
public class MappedOptionsChoice extends AbstractReflectedChoice implements MappedChoice<Object, Object> {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#init(org.jdom2.Element)
     */
    @Override
    public void init(Element option, ResourceBundle configResources) throws StartupException {
        assert configResources != null;

        super.init(option, configResources);
        Element mapElement = option.getChild("map");
        if (mapElement == null) {
            throw new StartupException(JSOtherMsg.lookupText("Missing {0} element in config.xml", "map"));
        }

        String name = mapElement.getAttributeValue("name");
        Object map = ChoiceFactory.getDataMap().get(name);
        if (map instanceof Map<?, ?>) {
            options = (Map<?, ?>) map;
        } else {
            options = new TreeMap<Object, Object>();
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.MappedChoice#getOptions()
     */
    public Map<Object, Object> getOptions() {
        return new TreeMap<Object, Object>(options);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.config.Choice#getConvertionClass()
     */
    public Class<String> getConversionClass() {
        return String.class;
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
        return orig != null ? orig.toString() : "";
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
        Iterator<?> iter = options.entrySet().iterator();
        Map.Entry<?, ?> mapEntry = null;
        while (iter.hasNext()) {
            mapEntry = (Map.Entry<?, ?>) iter.next();
            if (mapEntry.getValue().toString().equals(orig) || mapEntry.getKey().toString().equals(orig)) {
                return mapEntry.getKey().toString();
            }
        }
        log.warn(JSOtherMsg.lookupText("Ignoring invalid option: {0}", orig));
        return "";
    }

    private Map<?, ?> options;

    /**
     * The log stream
     */
    private static Logger log = LoggerFactory.getLogger(MappedOptionsChoice.class);
}
