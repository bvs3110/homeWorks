package com.ifmo.jjd.hw18;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Encode extends FilterOutputStream {
    /**
     * Creates an output stream filter built on top of the specified
     * underlying output stream.
     *
     * @param out the underlying output stream to be assigned to
     *            the field {@code this.out} for later use, or
     *            {@code null} if this instance is to be
     *            created without an underlying stream.
     */
    public Encode(OutputStream out) {
        super(out);
    }

    @Override
    public void write(byte[] b) throws IOException {
        byte[] myKey = "Testing some Encryption".getBytes("UTF-8");
        byte[] res = new byte[b.length];
        for (int i = 0; i < b.length; i++) {
            res[i] = (byte) (b[i] ^ myKey[i % myKey.length]);
        }
        super.write(res);
    }
}
