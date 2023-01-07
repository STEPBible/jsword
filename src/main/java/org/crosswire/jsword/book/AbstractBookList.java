package org.crosswire.jsword.book;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.crosswire.common.util.CollectionUtil;

/**
 * A basic implementation of BookList. The methods in this abstract class are
 * duplicates of those in Books, so bugs fixed in one should be fixed in the
 * other too.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public abstract class AbstractBookList implements BookList {
    /**
     * Build a default BookList
     */
    public AbstractBookList() {
        listeners = new CopyOnWriteArrayList<BooksListener>();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookList#getBooks(org.crosswire.jsword.book.BookFilter)
     */
    public List<Book> getBooks(BookFilter filter) {
        List<Book> temp = CollectionUtil.createList(new BookFilterIterator(getBooks(), filter));
        return Collections.unmodifiableList(temp);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookList#addBooksListener(org.crosswire.jsword.book.BooksListener)
     */
    public void addBooksListener(BooksListener li) {
        listeners.add(li);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.BookList#removeBooksListener(org.crosswire.jsword.book.BooksListener)
     */
    public  void removeBooksListener(BooksListener li) {
        listeners.remove(li);
    }

    /**
     * Kick of an event sequence
     * 
     * @param source
     *            The event source
     * @param book
     *            The changed Book
     * @param added
     *            Is it added?
     */
    protected void fireBooksChanged(Object source, Book book, boolean added) {
        BooksEvent ev = new BooksEvent(source, book, added);
        for (BooksListener listener : listeners) {
            if (added) {
                listener.bookAdded(ev);
            } else {
                listener.bookRemoved(ev);
            }
        }
    }

    /**
     * The list of listeners
     */
    private List<BooksListener> listeners = new CopyOnWriteArrayList<BooksListener>();
}
