package org.crosswire.common.xml;

import javax.xml.transform.TransformerException;

/**
 * A generic method of converting one SAX stream into another. This can be a
 * wrapper around an XSL transform or anything else.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
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
