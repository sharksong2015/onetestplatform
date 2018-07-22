package com.shl.onetest.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author songhongli
 **/
public class MD5Util {
    private static final String SALT = "onetest";
    private static final String ALGORITH_NAME = "md5";
    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String pwd){
        String newPwd = new SimpleHash(ALGORITH_NAME, pwd, ByteSource.Util.bytes(SALT),HASH_ITERATIONS).toHex();
        return newPwd;
    }

    public static String encrypt(String userName,String pwd){
        String newPwd = new SimpleHash(ALGORITH_NAME, pwd, ByteSource.Util.bytes(userName.toLowerCase() + SALT),
                                            HASH_ITERATIONS).toHex();
        return newPwd;
    }

    public static void main(String[] args) {

        System.out.println(MD5Util.encrypt("sid", "123456"));
    }

}
