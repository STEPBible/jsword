package org.crosswire.jsword.passage;

import org.crosswire.jsword.versification.Versification;
import org.crosswire.jsword.versification.system.Versifications;

/**
 * .
 */
public final class KeyUtil {
    /**
     * Prevent instantiation
     */
    private KeyUtil() {
    }

    /**
     * Walk through a tree visiting the nodes and branches in the tree
     * 
     * @param key
     *            The node tree to walk through
     * @param visitor
     *            The visitor to notify whenever a node is found
     */
    public static void visit(Key key, KeyVisitor visitor) {
        for (Key subkey : key) {
            if (subkey.canHaveChildren()) {
                visitor.visitBranch(subkey);
                visit(subkey, visitor);
            } else {
                visitor.visitLeaf(subkey);
            }
        }
    }

    /**
     * Cast a Key to a Verse. Only those keys that are a Verse or can
     * contain Verses (i.e. Passage and VerseRange) may be cast to one.
     * Verse containers (i.e. Passage and VerseRange) return their
     * first verse.
     * 
     * @param key The key to cast
     * @return The key cast to a Verse
     * @throws ClassCastException
     */
    public static Verse getVerse(Key key) {
        if (key instanceof Verse) {
            return (Verse) key;
        }

        if (key instanceof VerseRange) {
            VerseRange range = (VerseRange) key;
            return range.getStart();
        }

        if (key instanceof Passage) {
            Passage ref = (Passage) key;
            return ref.getVerseAt(0);
        }

        throw new ClassCastException("Expected key to be a Verse, VerseRange or Passage");
    }

    /**
     * Cast a Key to a Passage. Only those keys that are a Passage or can
     * be held by a Passage (i.e. Verse and VerseRange) may be cast to one.
     * If you pass a null key into this method, you get a null Passage out.
     * 
     * @param key The key to cast
     * @return The key cast to a Passage
     * @throws ClassCastException
     */
    public static Passage getPassage(Key key) {
        if (key == null) {
            return null;
        }

        if (key instanceof Passage) {
            return (Passage) key;
        }

        if (key instanceof VerseKey) {
            VerseKey verseKey = (VerseKey) key;
            Key ref = PassageKeyFactory.instance().createEmptyKeyList(verseKey.getVersification());
            ref.addAll(verseKey);
            return (Passage) ref;
        }

        throw new ClassCastException("Expected key to be a Verse, VerseRange or Passage");
    }

    /**
     * Get the versification for the key or the default versification.
     * 
     * @param key the key that should provide for the Versification
     * @return the versification for the key
     */
    public static Versification getVersification(Key key) {
        if (key instanceof VerseKey) {
            return ((VerseKey) key).getVersification();
        }
        return Versifications.instance().getVersification(Versifications.DEFAULT_V11N);
    }
}
