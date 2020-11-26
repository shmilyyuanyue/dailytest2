package test;

import java.util.ArrayList;
import java.util.List;

public class Test5 {
    public static void main(String[] args) {
        int[] arr = {8,4,1,6,7,4,9,6,4};
        System.out.println(sort(arr,arr.length));
    }
    public static int[] sort(int a[], int n)
    {
        int x;
        int i = 0;
        int j = n-1;
        while(i != j)
        {
            while( a[i]%2 == 1)
                i++;
            while (a[j]%2 == 0)
                j--;
            if(i < j)
            {
                x = a[i];
                a[i] = a[j];
                a[j] = x;
            }
        }
        return a;
    }
    public static int[] m1(int[] arr){
        int[] result = new int[arr.length];
        List list1 = new ArrayList();
        List<Integer> list2 = new ArrayList<Integer>();
        for (int i: arr
             ) {
            if (i%2==0){
                list1.add(i);
            }else {
                list2.add(i);
            }
        }
        for (int i=0;i<arr.length;i++){
            if (i< list1.size()){
                result[i] = (int)list1.get(i);
            }else {
                result[i] = list2.get(i - list1.size());
            }

        }
        return result;
    }
}
