package org.crosswire.jsword.passage;

import java.util.Iterator;

import org.crosswire.jsword.JSOtherMsg;

/**
 * A read-only wrapper around any writable implementation of Key.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 */
public class ReadOnlyKeyList implements Key {
    /**
     * Simple ctor
     */
    public ReadOnlyKeyList(Key keys, boolean ignore) {
        this.keys = keys;
        this.ignore = ignore;
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getCardinality()
     */
    public int getCardinality() {
        return keys.getCardinality();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#canHaveChildren()
     */
    public boolean canHaveChildren() {
        return keys.canHaveChildren();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getChildCount()
     */
    public int getChildCount() {
        return keys.getChildCount();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#isEmpty()
     */
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#contains(org.crosswire.jsword.passage.Key)
     */
    public boolean contains(Key key) {
        return keys.contains(key);
    }

    /* (non-Javadoc)
     * @see java.lang.Iterable#iterator()
     */
    public Iterator<Key> iterator() {
        return keys.iterator();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#addAll(org.crosswire.jsword.passage.Key)
     */
    public void addAll(Key key) {
        if (ignore) {
            return;
        }

        throw new IllegalStateException(JSOtherMsg.lookupText("Cannot alter a read-only key list"));
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#removeAll(org.crosswire.jsword.passage.Key)
     */
    public void removeAll(Key key) {
        if (ignore) {
            return;
        }

        throw new IllegalStateException(JSOtherMsg.lookupText("Cannot alter a read-only key list"));
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#retainAll(org.crosswire.jsword.passage.Key)
     */
    public void retainAll(Key key) {
        if (ignore) {
            return;
        }

        throw new IllegalStateException(JSOtherMsg.lookupText("Cannot alter a read-only key list"));
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#clear()
     */
    public void clear() {
        if (ignore) {
            return;
        }

        throw new IllegalStateException(JSOtherMsg.lookupText("Cannot alter a read-only key list"));
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getName()
     */
    public String getName() {
        return keys.getName();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getRootName()
     */
    public String getRootName() {
        return keys.getRootName();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getName(org.crosswire.jsword.passage.Key)
     */
    public String getName(Key base) {
        return keys.getName(base);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getOsisRef()
     */
    public String getOsisRef() {
        return keys.getOsisRef();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getOsisID()
     */
    public String getOsisID() {
        return keys.getOsisID();
    }

    @Override
    public int hashCode() {
        return keys.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return keys.equals(obj);
    }

    /* (non-Javadoc)
     * @see java.lang.Comparable#compareTo(java.lang.Object)
     */
    public int compareTo(Key o) {
        return keys.compareTo(o);
    }

   /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#get(int)
     */
    public Key get(int index) {
        return keys.get(index);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#indexOf(org.crosswire.jsword.passage.Key)
     */
    public int indexOf(Key that) {
        return keys.indexOf(that);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#getParent()
     */
    public Key getParent() {
        return keys.getParent();
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#blur(int, org.crosswire.jsword.passage.RestrictionType)
     */
    public void blur(int by, RestrictionType restrict) {
        blur(by, restrict, true, true);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#blur(int, org.crosswire.jsword.passage.RestrictionType, boolean, boolean)
     */
    public void blur(int by, RestrictionType restrict, boolean blurDown, boolean blurUp) {
        if (ignore) {
            return;
        }

        throw new IllegalStateException(JSOtherMsg.lookupText("Cannot alter a read-only key list"));
    }

    @Override
    public ReadOnlyKeyList clone() {
        ReadOnlyKeyList clone = null;
        try {
            clone = (ReadOnlyKeyList) super.clone();
            clone.keys = keys.clone();
        } catch (CloneNotSupportedException e) {
            assert false : e;
        }
        return clone;
    }

    /**
     * Do we ignore write requests or throw?
     */
    private boolean ignore;

    /**
     * The Key to which we proxy
     */
    private Key keys;

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = -7947159638198641657L;
}
