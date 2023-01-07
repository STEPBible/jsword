package org.crosswire.common.diff;

/**
 * Computes the difference between two texts to create a patch. Applies the
 * patch onto another text, allowing for errors.
 * 
 * Based on the LGPL Diff_Match_Patch v1.5 javascript of Neil Fraser, Copyright (C) 2006<br>
 * <a href="http://neil.fraser.name/software/diff_match_patch/">http://neil.fraser.name/software/diff_match_patch/</a>
 */
public class Match implements Locator {
    public Match() {
        this("", "", 0);
    }

    /**
     * Locate the best instance of 'pattern' in 'text' near 'loc'.
     * 
     * @param text
     *            The text to search
     * @param pattern
     *            The pattern to search for
     * @param loc
     *            The location to search around
     */
    public Match(String text, String pattern, int loc) {
        this.text = text;
        this.pattern = pattern;
        this.loc = loc;
        this.locator = new Bitap(text, pattern, loc);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.crosswire.common.diff.Locator#maxPatternLength()
     */
    public int maxPatternLength() {
        return locator.maxPatternLength();
    }

    /**
     * Locate the best instance of 'pattern' in 'text' near 'loc'.
     * 
     * @return Best match index or -1, if no match found
     */
    public int locate() {
        if (text.equals(pattern)) {
            // Shortcut (potentially not guaranteed by the algorithm)
            return 0;
        }

        if (text.length() == 0) {
            // Nothing to match.
            return -1;
        }

        loc = Math.max(0, Math.min(loc, text.length() - pattern.length()));
        if (text.substring(loc, loc + pattern.length()).equals(pattern)) {
            // Perfect match at the perfect spot! (Includes case of null
            // pattern)
            return loc;
        }

        return locator.locate();
    }

    /**
     * The text to search.
     */
    private String text;

    /**
     * The pattern to find in the text.
     */
    private String pattern;

    /**
     * The location in text to focus the search.
     */
    private int loc;

    /**
     * The strategy for locating a best match.
     */
    private Locator locator;
}
