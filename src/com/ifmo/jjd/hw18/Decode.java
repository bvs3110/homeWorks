package com.ifmo.jjd.hw18;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Decode extends FilterInputStream {
    /**
     * Creates a {@code FilterInputStream}
     * by assigning the  argument {@code in}
     * to the field {@code this.in} so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or {@code null} if
     *           this instance is to be created without an underlying stream.
     */
    protected Decode(InputStream in) {
        super(in);
    }

    @Override
    public int read(byte[] b) throws IOException {
        int result = super.read(b);
        byte[] myKey = "Testing some Encryption".getBytes(StandardCharsets.UTF_8);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ myKey[i % myKey.length]);
        }
        return result;
    }

}
