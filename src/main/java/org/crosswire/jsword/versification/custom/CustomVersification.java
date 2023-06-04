package org.crosswire.jsword.versification.custom;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.crosswire.common.util.CWProject;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.BookMetaData;
import org.crosswire.jsword.book.Books;
import org.crosswire.jsword.book.sword.SwordConstants;
import org.crosswire.jsword.passage.Key;
import org.crosswire.jsword.passage.NoSuchKeyException;
import org.crosswire.jsword.versification.BibleBook;
import org.crosswire.jsword.versification.Versification;
import org.crosswire.jsword.versification.system.Versifications;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CustomVersification {

    public void loadFromJSON(final File jsonFile) throws NoSuchKeyException, BookException, IOException {

        //read json file data to String
        File f;

        byte[] jsonData = Files.readAllBytes(Paths.get(jsonFile.getPath()));

        //create ObjectMapper instance and allow comments
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

        //convert json string to V11nTmp object
        V11nTmp v11n = objectMapper.readValue(jsonData, V11nTmp.class);

        SystemCustomVersification.V11N_NAME = v11n.v11nName;

        int vmIndex = 0;
        SystemCustomVersification.BOOKS_OT = new BibleBook[v11n.otbooks.length - 1];
        SystemCustomVersification.LAST_VERSE_OT = new int[v11n.otbooks.length - 1][];
        for(int i = 0; i < v11n.otbooks.length - 1; i++){
            SystemCustomVersification.BOOKS_OT[i] = BibleBook.fromOSIS(v11n.otbooks[i].osis);
            SystemCustomVersification.LAST_VERSE_OT[i] = new int[v11n.otbooks[i].chapmax];
            System.arraycopy( v11n.vm, vmIndex, SystemCustomVersification.LAST_VERSE_OT[i], 0, v11n.otbooks[i].chapmax);
            vmIndex += v11n.otbooks[i].chapmax;
        }

        SystemCustomVersification.BOOKS_NT = new BibleBook[v11n.ntbooks.length - 1];
        SystemCustomVersification.LAST_VERSE_NT = new int[v11n.ntbooks.length - 1][];
        for(int i = 0; i < v11n.ntbooks.length - 1; i++){
            SystemCustomVersification.BOOKS_NT[i] = BibleBook.fromOSIS(v11n.ntbooks[i].osis);
            SystemCustomVersification.LAST_VERSE_NT[i] = new int[v11n.ntbooks[i].chapmax];
            System.arraycopy( v11n.vm, vmIndex, SystemCustomVersification.LAST_VERSE_NT[i], 0, v11n.ntbooks[i].chapmax);
            vmIndex += v11n.ntbooks[i].chapmax;
        }

        if(!Versifications.instance().isDefined(SystemCustomVersification.V11N_NAME)) {
            Versifications.instance().register(new SystemCustomVersification());
            try {
                URI[] dirs = CWProject.instance().getProjectResourceDirs();
                final File parent = new File(dirs[0]);
                File mapFile = new File(parent, SystemCustomVersification.V11N_NAME + ".properties");
                if (mapFile.exists()) mapFile.delete();

                mapFile.createNewFile();
                FileWriter myWriter = new FileWriter(mapFile.getPath());
                for(int i = 0; i < v11n.jsword_mappings.length; i++)
                {
                    myWriter.write(v11n.jsword_mappings[i]);
                    myWriter.write("\n");
                }
                /*for(int i = 0; i < v11n.jsword_mappings.length; i+=7)
                {
                    String bk;
                    if(v11n.jsword_mappings[i] > v11n.otbooks.length)
                        bk = v11n.ntbooks[v11n.jsword_mappings[i] - v11n.otbooks.length].osis;
                    else
                        bk = v11n.ntbooks[v11n.jsword_mappings[i]].osis;
                    int c1 = v11n.jsword_mappings[i+1];
                    int v1 = v11n.jsword_mappings[i+2];
                    int v1e = v11n.jsword_mappings[i+3];
                    int c2 = v11n.jsword_mappings[i+4];
                    int v2 = v11n.jsword_mappings[i+5];
                    int v2e = v11n.jsword_mappings[i+6];
                    String map = String.format("%s.%d.%d", bk,c1,v1);
                    if(v1e > v1)
                        map = String.format("%s-%s.%d.%d", map,bk,c1,v1e);
                    map = String.format("%s=%s.%d.%d", map,bk,c2,v2);
                    if(v2e > v2)
                        map = String.format("%s-%s.%d.%d", map,bk,c2,v2e);
                    myWriter.write(map);
                    myWriter.write("\n");
                }*/
                myWriter.close();

            } catch (IOException ex) {
                log.error("Failed to process custom versification file", ex);
            }
        }
/*
        final Books books = Books.installed();
        final Book svd = books.getBook("arasvd2");
        BookMetaData bmd = svd.getBookMetaData();
        String v = (String) bmd.getProperty(BookMetaData.KEY_VERSIFICATION);
        final Versification v11nTest = Versifications.instance().getVersification("NRSV2" );

        final Key key = svd.getKey("Gen.1-Mal.4");
*/

    }
    private static final Logger log = LoggerFactory.getLogger(CustomVersification.class);
}
