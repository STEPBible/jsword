package org.crosswire.jsword.examples;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookData;
import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.BookFilters;
import org.crosswire.jsword.book.Books;
import org.crosswire.jsword.book.FeatureType;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.book.study.StrongsMapSet;
import org.crosswire.jsword.book.study.StrongsNumber;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;
import org.jdom2.Element;

/**
 * Analyze Strong's Numbers in a module.
 */
public class StrongsAnalysis {
    /**
     *
     */
    public StrongsAnalysis() {
        Book bible = Books.installed().getBook("KJV");
        if (!bible.hasFeature(FeatureType.STRONGS_NUMBERS)) {
            bible = null;
            List<Book> bibles = Books.installed().getBooks(new BookFilters.BookFeatureFilter(FeatureType.STRONGS_NUMBERS));

            if (!bibles.isEmpty()) {
                bible = bibles.get(0);
            }
        }

        if (bible == null) {
            return;
        }

        List<Key> errors = new ArrayList<Key>();
        StrongsMapSet sms = new StrongsMapSet();
        analyze(sms, bible, errors, bible.getGlobalKeyList());
    }

    /**
     * @param sms
     * @param book
     * @param errors
     * @param wholeBible
     */
    public void analyze(StrongsMapSet sms, Book book, List<Key> errors, Key wholeBible) {
        BookData data = null;
        Element osis = null;
        StringBuilder buffer = new StringBuilder();
        for (Key subkey : wholeBible) {
            if (subkey.canHaveChildren()) {
                analyze(sms, book, errors, subkey);
            } else {
                data = new BookData(book, subkey);
                osis = null;

                try {
                    osis = data.getOsisFragment();
                } catch (BookException e) {
                    errors.add(subkey);
                    continue;
                }

                // Do the actual indexing
                for (Content content : OSISUtil.getDeepContent(osis, OSISUtil.OSIS_ELEMENT_W)) {
                    // Clear out the buffer for re-use
                    int len = buffer.length();
                    if (len > 0) {
                        buffer.delete(0, len);
                    }

                    Element wElement = (Element) content;
                    String snAttr = wElement.getAttributeValue(OSISUtil.ATTRIBUTE_W_LEMMA);

                    String text = OSISUtil.getPlainText(wElement);

                    Matcher matcher = strongsNumberPattern.matcher(snAttr);
                    while (matcher.find()) {
                        StrongsNumber strongsNumber = new StrongsNumber(matcher.group(1));
                        if (strongsNumber.isValid()) {
                            if (buffer.length() > 0) {
                                buffer.append(' ');
                            }
                            buffer.append(strongsNumber.getStrongsNumber());
                        }
                    }

                    // now we can actually store the mapping
                    sms.add(buffer.toString(), text);
                }
            }
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new StrongsAnalysis();
    }

    private static Pattern strongsNumberPattern = Pattern.compile("strong:([GH][0-9]+)");
}
