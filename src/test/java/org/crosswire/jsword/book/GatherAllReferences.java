package org.crosswire.jsword.book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.crosswire.jsword.passage.Key;
import org.crosswire.jsword.passage.TreeKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Gather all references.
 */
public class GatherAllReferences {
    /**
     * Prevent instantiation
     */
    private GatherAllReferences() {
    }

    /**
     * Read all the books that we can get our hands on.
     */
    public static void main(String[] args) throws IOException {
        out = new PrintWriter(new BufferedWriter(new FileWriter("passages.log")));
        // Loop through all the Books
        log.warn("*** Reading all known Books");
        BookFilter filter = BookFilters.getCustom("GlobalOptionFilter=ThMLScripref;Category=Biblical Texts");
        List<Book> comments = Books.installed().getBooks(filter);
        for (Book book : comments) {

            if (!book.isLocked()) {
                BookMetaData bmd = book.getBookMetaData();
                // Skip PlainText as they do not have references marked up
                if (bmd.getProperty("SourceType") != null) {
                    Key set = book.getGlobalKeyList();

                    readBook(book, set);
                }
            }
        }
        out.flush();
        out.close();
    }

    /**
     * Perform a test read on an iterator over a set of keys
     */
    private static void readBook(Book book, Key set) {
        int[] stats = new int[] {
                0, 0
        };

        boolean first = true;
        for (Key key : set) {
            // skip the root of a TreeKey as it often is not addressable.
            if (first) {
                first = false;
                if (key instanceof TreeKey && key.getName().length() == 0) {
                    continue;
                }
            }
            readKey(book, key, stats);
        }
        log.warn(book.getInitials() + ':' + stats[0] + ':' + stats[1]);

    }

    /**
     * Perform a test read on a single key
     */
    private static void readKey(Book book, Key key, int[] stats) {
        try {
            String orig;
            try {
                orig = book.getRawText(key);
            } catch (BookException ex) {
                log.warn("Failed to read: {}({}):{}", book.getInitials(), key.getOsisID(), ex.getMessage(), ex);
                return;
            }

            Matcher matcher = null;
            if (orig.indexOf("passage=\"") != -1) {
                matcher = thmlPassagePattern.matcher(orig);
            } else if (orig.indexOf("osisRef=\"") != -1) {
                matcher = osisPassagePattern.matcher(orig);
            } else if (orig.indexOf("<RX>") != -1) {
                matcher = gbfPassagePattern.matcher(orig);
            }

            if (matcher != null) {
                while (matcher.find()) {
                    String rawRef = matcher.group(2);
                    stats[0]++;
                    String message = book.getInitials() + ':' + key.getOsisRef() + '/' + rawRef;
/*
                    try {
                        Key ref = book.getKey(rawRef);
                        message += '/' + ref.getOsisRef();
                    } catch (NoSuchKeyException e) {
                        message += '!' + e.getMessage();
                        stats[1]++;
                    }
 */

                    out.println(message);
                }
            }

        } catch (Throwable ex) {
            log.error("Unexpected error reading: {} ({})", book.getInitials(), key.getName(), ex);
        }
    }

    private static Pattern thmlPassagePattern = Pattern.compile("(osisRef|passage)=\"([^\"]*)");
    private static Pattern gbfPassagePattern = Pattern.compile("(<RX>)([^<]*)");
    private static Pattern osisPassagePattern = Pattern.compile("(osisRef)=\"([^\"]*)");
    private static PrintWriter out;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(GatherAllReferences.class);
}
