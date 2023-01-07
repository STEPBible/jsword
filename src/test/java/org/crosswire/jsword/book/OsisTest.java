package org.crosswire.jsword.book;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;

import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

/**
 * JUnit Test.
 */
public class OsisTest {
    @Test
    public void testManual() throws Exception {
        Element seg = OSISUtil.factory().createSeg();
        seg.addContent("In the beginning God created the heaven and the earth.");

        Element verse = OSISUtil.factory().createVerse();
        verse.setAttribute(OSISUtil.OSIS_ATTR_OSISID, "Gen.1.1");
        verse.addContent(seg);

        Element div = OSISUtil.factory().createDiv();
        div.setAttribute("type", "chapter");
        div.setAttribute("osisID", "Gen.1.1");
        div.addContent(verse);

        Element work = OSISUtil.factory().createWork();

        Element header = OSISUtil.factory().createHeader();
        header.addContent(work);

        Element osistext = OSISUtil.factory().createOsisText();
        osistext.setAttribute(OSISUtil.ATTRIBUTE_OSISTEXT_OSISIDWORK, "Bible.KJV");
        osistext.addContent(header);
        osistext.addContent(div);

        Element blank = OSISUtil.factory().createOsis();
        blank.addContent(osistext);

        // create a Marshaller and marshal to System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        outputter.output(blank, out);
        assertTrue(out.toString().trim().length() > 0);
    }

    private XMLOutputter outputter = new XMLOutputter();
}
