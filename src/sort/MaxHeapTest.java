package sort;

import java.util.Arrays;

public class MaxHeapTest {
    public static void main(String[] args){
        MaxHeap maxHeap = new MaxHeap(1000000);
        int[] arr =GetRandomArray.getRandomArray(1000000,1000000);
        int[] arr1 =Arrays.copyOf(arr,arr.length);
        Long start =System.currentTimeMillis();
        for(int i=0;i<arr.length;i++){
            maxHeap.push(arr[i]);
        }
        while(!maxHeap.isEmpty()){
            maxHeap.poll();
        }
        Long end=System.currentTimeMillis();
        System.out.println((end-start)+"ms");
        Long start1 =System.currentTimeMillis();
        MaxHeap maxHeap1 = new MaxHeap(arr1,1000000);
        while(!maxHeap1.isEmpty()){
            maxHeap1.poll();
        }
        Long end1=System.currentTimeMillis();
        System.out.println((end1-start1)+"ms");

    }
}
