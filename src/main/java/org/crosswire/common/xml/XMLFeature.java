package org.crosswire.common.xml;


/**
 * Wraps an XML Feature. The "known" set of XML Features is found in
 * XMLFeatureSet.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public enum XMLFeature {
    /** Namespaces feature id */
    NAMESPACES("http://xml.org/sax/features/namespaces"),

    /** Namespace prefixes feature id */
    NAMESPACE_PREFIX("http://xml.org/sax/features/namespace-prefixes"),

    /** Validation feature id */
    VALIDATION("http://xml.org/sax/features/validation"),

    /** Schema validation feature id */
    SCHEMA_VALIDATION("http://apache.org/xml/features/validation/schema"),

    /** Schema full checking feature id */
    SCHEMA_FULL_CHECKING("http://apache.org/xml/features/validation/schema-full-checking"),

    /** Validate schema annotations feature id */
    VALIDATE_ANNOTATIONS("http://apache.org/xml/features/validate-annotations"),

    /** Dynamic validation feature id */
    DYNAMIC_VALIDATION("http://apache.org/xml/features/validation/dynamic"),

    /** Load external DTD feature id */
    LOAD_EXTERNAL_DTD("http://apache.org/xml/features/nonvalidating/load-external-dtd"),

    /** XInclude feature id */
    XINCLUDE("http://apache.org/xml/features/xinclude"),

    /** XInclude fixup base URIs feature id */
    XINCLUDE_FIXUP_BASE_URIS("http://apache.org/xml/features/xinclude/fixup-base-uris", true),

    /** XInclude fixup language feature id */
    XINCLUDE_FIXUP_LANGUAGE("http://apache.org/xml/features/xinclude/fixup-language", true);

    /**
     * Construct a feature for xml, setting the initial state
     * 
     * @param control
     * @param initialState
     */
    private XMLFeature(String control, boolean initialState) {
        this.control = control;
        this.state = initialState;
    }

    /**
     * Construct a feature for xml, setting the initial state set to false.
     * 
     * @param control
     */
    private XMLFeature(String control) {
        this(control, false);
    }

    /**
     * @return the control associated with this feature
     */
    public String getControl() {
        return control;
    }

    /**
     * What state should the feature be set to.
     * 
     * @return the state of the feature
     */
    public boolean getState() {
        return state;
    }

    /**
     * Lookup method to convert from a String
     */
    public static XMLFeature fromString(String name) {
        for (XMLFeature o : XMLFeature.values()) {
            if (o.control.equalsIgnoreCase(name)) {
                return o;
            }
        }
        // cannot get here
        assert false;
        return null;
    }

    @Override
    public String toString() {
        return (state ? "on  " : "off ") + control;
    }

    private String control;
    private boolean state;

}
