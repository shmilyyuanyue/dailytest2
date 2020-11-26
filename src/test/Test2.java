package test;

import java.lang.reflect.Array;
import java.util.*;

public class Test2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int l = scan.nextInt();
        int[] arr = new int[l];
        for (int i=0;i<arr.length;i++){
            arr[i]=scan.nextInt();
        }
        int n = scan.nextInt();
        System.out.println(adds(arr,n));

    }

    public static int adds(int[] arr,int n){
        //去重
        List list = new ArrayList();
        for (int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        Set set = new HashSet(list);
        //判断最大最小是否有重复
        if (set.size()<2*n)
            return -1;

        list.clear();
        list.addAll(set);
        //排序我直接用list集合的sort方法了，这里是要考排序算法吗？（冒泡或者堆排也可以，考场紧急我就这么排了哈）
        //刚刚切屏本来想去看一下list的sort方法里面怎么写来着，没找到，还好我自己想起来了。
        list.sort(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return (int)o1-(int)o2;
            }
        });
        int small = 0;
        int big = 0;
        for (int y=0;y<n;y++){
            small += (int)list.get(y);
            big += (int)list.get(list.size()-1-y);
        }
        return small+big;
    }
}
