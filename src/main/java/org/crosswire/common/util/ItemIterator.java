package org.crosswire.common.util;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An <code>ItemIterator</code> is an <code>Iterator</code> that iterates a
 * single item.
 * 
 * @param <T> The type of the single element that this iterator will return.
 */
public class ItemIterator<T> implements Iterator<T> {
    public ItemIterator(T item) {
        this.item = item;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#hasNext()
     */
    public boolean hasNext() {
        return !done;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#next()
     */
    public T next() {
        if (done) {
            throw new NoSuchElementException();
        }

        done = true;
        return item;
    }

    /* (non-Javadoc)
     * @see java.util.Iterator#remove()
     */
    public void remove() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    private T item;
    private boolean done;
}
