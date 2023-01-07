package org.crosswire.common.xml;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/**
 * A SAXEventProvider that provides SAX events from a String.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class StringSAXEventProvider implements SAXEventProvider {
    /**
     * Simple ctor
     */
    public StringSAXEventProvider(String xmlstr) throws ParserConfigurationException, SAXException {
        this.xmlstr = xmlstr;

        SAXParserFactory fact = SAXParserFactory.newInstance();
        SAXParser parser = fact.newSAXParser();

        reader = parser.getXMLReader();
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
            StringReader sr = new StringReader(xmlstr);
            InputSource is = new InputSource(sr);

            reader.setContentHandler(handler);
            reader.parse(is);
        } catch (IOException ex) {
            throw new SAXException(ex);
        }
    }

    /**
     * The SAX parser
     */
    private XMLReader reader;

    /**
     * The source of XML data
     */
    private String xmlstr;
}
