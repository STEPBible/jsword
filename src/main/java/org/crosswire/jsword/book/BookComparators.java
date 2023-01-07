package org.crosswire.jsword.book;

import java.util.Comparator;

/**
 * Provides different ways to sort Books.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public final class BookComparators {
    /**
     * Ensure we can't be created
     */
    private BookComparators() {
    }

    /**
     * Order by default Book ordering
     */
    public static Comparator<Book> getDefault() {
        return new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                return o1.compareTo(o2);
            }
        };
    }

    /**
     * Order by Initials.
     */
    public static Comparator<Book> getInitialComparator() {
        return new Comparator<Book>() {
            public int compare(Book o1, Book o2) {
                return o1.getInitials().compareTo(o2.getInitials());
            }
        };
    }
}
