package org.crosswire.common.compress;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorOutputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorInputStream;
import org.apache.commons.compress.compressors.bzip2.BZip2CompressorOutputStream;
import org.apache.commons.compress.utils.IOUtils;

/**
 * BZip2 manages the compression and uncompression of BZip2 data.
 */
public class BZip2 extends AbstractCompressor {
    /**
     * Create a BZip2 that is capable of transforming the input.
     * 
     * @param input
     *            to compress or uncompress.
     */
    public BZip2(InputStream input) {
        super(input);
    }

    /* (non-Javadoc)
     * @see org.crosswire.common.compress.Compressor#compress()
     */
    public ByteArrayOutputStream compress() throws IOException {
        BufferedInputStream in = new BufferedInputStream(input);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        CompressorOutputStream out = new BZip2CompressorOutputStream(bos);
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
        CompressorInputStream in = new BZip2CompressorInputStream(input);
        IOUtils.copy(in, out);
        in.close();
        out.flush();
        out.close();
        return out;
    }

}
