package com.tinkers.utils;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class IoUtils {
    private  static JFileChooser chooser = new JFileChooser();
    public static List<String> getAllPath(String fileName ,String path) throws Exception {
        File directory = new File(path);
        File [] files = null;
        List<String> filePaths = new ArrayList<>();
        if(directory.isDirectory()) {
            files = directory.listFiles();
        }
        for (File ff:files
        ) {
            if (ff.isFile()) {
                if(ff.getName().equals(fileName + ".js")) filePaths.add(ff.getPath());
            } else if (ff.isDirectory()) {
                filePaths.addAll(getAllPath(fileName,ff.getPath()));
            }
        }
        return filePaths;
    }
    public static String chooseDirectory () {
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//设置只能选择目录
        int returnVal = chooser.showOpenDialog(null);
        String selectPath =null;
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            selectPath =chooser.getSelectedFile().getPath() ;
            System.out.println ( "你选择的目录是：" + selectPath );
            return selectPath;
        } else {
            System.out.println ("你没有选择目录");
            return "break";
        }
    }

    public static void insertJson(String path,String lable,String text) throws Exception{
        List<String> temp = new ArrayList<>();
        File f = new File(path);
        InputStreamReader reader = new InputStreamReader(new FileInputStream(f),"utf8");
        BufferedReader br = new BufferedReader(reader);
        String str=null;
        while((str=br.readLine())!=null){
            temp.add(str);
        }
        br.close();
        reader.close();
        if(temp.get(temp.size()-3).contains("}")) {
            System.out.println("目前不支持该格式的文件插入");
            return;
        }
        new FileWriter(path);
        temp.set(temp.size() - 3,temp.get(temp.size() - 3) + ",");
        temp.add(temp.size() - 2,"        "+lable+": '"+text+"'");
        OutputStreamWriter os = new OutputStreamWriter(new FileOutputStream(path),"utf8");
        BufferedWriter bw = new BufferedWriter(os);
        PrintWriter out = new PrintWriter(bw);
        for(String aTemp:temp){
            out.println(aTemp);
        }
        bw.close();
        os.close();
        out.close();
    }

}
