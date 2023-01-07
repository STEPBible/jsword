package org.crosswire.common.compress;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * A compressor provides the ability to compress and uncompress block text.
 * Implementing classes are expected to provide a way to supply the input.
 */
public interface Compressor {
    /**
     * The size to read/write when unzipping a compressed byte array of unknown
     * size.
     */
    int BUF_SIZE = 2048;

    /**
     * Compresses the input and provides the result.
     * 
     * @return the compressed result
     */
    ByteArrayOutputStream compress() throws IOException;

    /**
     * Uncompresses the input and provides the result.
     * 
     * @return the uncompressed result
     */
    ByteArrayOutputStream uncompress() throws IOException;

    /**
     * Uncompresses the input and provides the result.
     * 
     * @param expectedLength
     *            the size of the result buffer
     * @return the uncompressed result
     */
    ByteArrayOutputStream uncompress(int expectedLength) throws IOException;
}
