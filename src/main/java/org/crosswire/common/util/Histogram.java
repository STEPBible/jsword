package org.crosswire.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * A simple implementation of a histogram. It would be nice to enhance it to
 * order on frequency.
 */
public class Histogram {
    /**
     * Create an empty histogram
     */
    public Histogram() {
        hist = new HashMap<String, Counter>();
    }

    /**
     * note that this key has been seen one time more than before.
     * 
     * @param key
     */
    public void increment(String key) {
        Counter counter = hist.get(key);
        if (counter == null) {
            counter = new Counter();
            hist.put(key, counter);
        }
        counter.increment();
    }

    public void clear() {
        hist.clear();
    }

    /**
     * The format of the histogram is an unordered list of string and the counts
     * of the number of times it has been seen.
     * 
     * @return the resultant histogram
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for (Map.Entry<String, Counter> entry : hist.entrySet()) {
            buf.append(entry.getKey());
            buf.append('\t');
            buf.append(entry.getValue().toString());
            buf.append('\n');
        }
        return buf.toString();
    }

    /**
     * Trivial mutable counting integer class.
     */
    private static class Counter {
        public Counter() {
        }

        public void increment() {
            counter++;
        }

        @Override
        public String toString() {
            return Integer.toString(counter);
        }

        private int counter;
    }

    private Map<String, Counter> hist;

}
