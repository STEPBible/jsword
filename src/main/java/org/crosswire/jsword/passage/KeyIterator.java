package org.crosswire.jsword.passage;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * This KeyIterator performs a depth first iteration over the subkeys in the
 * key.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class KeyIterator implements Iterator<Key> {
    public KeyIterator(Key key) {
        stack = new Stack<Locator>();
        stack.push(new Locator(key));
    }

    protected void prepare() {
        // If there is nothing on the stack we have nothing to do.
        if (stack.size() == 0) {
            return;
        }

        // Check to see if there are more children to process
        Locator peek = stack.peek();

        if (peek.getParent().getChildCount() > peek.getPosition()) {
            return;
        }

        // There are no more so we are done with this Locator.
        stack.pop();

        // Try the next
        prepare();
    }

    public boolean hasNext() {
        prepare();
        return stack.size() != 0;
    }

    public Key next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }

        Locator peek = stack.peek();

        // Determine which child in the list of children to consider
        int childNum = peek.getPosition();

        // Advance to the next potential child
        peek.setPosition(childNum + 1);

        // If we have exhausted all the children,
        // then return the parent key
        if (childNum == -1) {
            return peek.getParent();
        }

        stack.push(new Locator(peek.getParent().get(childNum)));

        return next();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    /**
     * A helper class that remembers where we've been and where we are.
     */
    public static class Locator {
        private Key parent;
        private int position;

        public Locator(Key parent) {
            this.parent = parent;
            this.position = -1;
        }

        /**
         * @return the parent
         */
        public Key getParent() {
            return parent;
        }

        /**
         * @param parent
         *            the parent to set
         */
        public void setParent(Key parent) {
            this.parent = parent;
        }

        /**
         * @return the position
         */
        public int getPosition() {
            return position;
        }

        /**
         * @param position
         *            the position to set
         */
        public void setPosition(int position) {
            this.position = position;
        }

    }

    private Stack<Locator> stack;
}
