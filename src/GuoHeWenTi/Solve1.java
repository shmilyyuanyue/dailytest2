package GuoHeWenTi;

import java.util.Arrays;
import java.util.Scanner;

public class Solve1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 读取人数
        int[] nums = new int[n+1];
        Arrays.sort(nums);
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }
        int result = 0;
        int stay = n;
        while(stay > 3){
            if(nums[1] + nums[stay-1] > 2*nums[2]) {
                // 第二种方案
                result += 2*nums[2] + nums[stay] + nums[1];
            } else {
                // 第一种方案
                result += 2*nums[1] + nums[stay] + nums[stay-1];
            }
            stay -= 2;
        }
        if (stay == 3){
            result += (nums[1] + nums[2] + nums[3]);
        } else {
            result += (nums[2]);
        }
        System.out.println("最短时间： " + result);
    }


}
