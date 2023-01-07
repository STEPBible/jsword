package org.crosswire.common.xml;

import java.net.URI;

/**
 * An implementation of Converter that uses a TransformingSAXEventProvider to
 * transform one SAXEventProvider into another SAXEventProvider using XSL.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 */
public class TransformingSAXEventProviderConverter implements Converter {
    /**
     * Simple ctor
     * 
     * @param xsluri
     *            The uri of the stylesheet
     */
    public TransformingSAXEventProviderConverter(URI xsluri) {
        this.xsluri = xsluri;
    }

    /*
     * (non-Javadoc)
     * 
     * @seeorg.crosswire.common.xml.Converter#convert(org.crosswire.common.xml.
     * SAXEventProvider)
     */
    public SAXEventProvider convert(SAXEventProvider provider) {
        return new TransformingSAXEventProvider(xsluri, provider);
    }

    /**
     * The URI of the stylesheet
     */
    private URI xsluri;
}
