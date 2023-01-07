package org.crosswire.jsword.book.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.crosswire.jsword.book.Book;
import org.crosswire.jsword.book.BookData;
import org.crosswire.jsword.book.Bookmark;
import org.crosswire.jsword.index.search.SearchRequest;

/**
 * A Bookmark remembers a particular view of one or more Books. What is viewed
 * regarding a book set is either a SearchRequest or a key lookup request.
 */
public class DefaultBookmark implements Bookmark {
    /**
     * Create an empty default bookmark
     */
    public DefaultBookmark() {
        books = new ArrayList<Book>();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#addBook(org.crosswire.jsword.book.Book)
     */
    public void addBook(Book book) {
        books.add(book);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#getBooks()
     */
    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#setSearchRequest(org.crosswire.jsword.index.search.SearchRequest)
     */
    public void setSearchRequest(SearchRequest request) {
        searchRequest = request;
        lookupRequest = null;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#getSearchRequest()
     */
    public SearchRequest getSearchRequest() {
        return searchRequest;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#setLookupRequest(java.lang.String)
     */
    public void setLookupRequest(String request) {
        lookupRequest = request;
        searchRequest = null;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#getLookupRequest()
     */
    public String getLookupRequest() {
        return lookupRequest;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.book.Bookmark#getBookData()
     */
    public BookData getBookData() {
        return null;
    }

    @Override
    public DefaultBookmark clone() {
        DefaultBookmark clone = null;
        try {
            clone = (DefaultBookmark) super.clone();
        } catch (CloneNotSupportedException e) {
            assert false : e;
        }
        return clone;
    }

    /**
     * The list of books.
     */
    private transient List<Book> books;

    /**
     * The lookup request.
     */
    private String lookupRequest;

    /**
     * The search request.
     */
    private SearchRequest searchRequest;

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = 6959196267292499574L;
}
