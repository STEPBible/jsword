package org.crosswire.jsword.book;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crosswire.jsword.book.sword.SwordBookMetaData;
import org.junit.Test;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author Joe Walker [joe at eireneh dot com]
 * @author DM Smith
 */
public class BookMetaDataTest {
    @Test
    public void testDifferentInitialsNotEqual() {
        String kjvMetaData = "[KJV]\nDataPath=./modules/texts/ztext/kjv/\nModDrv=zText\nEncoding=UTF-8\nBlockType=BOOK\nCompressType=ZIP\nSourceType=OSIS\nLang=en\nVersion=2.3\nDescription=King James Version (1769) with Strongs Numbers and Morphology\nLCSH=Bible. English.\n";
        // the only difference is the initials
        String kjvaMetaData = "[KJVA]\nDataPath=./modules/texts/ztext/kjva/\nModDrv=zText\nEncoding=UTF-8\nBlockType=BOOK\nCompressType=ZIP\nSourceType=OSIS\nLang=en\nVersion=2.3\nDescription=King James Version (1769) with Strongs Numbers and Morphology\nLCSH=Bible. English.\n";
        try {
            BookMetaData bmKJV = new SwordBookMetaData(kjvMetaData.getBytes(), "KJV");
            BookMetaData bmKJV2 = new SwordBookMetaData(kjvMetaData.getBytes(), "KJV");
            BookMetaData bmKJVA = new SwordBookMetaData(kjvaMetaData.getBytes(), "KJVA");
            assertTrue( "Same metadata should equal", bmKJV.equals(bmKJV2));
            assertFalse("Different initials should not equal", bmKJV.equals(bmKJVA));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSortOrderIsByInitials() {
        String kjvMetaData = "[KJV]\nDataPath=./modules/texts/ztext/kjv/\nModDrv=zText\nEncoding=UTF-8\nBlockType=BOOK\nCompressType=ZIP\nSourceType=OSIS\nLang=en\nVersion=2.3\nDescription=King James Version (1769) with Strongs Numbers and Morphology\nLCSH=Bible. English.\n";
        // Desc starts with 'The...' but initials are 'Common' so comes first if sorted by initials
        String commonMetaData = "[Common]\nDataPath=./modules/texts/ztext/common/\nModDrv=zText\nEncoding=UTF-8\nBlockType=BOOK\nCompressType=ZIP\nSourceType=OSIS\nLang=en\nVersion=2.3\nDescription=The Common Edition: New Testament\nLCSH=Bible. English.\n";
        // Ensure sort is case insensitive
        String aaaMetaData = "[aaa]\nDataPath=./modules/texts/ztext/common/\nModDrv=zText\nEncoding=UTF-8\nBlockType=BOOK\nCompressType=ZIP\nSourceType=OSIS\nLang=en\nVersion=2.3\nDescription=aaa aaa aaa\nLCSH=Bible. English.\n";
        try {
            // create some book meta data
            BookMetaData bmKJV = new SwordBookMetaData(kjvMetaData.getBytes(), "KJV");
            BookMetaData bmCommon = new SwordBookMetaData(commonMetaData.getBytes(), "Common");
            BookMetaData bmaaa = new SwordBookMetaData(aaaMetaData.getBytes(), "aaa");

            // sort them
            List<BookMetaData> mdList = new ArrayList<BookMetaData>();
            mdList.add(bmKJV);
            mdList.add(bmCommon);
            mdList.add(bmaaa);
            Collections.sort(mdList);
            
            // ensure the book order is as expected
            assertEquals("aaa should be first in sorted book list", bmaaa, mdList.get(0));
            assertEquals("Common should be second in sorted book list", bmCommon, mdList.get(1));
            assertEquals("KJV should be last in sorted book list", bmKJV, mdList.get(2));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
