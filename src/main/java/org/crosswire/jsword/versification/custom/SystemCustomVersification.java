package org.crosswire.jsword.versification.custom;

import org.crosswire.jsword.versification.BibleBook;
import org.crosswire.jsword.versification.Versification;

public class SystemCustomVersification  extends Versification {

    /* protected */ SystemCustomVersification() {
        //super(V11N_NAME, BOOKS_OT, BOOKS_NT, LAST_VERSE_OT, LAST_VERSE_NT);
    }

    public void uodateSuper() {
        super.initializeVersification(this.V11N_NAME, BOOKS_OT, BOOKS_NT, LAST_VERSE_OT, LAST_VERSE_NT);
    }

    public String V11N_NAME = "";
    BibleBook[] BOOKS_OT = {
    };

    BibleBook[] BOOKS_NT = {
    };

    int[][] LAST_VERSE_OT = {
    };

    int[][] LAST_VERSE_NT = {
    };

    //private static final long serialVersionUID = -1483944788413812511L;
}
