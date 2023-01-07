package org.crosswire.common.compress;

import static org.crosswire.common.util.PlatformTestUtils.startsWith;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.MissingResourceException;
import java.util.regex.Pattern;

import org.crosswire.common.util.PlatformTestUtils;
import org.crosswire.common.util.ResourceUtil;
import org.junit.Test;

/**
 * JUnit Test.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class BZip2Test {

    @Test
    public void testCompression() {
        InputStream kjvGenesis = null;
        try {
            kjvGenesis = ResourceUtil.getResourceAsStream("kjv_genesis.txt");
        } catch (MissingResourceException e) {
            fail();
        } catch (IOException e) {
            fail();
        }
        // new ByteArrayInputStream("ATATAAAFFFF".getBytes()));
        Compressor compressor = new BZip2(kjvGenesis);
        ByteArrayOutputStream bosCompressed = null;
        try {
            bosCompressed = compressor.compress();
        } catch (IOException e) {
            fail();
            return;
        }
        Compressor uncompressor = new BZip2(new ByteArrayInputStream(bosCompressed.toByteArray()));
        ByteArrayOutputStream bosUncompressed = null;
        try {
            bosUncompressed = uncompressor.uncompress();
        } catch (IOException e) {
            fail();
            return;
        };
        String result;
        try {
            byte[] back = bosUncompressed.toByteArray();
            result = new String(back, "UTF-8");
            assertTrue("round trip ZIP uncompression", startsWith(result, "^          \r?\nThe First Book of Moses, called Genesis"));
        } catch (UnsupportedEncodingException e) {
            fail();
            return;
        }

    }
}
