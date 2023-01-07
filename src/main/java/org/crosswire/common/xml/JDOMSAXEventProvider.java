package org.crosswire.common.xml;

import org.jdom2.Document;
import org.jdom2.JDOMException;
import org.jdom2.output.SAXOutputter;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

/**
 * A SAXEventProvider that provides SAX events from a JDOM Document.
 */
public class JDOMSAXEventProvider implements SAXEventProvider {
    /**
     * Simple constructor
     */
    public JDOMSAXEventProvider(Document doc) {
        this.doc = doc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.common.xml.SAXEventProvider#provideSAXEvents(org.xml.sax
     * .ContentHandler)
     */
    public void provideSAXEvents(ContentHandler handler) throws SAXException {
        try {
            SAXOutputter output = new SAXOutputter(handler);
            output.output(doc);
        } catch (JDOMException ex) {
            throw new SAXException(ex);
        }
    }

    /**
     * The document to work from
     */
    private Document doc;
}
