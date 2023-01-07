package org.crosswire.jsword.passage;

/**
 * To help us test the VerseCollectionListener interface.
 */
class FixturePassageListener implements PassageListener {
    public int adds = 0;
    public int removals = 0;
    public int changes = 0;

    public FixturePassageListener() {
    }

    public void versesAdded(PassageEvent ev) {
        adds++;
    }

    public void versesRemoved(PassageEvent ev) {
        removals++;
    }

    public void versesChanged(PassageEvent ev) {
        changes++;
    }

    public boolean check(int addcheck, int removalcheck, int changecheck) throws Exception {
        if (this.adds != addcheck) {
            throw new Exception("ADD: should have: " + addcheck + ", noted " + this.adds);
        }

        if (this.removals != removalcheck) {
            throw new Exception("REMOVALS: should have: " + removalcheck + ", noted " + this.removals);
        }

        if (this.changes != changecheck) {
            throw new Exception("CHANGES: should have: " + changecheck + ", noted " + this.changes);
        }

        return true;
    }
}
