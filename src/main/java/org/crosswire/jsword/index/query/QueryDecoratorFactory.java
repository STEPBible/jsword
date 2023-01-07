package org.crosswire.jsword.index.query;

import java.io.IOException;

import org.crosswire.common.util.PluginUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A Factory class for QueryDecorator.
 */
public final class QueryDecoratorFactory {
    /**
     * Prevent instantiation
     */
    private QueryDecoratorFactory() {
    }

    /**
     * Create a new QueryDecorator.
     */
    public static QueryDecorator getSearchSyntax() {
        return instance;
    }

    /**
     * The singleton
     */
    private static QueryDecorator instance;

    /**
     * The log stream
     */
    private static final Logger log = LoggerFactory.getLogger(QueryDecoratorFactory.class);

    /**
     * Setup the instance
     */
    static {
        try {
            instance = PluginUtil.getImplementation(QueryDecorator.class);
        } catch (IOException e) {
            log.error("create QueryDecorator failed", e);
        } catch (ClassCastException e) {
            log.error("create QueryDecorator failed", e);
        } catch (ClassNotFoundException e) {
            log.error("create QueryDecorator failed", e);
        } catch (InstantiationException e) {
            log.error("create QueryDecorator failed", e);
        } catch (IllegalAccessException e) {
            log.error("create QueryDecorator failed", e);
        }
    }
}
