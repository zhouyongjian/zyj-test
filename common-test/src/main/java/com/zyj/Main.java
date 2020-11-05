package com.zyj;

public class Main {
    public static void main(String[] args) {

    }

    /**
     * 判断数字是否是二进制
     * @param val
     * @return
     */
    private static boolean isPowerOfTwo(int val) {
        return (val & -val) == val;
    }
}
