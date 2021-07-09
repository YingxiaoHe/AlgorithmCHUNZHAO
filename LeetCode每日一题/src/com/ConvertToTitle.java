package com;

/**
 * 168. Excel表列名称：https://leetcode-cn.com/problems/excel-sheet-column-title/
 */
public class ConvertToTitle {

    private static final int BASE = 26;

    public String convertToTitle(int columnNumber) {
        // 小于等于26时，直接返回一个字母
        if (columnNumber <= BASE) {
            return convert(columnNumber);
        }

        // 商
        int quotient = columnNumber / BASE;
        // 余数
        int remainder = columnNumber % BASE;

        if (remainder == 0) {
            return convertToTitle(quotient - 1) + convert(BASE);
        } else {
            return convertToTitle(quotient) + convert(remainder);
        }
    }

    private String convert(int number) {
        return String.valueOf((char) ('A' + number - 1));
    }

    public static void main(String[] args) {
        ConvertToTitle convertToTitle = new ConvertToTitle();
        System.out.println(convertToTitle.convertToTitle(10));
    }
}
