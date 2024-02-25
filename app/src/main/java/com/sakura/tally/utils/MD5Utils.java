package com.sakura.tally.utils;

import java.security.MessageDigest;

public class MD5Utils {

    public static String digest(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                //负数转换成正数
                int c = b & 0xff;
                //把十进制的数转换成十六进制的书
                String result = Integer.toHexString(c);
                if (result.length() < 2) {
                    //让十六进制全部都是两位数
                    sb.append(0);
                }
                sb.append(result);
            }
            //返回加密后的密文
            return sb.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
