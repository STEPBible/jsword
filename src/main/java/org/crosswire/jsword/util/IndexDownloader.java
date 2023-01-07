package org.crosswire.jsword.util;

import java.io.IOException;
import java.net.URI;

import org.crosswire.common.util.NetUtil;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookException;
import org.crosswire.jsword.book.install.InstallException;
import org.crosswire.jsword.book.install.Installer;
import org.crosswire.jsword.index.IndexManager;
import org.crosswire.jsword.index.IndexManagerFactory;
import org.crosswire.jsword.index.IndexStatus;

/**
 * .
 */
public final class IndexDownloader {
    /**
     * Prevent instantiation
     */
    private IndexDownloader() {
    }

    /**
     * Download and install a search index
     * 
     * @param book
     *            The book to get an index for
     */
    public static void downloadIndex(Book book, Installer installer) throws IOException, InstallException, BookException {
        // Get a temp home
        URI tempDownload = NetUtil.getTemporaryURI(TEMP_PREFIX, TEMP_SUFFIX);

        IndexStatus finalStatus = IndexStatus.UNDONE;
        try {
            // Now we know what installer to use, download to the temp file
            installer.downloadSearchIndex(book, tempDownload);

            // And install from that file.
            IndexManager idxman = IndexManagerFactory.getIndexManager();
            book.setIndexStatus(IndexStatus.CREATING);
            idxman.installDownloadedIndex(book, tempDownload);
            finalStatus = IndexStatus.DONE;
        } finally {
            book.setIndexStatus(finalStatus);
            // tidy up after ourselves
            if (tempDownload != null) {
                NetUtil.delete(tempDownload);
            }
        }
    }

    /**
     * Temp file prefix
     */
    private static final String TEMP_PREFIX = "jsword-index";

    /**
     * Temp file suffix
     */
    private static final String TEMP_SUFFIX = "dat";
}
