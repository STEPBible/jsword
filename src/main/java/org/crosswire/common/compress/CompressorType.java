package org.crosswire.common.compress;

import java.io.ByteArrayInputStream;

/**
 * An Enumeration of the possible Compressions.
 */
public enum CompressorType {
    ZIP {
        @Override
        public Compressor getCompressor(byte[] input) {
            return new Zip(new ByteArrayInputStream(input));
        }
    },

    LZSS {
        @Override
        public Compressor getCompressor(byte[] input) {
            return new LZSS(new ByteArrayInputStream(input));
        }
    },

    BZIP2 {
        @Override
        public Compressor getCompressor(byte[] input) {
            return new BZip2(new ByteArrayInputStream(input));
        }
    },

    GZIP {
        @Override
        public Compressor getCompressor(byte[] input) {
            return new Gzip(new ByteArrayInputStream(input));
        }
    },

    XZ {
        @Override
        public Compressor getCompressor(byte[] input) {
            return new XZ(new ByteArrayInputStream(input));
        }
    };

    /**
     * Get a compressor.
     * @param input the stream to compress or to uncompress.
     */
    public abstract Compressor getCompressor(byte[] input);

    /**
     * Get a CompressorType from a String
     * 
     * @param name the case insensitive representation of the desired CompressorType
     * @return the desired compressor or null if not found.
     */
    public static CompressorType fromString(String name) {
        for (CompressorType v : values()) {
            if (v.name().equalsIgnoreCase(name)) {
                return v;
            }
        }

        // cannot get here
        assert false;
        return null;
    }
}
