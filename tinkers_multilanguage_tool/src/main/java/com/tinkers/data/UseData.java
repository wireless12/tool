package com.tinkers.data;

import java.util.Scanner;

/**
 * @author 覃汉宇
 * @date 2023/09/18/22:28
 * @brief
 */
public class UseData {
    private static final String TRANS_API_HOST = "https://fanyi-api.baidu.com/api/trans/vip/translate";
    private static final String APPID = "20230918001821403";
    private static final String SECURITY_KEY = "geGl2B6RrKdE1QqiKPzy";
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String HR ;

    public static String getTransApiHost() {
        return TRANS_API_HOST;
    }

    public static String getAPPID() {
        return APPID;
    }

    public static String getSecurityKey() {
        return SECURITY_KEY;
    }

    public static Scanner getSCANNER() {
        return SCANNER;
    }

    public static String getHr(){
        if(HR==null){
            if(System.getProperty("os.name").startsWith("Windows")) {
                HR = "============================";
            } else {
                HR = "████████████████████████████";
            }
        }
        return HR;
    }
}
