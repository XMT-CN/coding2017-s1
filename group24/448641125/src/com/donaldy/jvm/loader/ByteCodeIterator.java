package com.donaldy.jvm.loader;

import com.donaldy.jvm.util.Util;

import java.util.Arrays;

public class ByteCodeIterator {

    byte[] codes;
    int pos = 0;

    ByteCodeIterator(byte[] codes) {
        this.codes = codes;
    }



    public byte[] getBytes(int len) {
        if (pos + len >= codes.length) {
            throw new ArrayIndexOutOfBoundsException();
        }

        byte[] data = Arrays.copyOfRange(codes, pos, pos + len);
        pos += len;
        return data;
    }

    public int nextU1toInt() {

        return Util.byteToInt(new byte[] { codes[pos++] });
    }

    public int nextU2ToInt() {
        return Util.byteToInt(new byte[] { codes[pos++], codes[pos++] });
    }

    public int nextU4ToInt() {
        return Util.byteToInt(new byte[] { codes[pos++], codes[pos++], codes[pos++], codes[pos++] });
    }

    public String nextU4ToHexString() {
        return Util.byteToHexString((new byte[] { codes[pos++], codes[pos++], codes[pos++], codes[pos++] }));
    }

    public String nextUxToHexString(int len) {
        byte[] tmp = new byte[len];

        for (int i = 0; i < len; i++) {
            tmp[i] = codes[pos++];
        }
        return Util.byteToHexString(tmp).toLowerCase();

    }

    public void back(int n) {
        this.pos -= n;
    }

    ///////////////////////Backup//////////////////
    /*private byte[] codes;

    private int pointer = 0;

    public ByteCodeIterator(byte[] codes) {
        this.codes = codes;
    }

    public String nextU4ToHexString() {
        byte [] byteCodes = nextLenByte(4);

        return Util.byteToHexString(byteCodes);
    }

    public int nextU2ToInt() {
        byte [] byteCodes = nextLenByte(2);

        return Util.byteToInt(byteCodes);
    }

    public int nextU1toInt() {
        byte [] byteCodes = nextLenByte(1);

        return Util.byteToInt(byteCodes);
    }

    public byte[] getBytes(int len) {
        byte [] byteCodes = nextLenByte(len);

        return byteCodes;
    }

    private byte[] nextLenByte(int len) {
        if (this.pointer + len >= this.codes.length)
            throw new IndexOutOfBoundsException("codes.length : " + this.codes.length);

        byte [] byteCodes = new byte[len];

        for (int i = 0 ; i < len; ++i) {
            byteCodes[i] = this.codes[pointer ++];
        }

        return byteCodes;
    }*/
}
