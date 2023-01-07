package org.crosswire.jsword.book.filter.thml;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.Books;
import org.jdom2.Content;
import org.jdom2.Element;
import org.jdom2.output.XMLOutputter;
import org.junit.Test;

/**
 * JUnit Test
 */
public class ATagTest {

    @Test
    public void testReference() {
        try {
            THMLFilter thmlFilter = new THMLFilter();
            Book dummyBook = Books.installed().getBook("KJV");
            List<Content> out = thmlFilter.toOSIS(dummyBook, dummyBook.getKey("Gen.1.1"), "<a href=\"sword://StrongsRealGreek/01909\">1909</a>");
            assertEquals("THML reference not handled correctly", "<reference osisRef=\"sword://StrongsRealGreek/01909\">1909</reference>", new XMLOutputter().outputString((Element)out.get(0)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
