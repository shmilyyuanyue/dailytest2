package LiangGeShuZuHeBing;

public class Solves {
    //两个数组合并问题
    public  int[] sortAndconnectArr(int FirstArr[], int SecondArr[]){
        int[] ResultArr=new int[FirstArr.length+SecondArr.length];
        //若两个Arr中其中一个Arr的都比另一个大，则能直接合成
        if(FirstArr[FirstArr.length-1]<SecondArr[0]){
            ResultArr=connectArr(FirstArr,SecondArr);
            return ResultArr;
        }
        if(SecondArr[SecondArr.length-1]<FirstArr[0]){
            ResultArr=connectArr(SecondArr,FirstArr);
            return ResultArr;
        }
        //取FirstArr的第一个元素与SecondArr的第一个元素比较
        //小的一方，放入ResultArr,并使其索引+1，继续比较，直到最后
        int IndexOfFArr=0;
        int IndexOfSArr=0;
        int IndexOfRArr=0;
        while (IndexOfFArr<=FirstArr.length-1||IndexOfSArr<=SecondArr.length-1){
            if(FirstArr[IndexOfFArr]<SecondArr[IndexOfSArr]){
                ResultArr[IndexOfRArr]=FirstArr[IndexOfFArr];
                IndexOfFArr++;
            }else {
                ResultArr[IndexOfRArr]=SecondArr[IndexOfSArr];
                IndexOfSArr++;
            }

            //其中一方的数组已经全部遍历，将余下的数组部分写入ResultArr
            //全部遍历完毕则因为IndexOfXX++的原因应该是正好等于Arr.Length
            if(IndexOfFArr>FirstArr.length-1){
                ResultArr=addArr(ResultArr,IndexOfRArr+1,SecondArr,IndexOfSArr);
                return ResultArr;
            }
            if(IndexOfSArr>SecondArr.length-1){
                ResultArr=addArr(ResultArr,IndexOfRArr+1,FirstArr,IndexOfFArr);
                return ResultArr;
            }
            IndexOfRArr++;
        }
        return ResultArr;
    }
    public  int[] connectArr(int FirstArr[], int SecondArr[]){
        int[] ResultArr=new int[FirstArr.length+SecondArr.length];
        System.arraycopy(FirstArr, 0, ResultArr, 0, FirstArr.length);
        System.arraycopy(SecondArr, 0, ResultArr, FirstArr.length, SecondArr.length);
        return ResultArr;
    }

    public  int[] addArr(int ResultArr[],int RArrIndex,int AddArr[],int AArrIndex){
        while(AArrIndex<=AddArr.length-1){
            ResultArr[RArrIndex]=AddArr[AArrIndex];
            AArrIndex++;
            RArrIndex++;
        }
        return ResultArr;
    }
}
