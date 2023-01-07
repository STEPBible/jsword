package org.crosswire.jsword.book.filter.thml;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Element;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the note element.
 */
public class NoteTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "note";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        Element note = OSISUtil.factory().createNote();
        note.setAttribute(OSISUtil.OSIS_ATTR_TYPE, OSISUtil.NOTETYPE_STUDY);

        if (ele != null) {
            ele.addContent(note);
        }

        return note;
    }
}
