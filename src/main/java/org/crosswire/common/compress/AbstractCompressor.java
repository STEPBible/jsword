package org.crosswire.common.compress;

import java.io.InputStream;

/**
 * A compressor provides the ability to compress and uncompress text.
 */
public abstract class AbstractCompressor implements Compressor {
    public AbstractCompressor(InputStream input) {
        this.input = input;
    }

    protected InputStream input;
}
