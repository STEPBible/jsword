package org.crosswire.common.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An <code>EmptyIterator</code> is an <code>Iterator</code> that iterates over
 * nothing.
 * 
 * @param <E> The type of the element that this empty iterator will never return.
 */
public class EmptyIterator<E> implements Iterator<E> {

    /**
     * Construct an <code>EmptyIterator</code>.
     */
    public EmptyIterator() {
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    public void remove() {
        throw new UnsupportedOperationException();
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
        return false;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    public E next() {
        throw new NoSuchElementException();
    }

}
