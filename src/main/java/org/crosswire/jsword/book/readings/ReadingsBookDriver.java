package org.crosswire.jsword.book.readings;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.crosswire.common.util.NetUtil;
import org.crosswire.common.util.ResourceUtil;
import org.crosswire.common.util.URIFilter;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookCategory;
import org.crosswire.jsword.book.BookDriver;
import org.crosswire.jsword.book.basic.AbstractBookDriver;

/**
 * A driver for the readings dictionary.
 */
public class ReadingsBookDriver extends AbstractBookDriver {
    /**
     * Setup the array of BookMetaDatas
     */
    public ReadingsBookDriver() {
        List<Book> bookList = new ArrayList<Book>();
        String[] installedBooks = getInstalledReadingsSets();
        for (int i = 0; i < installedBooks.length; i++) {
            bookList.add(new ReadingsBook(this, installedBooks[i], BookCategory.DAILY_DEVOTIONS));
        }

        books = bookList.toArray(new Book[bookList.size()]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.BookDriver#getBooks()
     */
    public Book[] getBooks() {
        return books == null ? null : (Book[]) books.clone();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.BookDriver#getDriverName()
     */
    public String getDriverName() {
        return "Readings";
    }

    /**
     * Get the singleton instance of this driver.
     * 
     * @return this driver instance
     */
    public static BookDriver instance() {
        return INSTANCE;
    }

    /**
     * Get a list of the available readings sets
     */
    public String[] getInstalledReadingsSets() {
        try {
            URL index = ResourceUtil.getResource(ReadingsBookDriver.class, "readings.txt");
            return NetUtil.listByIndexFile(NetUtil.toURI(index), new ReadingsFilter());
        } catch (IOException ex) {
            return new String[0];
        }
    }

    /**
     * Get all files mentioned by readings.txt
     */
    static final class ReadingsFilter implements URIFilter {
        public boolean accept(String name) {
            return true;
        }
    }

    /**
     * The meta data array
     */
    private Book[] books;

    /**
     * Resources subdir for readings sets
     */
    public static final String DIR_READINGS = "readings";

    /**
     * A shared instance of this driver.
     */
    private static final BookDriver INSTANCE = new ReadingsBookDriver();
}
