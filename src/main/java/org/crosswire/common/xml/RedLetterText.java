package org.crosswire.common.xml;

/**
 * RedLetterText remembers when text should be red. Red Letter Text is used to
 * highlight the words of Jesus.
 * 
 * @see gnu.lgpl.License for license details.<br>
 *      The copyright to this program is held by it's authors.
 * @author DM Smith
 * 
 */
public class RedLetterText {
    private int rlt;

    /**
     * Construct a RedLetterText.
     */
    public RedLetterText() {
        rlt = 0;
    }

    /**
     * Call when Red Letter Text is entered
     * 
     */
    public void enter() {
        rlt++;
    }

    /**
     * Call when Red Letter Text is left
     * 
     */
    public void leave() {
        if (rlt > 0) {
            rlt--;
        }
    }

    /**
     * Returns true when one is in Red Letter Text
     * 
     * @return true if in RLT, false otherwise
     */
    public boolean isRLT() {
        return rlt > 0;
    }
}
