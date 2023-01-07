package org.crosswire.jsword.index.query;

import java.io.IOException;

import org.crosswire.common.util.PluginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Factory class for QueryBuilder.
 */
public final class QueryBuilderFactory {
    /**
     * Prevent instantiation
     */
    private QueryBuilderFactory() {
    }

    /**
     * Create a new QueryBuilder.
     */
    public static QueryBuilder getQueryBuilder() {
        return instance;
    }

    /**
     * The singleton
     */
    private static QueryBuilder instance;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(QueryBuilderFactory.class);

    /**
     * Setup the instance
     */
    static {
        try {
            instance = PluginUtil.getImplementation(QueryBuilder.class);
        } catch (IOException e) {
            log.error("create QueryBuilder failed", e);
        } catch (ClassCastException e) {
            log.error("create QueryBuilder failed", e);
        } catch (ClassNotFoundException e) {
            log.error("create QueryBuilder failed", e);
        } catch (InstantiationException e) {
            log.error("create QueryBuilder failed", e);
        } catch (IllegalAccessException e) {
            log.error("create QueryBuilder failed", e);
        }
    }
}
