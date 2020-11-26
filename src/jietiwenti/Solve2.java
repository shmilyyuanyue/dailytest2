package jietiwenti;

import java.util.Scanner;

public class Solve2 {
    public static int jumpFloor(int target) {
        if(target<=0)
            return 0;
        if(target==1)
            return 2;
        if (target==2)
            return 2;

        int first = 1;
        int second = 2;
        int third = 0;
        for(int i = 3; i <= target; i++) {
            third = first + second;
            first = second;
            second = third;
        }
        return third;
    }
    public static void main(String[] args) {//1836311903
        Scanner scan=new Scanner(System.in);
        int target= scan.nextInt();
        System.out.println(jumpFloor(target));
    }
}

