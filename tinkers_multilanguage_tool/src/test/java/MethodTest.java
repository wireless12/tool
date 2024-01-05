import com.tinkers.api.UseBaiduAPI;
import com.tinkers.utils.BaiduApiUtils;

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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * @author 覃汉宇
 * @date 2023/09/18/22:29
 * @brief
 */
public class MethodTest {
public static void main(String[] args) throws Exception {
//    space();
    System.out.println(new Date().getTime());
//    int [] height = {0,1,0,2,1,0,1,3,2,1,2,1};
//    System.out.println(maxArea(height));

//    JFileChooser chooser = new JFileChooser();
//    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);//设置只能选择目录
//    int returnVal = chooser.showOpenDialog(null);
//    String selectPath =null;
//    if(returnVal == JFileChooser.APPROVE_OPTION) {
//        selectPath =chooser.getSelectedFile().getPath() ;
//        System.out.println ( "你选择的目录是：" + selectPath );
//        List<String> lss= getAllPath(selectPath);
//        for (String asd:lss
//             ) {
//            System.out.println(asd);
//            if(asd.contains("/zh-CN/")) {
//                System.out.println("简体中文");
//                addJson(asd,"setWeight","权限设置");
//                continue;
//            }
//            if(asd.contains("/en/")) {
//                addJson(asd,"setWeight",BaiduApiUtils.getTextApi("权限设置","en"));
//                System.out.println("English");
//            } else {
//                addJson(asd,"setWeight",BaiduApiUtils.getTextApi("权限设置","jp"));
//                System.out.println("霓虹语");
//            }
//        }
//        chooser.hide();
    }
//    System.out.println(passThePillow(33,218));;
//    addJson("123");
//    BaiduApiUtils.outEnAndJp(text);
//    @Test
//    public void test() {
//        System.out.println("1111");
//        Scanner scanner = new Scanner(System.in);
//        String text = scanner.next();
////        BaiduApiUtils.outEnAndJp(text);
//    }
//
//    @Test
//    public void a () {
//        new File("./a.js");
//    }
//
//    @Test
//    public void getJsFile(){
//
//    }
    static List<String> getAllPath(String path) {
        File directory = new File(path);
        File [] files = null;
        List<String> objects = new ArrayList<>();
        if(directory.isDirectory()) {
          files = directory.listFiles();
        }
        for (File ff:files
             ) {
            if (ff.isFile()) {
                if(ff.getName().equals("a.js")) objects.add(ff.getPath());
            } else if (ff.isDirectory()) {
                objects.addAll(getAllPath(ff.getPath()));
            }
        }
        return objects;
    }
    public static int trap(int[] height) {
        int num = 0;
        int total = 0;
        while (num != height.length -1) {
            if(height[num] <= 0) {
                num++;
            }
            for (int i = 0; i < height.length; i++) {
                if(i>num && height[num] <= height[i]) {
                    num++;
                } else if(i - num - 1 > 0) {
                    for (int j = num; j < i; j++) {

                    }
                }
            }
        }
        return 0;
    }
    static void addJson(String path,String title,String text) throws Exception{
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
        new FileWriter(path);
        temp.set(temp.size() - 3,temp.get(temp.size() - 3) + ",");
        temp.add(temp.size() - 2,"        "+title+": '"+text+"'");
        //下面按行读。我实现的其实就是变相的分行打印，如果有更好的方法请大家指教
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
    static boolean isPalindrome(int i) {
        if(i<0) {return false;}
        if(i > 2147483646){return false;}
        int bum = 1;
        int num = i;
        int total = 0;
        ArrayList<Integer> objects = new ArrayList<>();
        while (i >= 10) {
            objects.add(i%10);
            i/=10;
            bum++;
        }
        i = num;
        while(bum>0) {
            total += (int) (i / Math.pow(10, bum)%10);
            bum--;
        }
        System.out.println(total);
        return total == num;
    }
    static int maxArea(int[] h) {
        int start = h[0];
        int end = h[h.length -1];
        for (int i = 1; i < h.length ; i++) {
            if(start > h[i]) {
                start = i - 1;
                break;
            } else {
                start = h[i];
            }
        }
        for (int i = 2; i < h.length ; i++) {
            if(end > h[h.length - i]) {
                end = h.length - i + 1;
                break;
            } else {
                end = h[h.length - i];
            }
        }
        int total =0;
        for (int i = start + 1; i < end; i++) {
            if(h[i] < h[start]) {
                total =total + h[start] - h[i];
            } else {
                start=i;
            }
        }
        return total;
    }

    public static int passThePillow(int n, int time) {
        if((n - time) > 0) {
            return time + 1;
        } else {
            if(((time - (time%(n-1)))/(n -1))%2== 0) {
                return  time%(n-1) + 1;
            } else {
                return n -  time%(n-1);
            }
        }
    }

    public static void space(){
        String [] startWord = {"  one: {","    two: {","      three: {"};
        String [] spaceEnd = {"  },","    },","      },"};
        for (int i = 0; i < startWord.length; i++) {
            int spaceNum = 0;
            for (int j = 0; j < startWord[i].length(); j++) {
                if(startWord[i].charAt(j) == ' ') {
                    spaceNum++;
                }
            }
            System.out.println(startWord[i]);
            System.out.println(spaceEnd[spaceNum/2 - 1]);
        }
    }
}
