package org.crosswire.common.compress;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/**
 * GZip manages the compression and uncompression of GZip data.
 */
public class Gzip extends AbstractCompressor {
    /**
     * Create a GZip that is capable of transforming the input.
     * 
     * @param input
     *            to compress or uncompress.
     */
    public Gzip(InputStream input) {
        super(input);
    }

    /* (non-Javadoc)
     * @see org.crosswire.common.compress.Compressor#compress()
     */
    public ByteArrayOutputStream compress() throws IOException {
        BufferedInputStream in = new BufferedInputStream(input);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        CompressorOutputStream out = new GzipCompressorOutputStream(bos);
        IOUtils.copy(in, out);
        in.close();
        out.flush();
        out.close();
        return bos;
    }

    /* (non-Javadoc)
     * @see org.crosswire.common.compress.Compressor#uncompress()
     */
    public ByteArrayOutputStream uncompress() throws IOException {
        return uncompress(BUF_SIZE);
    }

    /* (non-Javadoc)
     * @see org.crosswire.common.compress.Compressor#uncompress(int)
     */
    public ByteArrayOutputStream uncompress(int expectedLength) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream(expectedLength);
        CompressorInputStream in = new GzipCompressorInputStream(input);
        IOUtils.copy(in, out);
        in.close();
        out.flush();
        out.close();
        return out;
    }

}
