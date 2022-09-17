package com.zyj.livestreamingdrainage.tool.md5;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5
 */
public final class MD5 {
    private static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    private static String view(byte[] bytes) {
        StringBuilder hexValue = new StringBuilder();
        for (byte b : bytes) {
            int val = ((int) b) & 0xff;
            if (val < 16) hexValue.append(0);
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String encrypt(String str) {
        return view(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
    }
}