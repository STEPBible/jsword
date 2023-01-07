package org.crosswire.jsword.book;

import java.io.IOException;

import org.crosswire.common.util.PluginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Factory class for Bookmarks.
 */
public final class BookmarkFactory {
    /**
     * Prevent instantiation
     */
    private BookmarkFactory() {
    }

    /**
     * Create a new Bookmark.
     */
    public static Bookmark getBookmark() {
        return instance.clone();
    }

    /**
     * The singleton
     */
    private static Bookmark instance;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(BookmarkFactory.class);

    /**
     * Setup the instance
     */
    static {
        try {
            instance = PluginUtil.getImplementation(Bookmark.class);
        } catch (IOException e) {
            log.error("createBookmark failed", e);
        } catch (ClassCastException e) {
            log.error("createBookmark failed", e);
        } catch (ClassNotFoundException e) {
            log.error("createBookmark failed", e);
        } catch (IllegalAccessException e) {
            log.error("createBookmark failed", e);
        } catch (InstantiationException e) {
            log.error("createBookmark failed", e);
        }
    }
}
