package com.afeng.utils;

import java.security.MessageDigest;

/**
 * @author afeng
 * @date 2018/10/2 10:15
 * <p>
 * 128位二进制
 * 转换为32位十六进制
 **/
public class MD5Utils
{
    public static String getMD5(String message)
    {
        String md5 = "";
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");//得到一个MD5算法对象
            byte[] messageByte = message.getBytes("UTF-8");
            byte[] md5Byte = messageDigest.digest(messageByte);
            md5 = HexConvertUtils.bytesToHex(md5Byte);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return md5;

    }

    public static void main(String[] args)
    {
        System.out.println(getMD5("wangafeng"));
    }
}
