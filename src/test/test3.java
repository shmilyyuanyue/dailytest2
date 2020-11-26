package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        List<String> list = new ArrayList<>();
        list.add(sc.next());
    }
    public static String parse1(String str){
        String str1 = "";
        if (str.substring(0,1).equals("#")){
            String str2 = str.substring(1,str.length());
            String[] strArr = str2.split("");
            for (int i=0;i<strArr.length;i++){
                if (strArr[i].equals("#"))
                    str1 +="#";
                if (strArr[i].equals("/"))
                    str1 +=" ";
                if (strArr[i].equals("0"))
                    str1 +="0";

                Integer.parseInt(strArr[i]);
                if (Integer.parseInt(strArr[i])==9&&Integer.parseInt(strArr[i])!=Integer.parseInt(strArr[i+1])){
                    str1 +="w";
                    if (isEqu(strArr[i],strArr[i+1])){
                        i++;

                    }
                }


            }
        }else {
            return str1=str;
        }
        return str1;
    }

    public static boolean isEqu(String str,String str1){
        return Integer.parseInt(str)==Integer.parseInt(str1);
    }
}
