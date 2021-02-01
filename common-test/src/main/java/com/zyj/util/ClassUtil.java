package com.zyj.util;

public class ClassUtil {

    /**
     * 将类名首字母小写
     * @param str
     * @return
     */
    public static  String lowerFirstChar(String str){
        char [] chars = str.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }
}
