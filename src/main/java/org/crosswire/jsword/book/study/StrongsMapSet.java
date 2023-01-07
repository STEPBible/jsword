package org.crosswire.jsword.book.study;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * A StrongsMapSet is keyed by a Strong's Number of the form Gd or Hd, where G
 * and H stand for Greek and Hebrew respectively and d is the actual number,
 * zero padded to 4 digits. The value for a MapEntry is a Set of Strings, which
 * are the various ways a Strong's Number is marked up.
 */
public class StrongsMapSet {
    /**
     * Build an empty Strong's Map Set.
     */
    public StrongsMapSet() {
        map = new HashMap<String, Set<String>>();
    }

    /**
     * Add a String representing the content of an instance of a Strong's Number
     * in a text.
     * 
     * @param strongsNumber
     *            the Strong's Number
     * @param representation
     *            a way the Strong's number is represented.
     */
    public void add(String strongsNumber, String representation) {
        Set<String> reps = map.get(strongsNumber);
        if (reps == null) {
            reps = new TreeSet<String>();
            map.put(strongsNumber, reps);
        }
        reps.add(representation.toLowerCase(Locale.ENGLISH));
    }

    /**
     * Get the set of all representations for a Strong's Number.
     * 
     * @param strongsNumber
     * @return the whole set
     */
    public Set<String> get(String strongsNumber) {
        return map.get(strongsNumber);
    }

    private Map<String, Set<String>> map;
}
