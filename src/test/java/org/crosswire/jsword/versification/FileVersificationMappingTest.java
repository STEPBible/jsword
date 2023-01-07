package org.crosswire.jsword.versification;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.MissingResourceException;

import org.crosswire.common.config.ConfigException;
import org.crosswire.jsword.versification.system.Versifications;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * JUnit Test
 */
@RunWith(Parameterized.class)
public class FileVersificationMappingTest {
    private String v11nName;

    /**
     * @param v11nName the v11n name we are testing
     */
    public FileVersificationMappingTest(String v11nName) {
        this.v11nName = v11nName;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {

        Iterator<String> v11ns = Versifications.instance().iterator();
        List<Object[]> v11nsAsList = new ArrayList<Object[]>();
        while (v11ns.hasNext()) {
            v11nsAsList.add(new String[]{v11ns.next()});
        }

        return v11nsAsList;
    }

    @Test
    public void testVersifications() throws IOException, ConfigException {
        final Versification versification = Versifications.instance().getVersification(v11nName);
        try {
            FileVersificationMapping m = new FileVersificationMapping(versification);
            VersificationToKJVMapper mapper = new VersificationToKJVMapper(versification, m);
            Assert.assertFalse("Failed to parse " + this.v11nName, mapper.hasErrors());
        } catch (final MissingResourceException mre) {
            //ignore, as this basically means we don't have mappings...
        }
    }
}
