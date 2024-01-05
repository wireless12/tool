package com.tinkers.api;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpUtil;
import com.tinkers.data.UseData;

import java.util.HashMap;
import java.util.Map;

public class UseBaiduAPI {
    /**
     *
     * @param queryText 需要翻译的文本
     * @param from 翻译模式
     * @param chooseLanguage 选择翻译要成的语言
     * @return convertText 返回翻译后的文本
     */
    public static String getTranslateResult(String queryText, String from, String chooseLanguage) {
        Map<String, Object> params = new HashMap<>();
        params.put("q", queryText);
        params.put("from", from);
        params.put("to", chooseLanguage);
        params.put("appid", UseData.getAPPID());
        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        // 签名
        String src = UseData.getAPPID() + queryText + salt + UseData.getSecurityKey();
        // 加密前的原文
        params.put("sign", SecureUtil.md5(src));
        return HttpUtil.get(UseData.getTransApiHost(), params);
    }

    public static String getTranslateResult(String queryText, String from, String chooseLanguage,String id,String key) {
        Map<String, Object> params = new HashMap<>();
        params.put("q", queryText);
        params.put("from", from);
        params.put("to", chooseLanguage);
        params.put("appid", id);
        // 随机数
        String salt = String.valueOf(System.currentTimeMillis());
        params.put("salt", salt);
        // 签名
        String src = id + queryText + salt + key;
        // 加密前的原文
        params.put("sign", SecureUtil.md5(src));
        return HttpUtil.get(UseData.getTransApiHost(), params);
    }
}
