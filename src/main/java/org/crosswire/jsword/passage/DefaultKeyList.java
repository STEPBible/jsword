package org.crosswire.jsword.passage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A default implementation of Key.
 * 
 * <p>
 * This implementation uses <tt>java.util.List</tt> to store keys.
 */
public class DefaultKeyList extends AbstractKeyList {
    /**
     * Simple ctor
     */
    public DefaultKeyList() {
        super(null);
    }

    /**
     * Simple ctor
     */
    public DefaultKeyList(Key parent, String name) {
        super(name);
        this.parent = parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#canHaveChildren()
     */
    public boolean canHaveChildren() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#getChildCount()
     */
    public int getChildCount() {
        return 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#getCardinality()
     */
    public int getCardinality() {
        return keys.size();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.Key#contains(org.crosswire.jsword.passage
     * .Key)
     */
    @Override
    public boolean contains(Key key) {
        return keys.contains(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#iterator()
     */
    public Iterator<Key> iterator() {
        return keys.iterator();
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.Key#add(org.crosswire.jsword.passage.Key)
     */
    public void addAll(Key key) {
        keys.add(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.Key#remove(org.crosswire.jsword.passage.Key)
     */
    public void removeAll(Key key) {
        keys.remove(key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#clear()
     */
    public void clear() {
        keys.clear();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#get(int)
     */
    public Key get(int index) {
        return keys.get(index);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.crosswire.jsword.passage.Key#indexOf(org.crosswire.jsword.passage
     * .Key)
     */
    public int indexOf(Key that) {
        return keys.indexOf(that);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#getParent()
     */
    public Key getParent() {
        return parent;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.jsword.passage.Key#blur(int)
     */
    public void blur(int by, RestrictionType restrict) {
        this.blur(by, restrict, true, true);
    }

    /* (non-Javadoc)
     * @see org.crosswire.jsword.passage.Key#blur(int, org.crosswire.jsword.passage.RestrictionType, boolean, boolean)
     */
    public void blur(int by, RestrictionType restrict, boolean blurDown, boolean blurUp) {
        log.warn("attempt to blur a non-blur-able list");
    }

    /**
     * The parent of this key
     */
    private Key parent;

    /**
     * The store of Keys
     */
    private List<Key> keys = new ArrayList<Key>();

    /**
     * Serialization ID
     */
    private static final long serialVersionUID = -1633375337613230599L;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(DefaultKeyList.class);
}
