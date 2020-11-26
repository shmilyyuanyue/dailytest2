package test;

public class Test4 {
    /*
    定一个字符串的格式如下：(a,(b,1),(2,(c,a),5))，括号内的元素可以是任意的数字或字母，
    也可以是一个括号。请实现一个算法用于消除表达式内嵌套的括号，例如将上面的表达式变为
    (a,b,1,2,c,a,5)，如果表达式有误请报错。
     */
    public static void main(String[] args) {

    }

    public static String m1(String str){
        String str1 = "";
        String[] strArr = str.split("(");
        for (String str3:strArr
             ) {
            if (str3.contains(")")){
                String[] strArr2 = str3.split(")");
                String str5 = "";
                for (String str4:strArr2
                     ) {
                    str5 += str4;
                }
                str3 = str5;
            }
            str +=str3;
        }
        return str1;
    }
}
