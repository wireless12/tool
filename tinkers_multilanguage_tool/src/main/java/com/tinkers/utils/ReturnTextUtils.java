package com.tinkers.utils;

import com.tinkers.data.UseData;

import java.util.List;

public class ReturnTextUtils {
    public static void enAndJp(){
        while (true){
            System.out.println(UseData.getHr());
            System.out.println("请输入你需要翻译的中文(q退出)");
            System.out.println(UseData.getHr());
            String text = UseData.getSCANNER().next();
            if("q".equalsIgnoreCase(text)) {
                break;
            }
            BaiduApiUtils.useApi(text,"en");
            BaiduApiUtils.useApi(text,"jp");
            System.out.println(UseData.getHr());
            System.out.println("已经完成翻译");
        }
    }

    public static void autoInsertJson() {
        while (true) {
            System.out.println(UseData.getHr());
            System.out.println("请选择写入js文件所在的父文件夹");
            String path = IoUtils.chooseDirectory();
            System.out.println(UseData.getHr());
            if(path.equals("break")) {
                break;
            }
            System.out.println(UseData.getHr());
            System.out.println("请输入你需要写入的中文");
            System.out.println(UseData.getHr());
            String text = UseData.getSCANNER().next();
            System.out.println(UseData.getHr());
            System.out.println("请设置对应的标签名");
            System.out.println(UseData.getHr());
            String lable = UseData.getSCANNER().next();
            System.out.println(UseData.getHr());
            System.out.println("请设置对应的文件名");
            System.out.println(UseData.getHr());
            String fileName = UseData.getSCANNER().next();
            try {
                List<String> pathList = IoUtils.getAllPath(fileName,path);
                for (String str:pathList) {
                    System.out.println("写入文件" + str);
                    if(str.contains("/zh-CN/")) {
                        IoUtils.insertJson(str,lable,text);
                        continue;
                    }
                    if(str.contains("/en/")) {
                        IoUtils.insertJson(str,lable,BaiduApiUtils.getTextApi(text,"en"));
                    } else {
                        IoUtils.insertJson(str,lable,BaiduApiUtils.getTextApi(text,"jp"));
                    }
                }
                if(!pathList.isEmpty()){
                    System.out.println(UseData.getHr());
                    System.out.println("写入完毕(q:退出)");
                    System.out.println(UseData.getHr());
                } else {
                    System.out.println(UseData.getHr());
                    System.out.println("未找到文件,写入失败(q:退出)");
                    System.out.println(UseData.getHr());
                }
                String out = UseData.getSCANNER().next();
                if("q".equalsIgnoreCase(out)){
                    break;
                }
            } catch (Exception e) {
                System.out.println(UseData.getHr());
                System.out.println("写入时异常,异常如下");
                throw new RuntimeException(e);
            }
        }
    }

    public void enAndJpToJS(){

        while (true){

        }
    }
}
