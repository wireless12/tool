package com.tinkers.menu;

import com.tinkers.data.UseData;
import com.tinkers.login.CheckLogin;
import com.tinkers.utils.IoUtils;

/**
 * @author 覃汉宇
 * @date 2023/09/19/1:07
 * @brief
 */
public class UserMenu {

    public static void indexMenu(){
        if(System.getProperty("os.name").startsWith("Windows")) {
            System.out.println("⠀⠀⠀⠀ ( ͡° ͜ʖ ͡°)⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀tinkers多语言转换工具⠀     " +
                    System.getProperty("os.name") +  " 版本o_O???⠀⠀⠀⠀⠀⠀⠀\n");
        } else {
            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣴⣶⣶⣶⣶⣦⣄⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⢀⡴⢋⣵⣶⡌⢿⣿⣿⡿⢡⣶⣮⣝⢦⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⢠⠟⢰⣿⣿⠿⠛⠀⠉⠉⠁⠚⠿⢿⣿⣆⠹⡄⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⢀⡟⠀⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣿⠀⢹⡄⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠸⣇⣠⣿⣿⣄⠀⡠⠀⠀⠀⠀⢄⠀⣠⣿⣿⣄⣨⠇⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠈⢹⣿⣿⣿⡏⠁⠀⠀⠀⠀⠀⢩⣿⣿⣿⡟⠁⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⡆⠀⠀⠀⠀⢠⣿⣿⣿⠟⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣿⣿⣷⣶⣿⣿⡿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠈⢹⠉⢸⡇⢸⣿⡇⢸⣼⠁⢸⣯⡅⢸⣽⡇⠸⣭⡁⠀⠀⠀⠀⠀\n" +
                    "⠀⠀⠀⠀⠀⠀⠘⠀⠘⠃⠘⠘⠃⠘⠈⠃⠘⠓⠂⠘⠀⠃⠘⠚⠃⠀⠀⠀⠀⠀\n" +
                    "⠀ tinkers多语言转换工具⠀   " +
                    System.getProperty("os.name") +  " 版本⠀⠀⠀⠀⠀⠀⠀\n");
        }

        while (true){
            System.out.println(UseData.getHr());
            System.out.println("        1.免登录模式");
            System.out.println("        2.开发者身份模式");
            System.out.println("        3.退出程序");
            System.out.println(UseData.getHr());
            ChooseService.indexChoose();
        }
    }

    public static void Menu() {
        while (true){
            System.out.println(UseData.getHr());
            System.out.println("        1.转换为日英两语");
            System.out.println("        2.仅转换为英语");
            System.out.println("        3.仅转换为日语");
            System.out.println("        4.退出程序");
            System.out.println(UseData.getHr());
            ChooseService.useApiChoose();
        }
    }
    public static void userLogin(){
        System.out.println(UseData.getHr());
        System.out.println("    请输入开发者APPID");
        String appId = UseData.getSCANNER().next();
        System.out.println(UseData.getHr());
        System.out.println("    请输入开发者密钥");
        String appKey = UseData.getSCANNER().next();
        System.out.println(UseData.getHr());
        CheckLogin.checkAppText(appId,appKey);
    }
}
