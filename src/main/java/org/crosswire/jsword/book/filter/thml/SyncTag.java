package org.crosswire.jsword.book.filter.thml;

import java.util.List;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.DataPolice;
import org.crosswire.jsword.book.OSISUtil;
import org.crosswire.jsword.passage.Key;
import org.jdom2.Content;
import org.jdom2.Element;
import org.jdom2.Text;
import org.xml.sax.Attributes;

/**
 * THML Tag to process the sync element. A sync tag is always empty and
 * immediately follows what it marks. With types of Strong's and morph these are
 * to become w elements that surround the word that they modify. This requires
 * that we find the last text element and surround it with a w element. If the
 * last text element is already surrounded with a w element then this is added
 * to it. As a simplifying assumption, we will assume that the text element is
 * not contained by anything except perhaps by a w element.
 */
public class SyncTag extends AbstractTag {
    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.filter.thml.Tag#getTagName()
     */
    public String getTagName() {
        return "sync";
    }

    @Override
    public Element processTag(Book book, Key key, Element ele, Attributes attrs) {
        // Strong's reference
        String type = attrs.getValue("type");
        String value = attrs.getValue("value");

        if ("Strongs".equals(type)) {
            List<Content> siblings = ele.getContent();
            int size = siblings.size();
            if (size == 0) {
                return null;
            }
            Content lastEle = siblings.get(size - 1);
            if (lastEle instanceof Text) {
                Element w = OSISUtil.factory().createW();
                w.setAttribute(OSISUtil.ATTRIBUTE_W_LEMMA, OSISUtil.LEMMA_STRONGS + value);
                siblings.set(size - 1, w);
                w.addContent(lastEle);
            } else if (lastEle instanceof Element) {
                Element wEle = (Element) lastEle;
                if (wEle.getName().equals(OSISUtil.OSIS_ELEMENT_W)) {
                    StringBuilder buf = new StringBuilder();
                    String strongsAttr = wEle.getAttributeValue(OSISUtil.ATTRIBUTE_W_LEMMA);
                    if (strongsAttr != null) {
                        buf.append(strongsAttr);
                        buf.append(' ');
                    }
                    buf.append(OSISUtil.LEMMA_STRONGS);
                    buf.append(value);
                    wEle.setAttribute(OSISUtil.ATTRIBUTE_W_LEMMA, buf.toString());
                }
            }
            return null;
        }

        if ("morph".equals(type)) {
            List<Content> siblings = ele.getContent();
            int size = siblings.size();
            if (size == 0) {
                return null;
            }
            Content lastEle = siblings.get(size - 1);
            if (lastEle instanceof Text) {
                Element w = OSISUtil.factory().createW();
                w.setAttribute(OSISUtil.ATTRIBUTE_W_MORPH, OSISUtil.MORPH_ROBINSONS + value);
                siblings.set(size - 1, w);
                w.addContent(lastEle);
            } else if (lastEle instanceof Element) {
                Element wEle = (Element) lastEle;
                if (wEle.getName().equals(OSISUtil.OSIS_ELEMENT_W)) {
                    StringBuilder buf = new StringBuilder();
                    String strongsAttr = wEle.getAttributeValue(OSISUtil.ATTRIBUTE_W_MORPH);
                    if (strongsAttr != null) {
                        buf.append(strongsAttr);
                        buf.append(' ');
                    }
                    buf.append(OSISUtil.MORPH_ROBINSONS);
                    buf.append(value);
                    wEle.setAttribute(OSISUtil.ATTRIBUTE_W_MORPH, buf.toString());
                }
            }
            return null;
        }

        if ("lemma".equals(type)) {
            List<Content> siblings = ele.getContent();
            int size = siblings.size();
            if (size == 0) {
                return null;
            }
            Content lastEle = siblings.get(size - 1);
            if (lastEle instanceof Text) {
                Element w = OSISUtil.factory().createW();
                w.setAttribute(OSISUtil.ATTRIBUTE_W_LEMMA, OSISUtil.LEMMA_MISC + value);
                siblings.set(size - 1, w);
                w.addContent(lastEle);
            } else if (lastEle instanceof Element) {
                Element wEle = (Element) lastEle;
                if (wEle.getName().equals(OSISUtil.OSIS_ELEMENT_W)) {
                    StringBuilder buf = new StringBuilder();
                    String lemmaAttr = wEle.getAttributeValue(OSISUtil.ATTRIBUTE_W_LEMMA);
                    if (lemmaAttr != null) {
                        buf.append(lemmaAttr);
                        buf.append(' ');
                    }
                    buf.append(OSISUtil.LEMMA_MISC);
                    buf.append(value);
                    wEle.setAttribute(OSISUtil.ATTRIBUTE_W_LEMMA, buf.toString());
                }
            }
            return null;
        }

        if ("Dict".equals(type)) {
            Element div = OSISUtil.factory().createDiv();
            div.setAttribute(OSISUtil.OSIS_ATTR_OSISID, "dict://" + value);

            if (ele != null) {
                ele.addContent(div);
            }

            return div;
        }

        DataPolice.report(book, key, "sync tag has type=" + type + " when value=" + value);
        return null;
    }
}
