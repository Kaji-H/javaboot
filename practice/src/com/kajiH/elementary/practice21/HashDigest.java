package com.kajiH.elementary.practice21;

import java.math.BigInteger;
import java.security.MessageDigest;

public class HashDigest {
    // public static void main(String[] args) {
    //     HashDigest app = new HashDigest();
    //     String[] names = { "最強の戦士の血を引くもの", "伝説の勇者の友達", "" };

    //     for (int i = 0; i < names.length; i++) {
    //         System.out.printf("「%s」のハッシュ値は「%s」、数値は「%d」\n", names[i], app.getHashDigest(names[i]),
    //                 app.generateNumber(names[i], i));
    //     }
    // }

    public String getHashDigest(String name) {
        try {
            // ハッシュ値を取得する
            byte[] result = MessageDigest.getInstance("SHA-1").digest(name.getBytes());
            return String.format("%040x", new BigInteger(1, result));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int generateNumber(String name, int index) {
        try {
            String digest = getHashDigest(name);
            String hex = digest.substring(index * 2, index * 2 + 2);
            return Integer.parseInt(hex, 16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
