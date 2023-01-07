package org.crosswire.common.xml;

import javax.xml.transform.TransformerException;

/**
 * A generic method of converting one SAX stream into another. This can be a
 * wrapper around an XSL transform or anything else.
 */
public interface Converter {
    /**
     * Convert one SAX stream into another.
     * 
     * @param provider
     *            The source stream
     * @return The destination stream
     * @throws TransformerException
     *             If the transformation can't be completed
     */
    SAXEventProvider convert(SAXEventProvider provider) throws TransformerException;
}
