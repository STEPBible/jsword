package org.crosswire.common.xml;

import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * A simple way of giving someone a place from which to get SAX events.
 */
public interface SAXEventProvider {
    /**
     * When SAX events are required the user of this interface can call this
     * method.
     * 
     * @param handler
     *            The place to send SAX events.
     */
    void provideSAXEvents(ContentHandler handler) throws SAXException;
}
