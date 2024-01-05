package com.tinkers.utils;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import com.tinkers.api.UseBaiduAPI;
import com.tinkers.data.UseData;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 覃汉宇
 * @date 2023/09/18/22:28
 * @brief
 */
public class BaiduApiUtils {

    private static String getText(String text){
        String [] arr = text.split(":");
        return StringUtils.substringBetween(arr[arr.length-1],"\"","\"");

    }

    public static String checkLoginData(String text,String language,String id,String key){
        return UnicodeUtil.toString(getText(UseBaiduAPI.getTranslateResult(text, "auto", language,id,key)));
    }
    /**
     *组件名称 + 中文
     */
    public static void useApi(String text,String language){
        System.out.println(UnicodeUtil.toString(getText(UseBaiduAPI.getTranslateResult(text, "auto", language))));
    }
    public static String getTextApi(String text,String language){
        return UnicodeUtil.toString(getText(UseBaiduAPI.getTranslateResult(text, "auto", language)));
    }

    public static void main(String[] args) {
        String res = getText(UseBaiduAPI.getTranslateResult("欢迎", "auto", "en"));
        System.out.println(UnicodeUtil.toString(res));
        res = getText(UseBaiduAPI.getTranslateResult("苹果", "auto", "jp"));
        System.out.println(UnicodeUtil.toString(res));
    }

}
