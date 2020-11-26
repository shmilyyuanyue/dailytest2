package DongTaiGuiHua;

public class Test1 {
    /*

     */
    int MaxSum(int a[],int n){
        int nStart=a[n-1];
        int nAll=a[n-1];
        for(int i=n-2;i>=0;i--){
            if(nStart<0)
                nStart=0;
            nStart+=a[i];
            if(nStart>nAll)
                nAll=nStart;
        }
        //特殊情况的处理：当数组中所有的值都是负数时，则取当前数组的最大值
            if(nAll==0) {
                    nAll = a[0];
                    for(int i=1; i<a.length;i++)//我补的
                    if(a[i]>nAll)
                        nAll=a[i];
            }

        return nAll;
    }

}
