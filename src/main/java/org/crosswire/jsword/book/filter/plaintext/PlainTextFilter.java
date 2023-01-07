package org.crosswire.jsword.book.filter.plaintext;

import java.util.List;

import org.crosswire.common.util.StringUtil;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.book.filter.Filter;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;
import org.jdom2.Element;

/**
 * Filter to convert plain text to OSIS format. Plain text is nothing more than
 * lines without markup. Unfortunately, it often uses whitespace for markup. We
 * will use OSIS lb to mark lines.
 */
public class PlainTextFilter implements Filter {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.Filter#toOSIS(org.crosswire.jsword.book.Book, org.crosswire.jsword.passage.Key, java.lang.String)
     */
    public List<Content> toOSIS(Book book, Key key, String plain) {
        OSISUtil.OSISFactory factory = OSISUtil.factory();
        Element ele = factory.createDiv();

        String[] lines = StringUtil.splitAll(plain, '\n');
        int lastIndex = lines.length - 1;
        for (int i = 0; i < lastIndex; i++) {
            // TODO(DMS): Preserve whitespace, in a smart manner.
            ele.addContent(lines[i]);
            ele.addContent(factory.createLB());
        }
        // Don't add a line break after the last line.
        if (lastIndex >= 0) {
            ele.addContent(lines[lastIndex]);
        }

        return ele.removeContent();
    }

    @Override
    public PlainTextFilter clone() {
        PlainTextFilter clone = null;
        try {
            clone = (PlainTextFilter) super.clone();
        } catch (CloneNotSupportedException e) {
            assert false : e;
        }
        return clone;
    }
}
