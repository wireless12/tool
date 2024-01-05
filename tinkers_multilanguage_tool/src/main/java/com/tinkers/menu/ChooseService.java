package com.tinkers.menu;

import com.tinkers.data.UseData;
import com.tinkers.utils.ReturnTextUtils;

/**
 * @author 覃汉宇
 * @date 2023/09/19/1:09
 * @brief
 */
public class ChooseService {
    private static String choose;
    public static void indexChoose(){
        choose = UseData.getSCANNER().next();
        switch (choose){
            case "1":
                UserMenu.Menu();
                break;
            case "2":
                UserMenu.userLogin();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("操作错误，输入任意字符返回主菜单");
                UseData.getSCANNER().next();
        }
    }

    public static void useApiChoose(){
        choose = UseData.getSCANNER().next();
        switch (choose){
            case "1":
                TextMenu.enAndJp();
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                System.exit(0);
                break;
            default:
                System.out.println("操作错误");
        }
    }

    public static Boolean enAndJpChoose() {
        choose = UseData.getSCANNER().next();
        switch (choose){
            case "1":
                ReturnTextUtils.enAndJp();
                return true;
            case "2":
                ReturnTextUtils.autoInsertJson();
                return true;
            case "3":
                return false;
            default:
                System.out.println("操作错误");
                return true;
        }
    }
}
