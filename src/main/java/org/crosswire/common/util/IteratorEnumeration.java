package org.crosswire.common.util;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Convert an Iterator into a Enumeration.
 * <p>
 * The only real difference between the 2 is the naming and that Enumeration
 * does not have the delete method.
 * </p>
 * 
 * @param <E> The type of the elements returned by this iterator
 */
public final class IteratorEnumeration<E> implements Enumeration<E> {
    /**
     * Create an Enumeration that proxies to an Iterator
     */
    public IteratorEnumeration(Iterator<E> it) {
        this.it = it;
    }

    /**
     * Returns true if the iteration has more elements
     */
    public boolean hasMoreElements() {
        return it.hasNext();
    }

    /**
     * Returns the next element in the interation
     */
    public E nextElement() throws NoSuchElementException {
        return it.next();
    }

    /**
     * The Iterator that we are proxying to
     */
    private Iterator<E> it;
}
