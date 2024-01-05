package com.tinkers.login;

import com.tinkers.menu.UserMenu;
import com.tinkers.utils.BaiduApiUtils;

public class CheckLogin {
    public static void checkAppText(String id,String key){
        if(BaiduApiUtils.checkLoginData("欢迎","en",id,key).equals("welcome")){
            UserMenu.Menu();
        } else {
            System.out.println("登陆失败，开发者信息无效");
        }
    }
}
