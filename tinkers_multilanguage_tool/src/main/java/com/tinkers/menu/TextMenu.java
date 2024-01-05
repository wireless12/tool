package com.tinkers.menu;

import com.tinkers.data.UseData;

public class TextMenu {
    public static void enAndJp() {
        Boolean flag = true;
        while (flag){
            System.out.println(UseData.getHr());
            System.out.println("   1.仅返回翻译后的文本内容");
            System.out.println("   2.翻译后把内容插入js文件");
            System.out.println("   3.返回");
            System.out.println(UseData.getHr());
            flag = ChooseService.enAndJpChoose();
        }
    }
}
