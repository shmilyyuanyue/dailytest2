package com.shmily.dailytest;

public class Test {
    public static void main(String[] args) {
        Class clz = Methods.class;
        try {
//            java.lang.reflect.Method md = clz.getMethod("a");
//            md.setAccessible(true);
//            md.invoke(clz.newInstance());
//
//            java.lang.reflect.Method md2 = clz.getDeclaredMethod("c", String.class);
//            md2.setAccessible(true);
//            md2.invoke(clz.newInstance(),"yanqingyue");

            java.lang.reflect.Constructor con = clz.getConstructor();
            Methods m = (Methods) con.newInstance();
            m.a();
            m.b();
            m.c("yanqingyue");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
