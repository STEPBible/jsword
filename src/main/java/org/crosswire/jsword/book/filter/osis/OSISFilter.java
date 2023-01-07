package org.crosswire.jsword.book.filter.osis;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.regex.Pattern;

import org.crosswire.common.xml.XMLUtil;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.DataPolice;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.book.filter.Filter;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

/**
 * Filter to convert an OSIS XML string to OSIS format.
 */
public class OSISFilter implements Filter {

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.Filter#toOSIS(org.crosswire.jsword.book.Book, org.crosswire.jsword.passage.Key, java.lang.String)
     */
    public List<Content> toOSIS(Book book, Key key, String plain) {
        Element ele = null;
        Exception ex = null;
        String clean = plain;

        // The following converts simple <div> and </div> to their milestoned versions.
        // Current versions of osis2mod do this already
        // Note: if the div element has attributes, it is not seen.
        clean = DIV_START.matcher(clean).replaceAll("<div sID=\"xyz\"/>");
        clean = DIV_END.matcher(clean).replaceAll("<div eID=\"xyz\"/>");
        clean = CHAPTER_END.matcher(clean).replaceAll("<chapter eID=\"xyz\"/>");
        clean = SPEECH_START.matcher(clean).replaceAll("<speech sID=\"xyz\"/>");
        clean = SPEECH_END.matcher(clean).replaceAll("<speech eID=\"xyz\"/>");

        // FIXME(dms): this is a major HACK handling a problem with a badly
        // encoded module.
        /* if (book.getInitials().startsWith("NET") && plain.endsWith("</div>")) {
            clean = clean.substring(0, plain.length() - 6);
            if (clean.matches(".*</div> <chapter eID=\"[A-Za-z0-9.]+\"/>")) {
                clean = clean.substring(0, clean.lastIndexOf("</div> <chapter"));
            }
        } else if (book.getInitials().equals("Kekchi") && plain.endsWith("</div> <lb type=\"x-begin-paragraph\"/>")) {
            clean = clean.substring(0, clean.length() - 37);
        } else if (book.getInitials().equals("VietLCCMN")) {
            int startPos = clean.indexOf("<div>"), endPos = clean.indexOf("</div>");
            if (endPos != -1 && (startPos == -1 || startPos > endPos)) {
                if (clean.startsWith("<l ") || (clean.startsWith("<title ") && clean.contains("</title><l ")))
                    clean = "<lg>"+clean;
                clean = "<div><div><div><div>"+clean;
            }
        } else */
        if (book.getInitials().equals("MapM")) {
            for(String tag : Arrays.asList("cell", "row", "table")) {
                int startPos = clean.indexOf("<"+tag+">"), endPos = clean.indexOf("</"+tag+">");
                if (endPos != -1 && (startPos == -1 || startPos > endPos)) {
                    clean = "<"+tag+">"+clean;
                }
            }
        }

        try {
            ele = parse(clean);
        } catch (JDOMException e) {
            ex = e;
        } catch (IOException e) {
            ex = e;
        }

        if (ele == null) {
            // There should be no bad entities in OSIS.
            String cleanedEntities = XMLUtil.cleanAllEntities(clean);
            if (cleanedEntities != null && !cleanedEntities.equals(clean)) {
                clean = cleanedEntities;
                try {
                    ele = parse(clean);
                    ex = null;
                } catch (JDOMException e) {
                    ex = e;
                } catch (IOException e) {
                    ex = e;
                }
            }
        }

        if (ele == null) {
            String reclosed = XMLUtil.recloseTags(clean);
            if (reclosed != null && !reclosed.equals(clean)) {
                clean = reclosed;
                try {
                    ele = parse(clean);
                    ex = null;
                } catch (JDOMException e) {
                    ex = e;
                } catch (IOException e) {
                    ex = e;
                }
            }
        }

        if (ex != null) {
            DataPolice.report(book, key, "Parse failed: " + ex.getMessage() + "\non: " + clean);
            ele = cleanTags(book, key, clean);
        }

        if (ele == null) {
            ele = OSISUtil.factory().createP();
        }

        return ele.removeContent();
    }

    @Override
    public OSISFilter clone() {
        OSISFilter clone = null;
        try {
            clone = (OSISFilter) super.clone();
        } catch (CloneNotSupportedException e) {
            assert false : e;
        }
        return clone;
    }

    private Element cleanTags(Book book, Key key, String plain) {
        // So just try to strip out all XML looking things
        String shawn = XMLUtil.cleanAllTags(plain);
        Exception ex = null;
        try {
            return parse(shawn);
        } catch (JDOMException e) {
            ex = e;
        } catch (IOException e) {
            ex = e;
        }

        DataPolice.report(book, key, "Parse failed: " + ex.getMessage() + "\non: " + shawn);

        return null;
    }

    /**
     * If the string is invalid then we might want to have more than one crack
     * at parsing it
     */
    private Element parse(String plain) throws JDOMException, IOException {
        SAXBuilder builder = saxBuilders.poll();
        if (builder == null) {
            //then we have no sax builders available, so let's create a new one and store
            builder = new SAXBuilder();
            // With JDom 1.x it was important to set Fast Reconfigure on re-usable SAXBuilders
            // This is the default with 2.x and this method does nothing
            // builder.setFastReconfigure(true);
        }

        // create a root element to house our document fragment
        StringReader in = null;
        Element div;
        try {
            // Need to contain it in something that we remove when returning it to the user.
            in = new StringReader("<xxx>" + plain + "</xxx>");
            InputSource is = new InputSource(in);
            Document doc = builder.build(is);
            div = doc.getRootElement();
        } finally {
            if (in != null) {
                in.close();
            }
        }

        //return builder to queue, or offer a new one. Ignore return value as we don't care whether the builder is going to be re-used
        saxBuilders.offer(builder);

        return div;
    }

    // space for 32 re-usable sax builders, but doesn't bound the number available to the callers
    private BlockingQueue<SAXBuilder> saxBuilders = new ArrayBlockingQueue<SAXBuilder>(32);

    /**
     * Pattern to find the start of a div. Used to convert to a milestoned version.
     */
    private static final Pattern DIV_START = Pattern.compile("<div>", Pattern.LITERAL);
    /**
     * Pattern to find the end of a div. Used to convert to a milestoned version.
     */
    private static final Pattern DIV_END = Pattern.compile("</div>", Pattern.LITERAL);
    /**
     * Pattern to find the end of a chapter. Used to convert to a milestoned version.
     */
    private static final Pattern CHAPTER_END = Pattern.compile("</chapter>", Pattern.LITERAL);
    /**
     * Pattern to find the start of a speech. Used to convert to a milestoned version.
     */
    private static final Pattern SPEECH_START = Pattern.compile("<speech>", Pattern.LITERAL);
    /**
     * Pattern to find the end of a speech. Used to convert to a milestoned version.
     */
    private static final Pattern SPEECH_END = Pattern.compile("</speech>", Pattern.LITERAL);
    /**
     * The log stream
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(OSISFilter.class);
}
