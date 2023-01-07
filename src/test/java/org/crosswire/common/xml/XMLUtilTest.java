package org.crosswire.common.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class XMLUtilTest {
    @Test
    public void testCleanAllEntities() {
        assertNull(XMLUtil.cleanAllEntities(null));

        assertEquals("", XMLUtil.cleanAllEntities(""));
        assertEquals("aa", XMLUtil.cleanAllEntities("aa"));
        assertEquals("<aa>", XMLUtil.cleanAllEntities("<aa>"));
        assertEquals("<aa>aa", XMLUtil.cleanAllEntities("<aa>aa"));
        assertEquals("<aa>aa;aa", XMLUtil.cleanAllEntities("<aa>aa;aa"));
        assertEquals(";", XMLUtil.cleanAllEntities(";"));

        assertEquals("aa &amp; aa", XMLUtil.cleanAllEntities("aa &amp; aa"));
        assertEquals("aa &amp;amp aa", XMLUtil.cleanAllEntities("aa &amp aa"));
        assertEquals("aa &amp;a-mp aa", XMLUtil.cleanAllEntities("aa &a-mp aa"));
        assertEquals("aa   aa", XMLUtil.cleanAllEntities("aa &am; aa"));
        assertEquals("aa &amp;am aa", XMLUtil.cleanAllEntities("aa &am aa"));
        assertEquals("aa &amp;", XMLUtil.cleanAllEntities("aa &amp;"));
        assertEquals("aa &amp;amp", XMLUtil.cleanAllEntities("aa &amp"));
        assertEquals("aa  ", XMLUtil.cleanAllEntities("aa &am;"));
        assertEquals("aa &amp;am", XMLUtil.cleanAllEntities("aa &am"));
        assertEquals("aa &amp;a", XMLUtil.cleanAllEntities("aa &a"));
        assertEquals("aa &amp;", XMLUtil.cleanAllEntities("aa &"));

        assertEquals("aa \u00A0 aa", XMLUtil.cleanAllEntities("aa &nbsp; aa"));
        assertEquals("aa &amp;nbsp aa", XMLUtil.cleanAllEntities("aa &nbsp aa"));
        assertEquals("aa &amp;nb-sp aa", XMLUtil.cleanAllEntities("aa &nb-sp aa"));
        assertEquals("aa   aa", XMLUtil.cleanAllEntities("aa &nb; aa"));
        assertEquals("aa &amp;nb aa", XMLUtil.cleanAllEntities("aa &nb aa"));

        assertEquals("-&amp;-\u00A0-&lt;-&gt;-&quot;-\u00A3-\u20AC-", XMLUtil.cleanAllEntities("-&amp;-&nbsp;-&lt;-&gt;-&quot;-&pound;-&euro;-"));
    }

    @Test
    public void testCleanAllTags() {
        assertNull(XMLUtil.cleanAllTags(null));

        assertEquals("", XMLUtil.cleanAllTags(""));
        assertEquals("aa", XMLUtil.cleanAllTags("aa"));
        assertEquals("aa &amp; aa", XMLUtil.cleanAllTags("aa &amp; aa"));

        assertEquals(" ", XMLUtil.cleanAllTags("<a>"));
        assertEquals(" ", XMLUtil.cleanAllTags("<aa>"));
        assertEquals(" ", XMLUtil.cleanAllTags("</aa>"));
        assertEquals(" ", XMLUtil.cleanAllTags("<aa wibble=\"wobble\">"));
        assertEquals(" keep ", XMLUtil.cleanAllTags("<aa>keep</aa>"));
        assertEquals(" keep ", XMLUtil.cleanAllTags("<aa>keep<aa>"));
        assertEquals(" ke ep", XMLUtil.cleanAllTags("<aa>ke<aa>ep"));
        assertEquals("ke  ep", XMLUtil.cleanAllTags("ke<aa><aa>ep"));
        assertEquals("ke  ep   ke  ep", XMLUtil.cleanAllTags("ke<aa><aa>ep<bb> <cc>ke<aa><aa>ep"));

        assertEquals(" ", XMLUtil.cleanAllTags("<"));
        assertEquals(" ", XMLUtil.cleanAllTags("<a"));
        assertEquals(" ", XMLUtil.cleanAllTags("<aa"));
        assertEquals(" ", XMLUtil.cleanAllTags("<aa;"));
        assertEquals(" ", XMLUtil.cleanAllTags("<\\"));
        assertEquals(" ", XMLUtil.cleanAllTags("<\\a"));
        assertEquals(" ", XMLUtil.cleanAllTags("<\\aa"));
        assertEquals(" ", XMLUtil.cleanAllTags("<\\aa;"));
        assertEquals(" ", XMLUtil.cleanAllTags("< "));
        assertEquals(" ", XMLUtil.cleanAllTags("< a"));
        assertEquals(" ", XMLUtil.cleanAllTags("< aa"));
        assertEquals(" ", XMLUtil.cleanAllTags("< aa;"));
        assertEquals(" ", XMLUtil.cleanAllTags("< aa>"));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<"));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<a"));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<aa"));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<aa dont=\"want\""));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<aa dont=\"want\" keep"));
        assertEquals("keep ", XMLUtil.cleanAllTags("keep<aa dont=\"want\" keep>"));
    }
}
