package org.crosswire.jsword.book.basic;

import org.crosswire.jsword.JSOtherMsg;
import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookDriver;
import org.crosswire.jsword.book.BookException;

/**
 * The AbstractBookDriver class implements some BibleDriver methods, making a
 * simple read-only BibleDriver.
 */
public abstract class AbstractBookDriver implements BookDriver {
    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.BookDriver#isWritable()
     */
    public boolean isWritable() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.book.BookDriver#create(org.crosswire.jsword.book
     * .Book, org.crosswire.jsword.book.events.WorkListener)
     */
    public Book create(Book source) throws BookException {
        throw new BookException(JSOtherMsg.lookupText("This Book is read-only."));
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.book.BookDriver#isDeletable(org.crosswire.jsword
     * .book.Book)
     */
    public boolean isDeletable(Book dead) {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.book.BookDriver#delete(org.crosswire.jsword.book
     * .Book)
     */
    public void delete(Book dead) throws BookException {
        throw new BookException(JSOtherMsg.lookupText("This Book is read-only."));
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.book.BookProvider#getFirstBook()
     */
    public Book getFirstBook() {
        Book[] books = getBooks();
        return books == null || books.length == 0 ? null : books[0];
    }
}
