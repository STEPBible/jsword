
package org.crosswire.jsword.book.data;

import java.util.Iterator;

import org.crosswire.common.xml.SAXEventProvider;
import org.crosswire.jsword.book.BookException;

/**
 * Basic section of BookData.
 * 
 * <p><table border='1' cellPadding='3' cellSpacing='0'>
 * <tr><td bgColor='white' class='TableRowColor'><font size='-7'>
 *
 * Distribution Licence:<br />
 * JSword is free software; you can redistribute it
 * and/or modify it under the terms of the GNU General Public License,
 * version 2 as published by the Free Software Foundation.<br />
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.<br />
 * The License is available on the internet
 * <a href='http://www.gnu.org/copyleft/gpl.html'>here</a>, or by writing to:
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330, Boston,
 * MA 02111-1307, USA<br />
 * The copyright to this program is held by it's authors.
 * </font></td></tr></table>
 * @see docs.Licence
 * @author Joe Walker [joe at eireneh dot com]
 * @version $Id$
 */
public interface BibleData extends BookData
{
    /**
     * Output the current data as a SAX stream.
     * @return SAXEventProvider
     */
    public SAXEventProvider getSAXEventProvider();

    /**
     * A simplified plain text version of the data in this verse with all
     * the markup stripped out.
     * @return The text without markup
     */
    public String getPlainText();

    /**
     * This is an enumeration through all the sections in this Document.
     * Each of the sections will be able to give a list of the Verses
     * that it contains.
     * @return The list of sections
     */
    public Iterator getSectionDatas();

    /**
     * Start a new section
     * @param title The heading for this section
     * @param version The Bible string
     */
    public SectionData createSectionData(String title) throws BookException;
}
