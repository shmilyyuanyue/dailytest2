package heapsort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
 
/**
 * Created by violetMoon on 2016/4/20.
 */
public class HeapSort <T extends Comparable<? super T>> {
 
    private List<T> sortResult;
    private int maxNum;
    private boolean isSelectMax;
 
    public HeapSort(int maxNum) {
        this(maxNum, true);
    }
 
    public HeapSort(int maxNum, boolean selectMax) {
        sortResult = new ArrayList<>(maxNum);
        this.maxNum = maxNum;
        isSelectMax = selectMax;
    }
 
    public void sort(T[] datas) {
        for (T data: datas)
            insert(data);
    }
 
    private void insert(T data) {
        if (sortResult.size() == 0) {
            sortResult.add(data);
            return;
        }
 
        T min = sortResult.get(0);
        if (sortResult.size() == maxNum) {
            int cmp = data.compareTo(min);
            if (isSelectMax) {
                if (cmp < 0) //选最大的时候需要维护一个最小堆
                    return;
                else {
                    sortResult.set(0, data);
                    pearDown(0);
                }
            } else {
                if (cmp > 0) //选最小的时候需要维护一个最大堆
                    return;
                else {
                    sortResult.set(0, data);
                    pearDown(0);
                }
            }
        } else {
            sortResult.add(data);
            pearUp(sortResult.size() - 1);
        }
    }
 
    private void pearUp(int index) {
        int curIndex = index;
        T upData = sortResult.get(curIndex);
        while (curIndex != 0) {
            int fatherIndex = (curIndex - 1) / 2;
            T father = sortResult.get(fatherIndex);
            int cmp = father.compareTo(upData);
            if (isSelectMax) {
                if (cmp > 0) { //选最大的时候需要维护一个最小堆
                    sortResult.set(curIndex, father);
                    curIndex = fatherIndex;
                    continue;
                } else
                    break;
            } else {
                if (cmp < 0) { //选最小的时候需要维护一个最大堆
                    sortResult.set(curIndex, father);
                    curIndex = fatherIndex;
                    continue;
                } else
                    break;
            }
        }
        sortResult.set(curIndex, upData);
    }
 
    private void pearDown(int index) {
        int curIndex = index;
        T downData = sortResult.get(curIndex);
        while (true) {
            int leftChildIndex = 2 * curIndex + 1;
            T leftChild = leftChildIndex < sortResult.size()? sortResult.get(leftChildIndex): null;
            int rightChildIndex = 2 * curIndex + 2;
            T rightChild = rightChildIndex < sortResult.size()? sortResult.get(rightChildIndex): null;
            int candidateChildIndex;
            T candidateChild;
            if (leftChild != null && rightChild != null) {
                if (isSelectMax) {
                    candidateChild = leftChild.compareTo(rightChild) < 0 ? leftChild : rightChild;
                    candidateChildIndex = candidateChild == leftChild ? leftChildIndex : rightChildIndex;
                } else {
                    candidateChild = leftChild.compareTo(rightChild) > 0 ? leftChild : rightChild;
                    candidateChildIndex = candidateChild == leftChild ? leftChildIndex : rightChildIndex;
                }
            } else if (leftChild != null && rightChild == null) {
                candidateChildIndex = leftChildIndex;
                candidateChild = leftChild;
            } else {
                break;
            }
 
            int cmp = downData.compareTo(candidateChild);
            if (isSelectMax) {
                if (cmp > 0) { //选最大的时候需要维护一个最小堆
                    sortResult.set(curIndex, candidateChild);
                    curIndex = candidateChildIndex;
                    continue;
                } else {
                    break;
                }
            } else {
                if (cmp < 0) { //选最小的时候需要维护一个最大堆
                    sortResult.set(curIndex, candidateChild);
                    curIndex = candidateChildIndex;
                    continue;
                } else {
                    break;
                }
            }
        }
 
        sortResult.set(curIndex, downData);
    }
 
    public boolean hasNext() {
        return sortResult.size() != 0;
    }
 
    public T getNext() {
        T min = sortResult.get(0);
        if (sortResult.size() > 1) {
            int size = sortResult.size();
            sortResult.set(0, sortResult.get(size - 1));
            sortResult.remove(size - 1);
            pearDown(0);
        } else
            sortResult.clear();
        return min;
    }
 
    public static void main(String[] args) {
        HeapSort<Integer> sorter = new HeapSort<>(6, true);
        Integer[] datas = new Integer[15];
 
        Random random = new Random(System.currentTimeMillis());

        for (int i=0; i<datas.length; ++i)
            datas[i] = random.nextInt(100000);
        sorter.sort(datas);
 


        while (sorter.hasNext())
            System.out.println(sorter.getNext());
    }
}