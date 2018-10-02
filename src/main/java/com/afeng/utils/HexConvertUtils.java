package com.afeng.utils;

/**
 * 将二进制转换为十六进制
 *
 * @author afeng
 * @date 2018/10/2 10:18
 **/
public class HexConvertUtils
{
    public static String bytesToHex(byte[] bytes)
    {
        StringBuffer hexStr = new StringBuffer();
        int num;
        for (int i = 0; i < bytes.length; i++)
        {
            num = bytes[i];
            if (num < 0)
            {
                num += 256;
            }
            if (num < 16)
            {
                hexStr.append("0");
            }
            hexStr.append(Integer.toHexString(num));
        }
        return hexStr.toString().toUpperCase();
    }

    public static void main(String[] args)
    {
        String name="wangafeng";
        String encrpy=bytesToHex(name.getBytes());
        System.out.println(encrpy);
    }

}
