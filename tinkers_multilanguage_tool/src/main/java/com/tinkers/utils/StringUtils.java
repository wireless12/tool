package com.tinkers.utils;

import cn.hutool.core.text.UnicodeUtil;

public class StringUtils {

    public static String substringBetween (String str,String start,String end) {
        int startIndex = -1;
        int endIndex = 0;
        for (int i = 0; i <  str.length(); i++) {
            if (startIndex==-1 && start.charAt(0) == str.charAt(i)) {
                startIndex = i + 1;
            } else if (startIndex != -1 && end.charAt(0) == str.charAt(i)) {
                endIndex = i;
            }
        }
        return str.substring(startIndex,endIndex);
    }
}
