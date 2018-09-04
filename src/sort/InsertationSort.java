package sort;

import java.util.Arrays;

public class InsertationSort {

    public int[] insertationSort(int[] arr,int start,int end){
        for(int i=start;i<end;i++){
            int t =arr[i];
            int j;
            for(j=i;j>0&&arr[j-1]>t;j--){
                    arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
        return arr;
    }

    public static void main(String[] args){
        InsertationSort insert = new InsertationSort();
        int[] arr =GetRandomArray.getNearlyOrderArray(1000000);
        int[] arr1=Arrays.copyOf(arr,1000000);
        Long start =System.currentTimeMillis();
        insert.insertationSort(arr,0,arr.length-1);
        Long end =System.currentTimeMillis();
        System.out.println(end-start);
        Long start1 =System.currentTimeMillis();
        QuickSort.quickSort(arr1);
        Long end1 =System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
