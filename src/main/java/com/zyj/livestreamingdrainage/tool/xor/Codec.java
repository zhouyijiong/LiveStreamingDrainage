package com.zyj.livestreamingdrainage.tool.xor;

public final class Codec{
    public static String complex(String str, int offset) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; ++i) {
            chars[i] = (char) (((-chars[i] & 0xffff) + ((offset + i) % 0x20)) & 0xffff);
        }
        return new String(chars, 0, len);
    }
}