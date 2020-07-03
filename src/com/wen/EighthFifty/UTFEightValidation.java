package com.wen.EighthFifty;

public class UTFEightValidation {
    // Bit manipulation
    public static boolean validUtf8(int[] data) {
        if (data == null || data.length == 0) {
            return false;
        }
        int l = data.length;
        int mask = 0b11111111, idx = 0;
        while (idx < l) {
            int cur = data[idx] & mask;
            int start = (cur & 0b11111000) >> 3, byteCount = 0;
            if (start == 0b11110) {
                byteCount = 4;
            } else if (start >> 1 == 0b1110) {
                byteCount = 3;
            } else if (start >> 2 == 0b110) {
                byteCount = 2;
            } else if (start >> 4 == 0) {
                byteCount = 1;
            } else {
                return false;
            }
            while (--byteCount > 0) {
                if (++idx < l) {
                    int next = data[idx];
                    if ((next & 0b11000000) >> 6 != 0b10) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            idx++;
        }
        return true;
    }
}
