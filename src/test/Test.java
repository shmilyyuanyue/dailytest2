package test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(parse1(str));
    }
    public static String parse1(String str){
        //排除有大写字母情况
        if (!str.equals(str.toLowerCase()))
            return "!error";

        String str1 = "";
        char[] ch1 = str.toCharArray();
        for (int i=0;i<ch1.length ;i++){
            String str2 = "";
            if ((int)ch1[i]<97){
                int a = Integer.parseInt(String.valueOf(ch1[i]));
                char[] ch2 = new char[a];
                for (int y=0;y<a;y++){
                    ch2[i]=ch1[i+1];
                }
                str2 = ch2.toString();
            }else {
                str2 = String.valueOf(ch1[i]);
            }
            str1 +=str2;
        }

        return str1;
    }
}
