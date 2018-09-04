package sort;

public class HeapSort {
    public static void main(String[] args){
        int[] arr =GetRandomArray.getRandomArray(100000000,1000000);
        Long start =System.currentTimeMillis();
        heapSort(arr);
        Long end =System.currentTimeMillis();
        System.out.println((end-start)+"ms");

    }

    private static void heapSort(int[] arr) {
        int count =arr.length-1;
        int j=(count-1)/2;
        //整理数组,将其变为一个最大堆
        while(j>=0) {
            shiftDown(arr, j, count);
            j--;
        }
        while(true){
            //交换与count位置元素,将最大值置于末尾
            QuickSort.swap(arr, 0, count);
            //将数组减小,除去末尾最大数
            count--;
            if(count==0) break;
            j=0;
            //重新整理[0,count]
            shiftDown(arr,j,count);
        }
    }

    private static void shiftDown(int[] arr, int j,int count) {
        if(2*j+1<=count){
            if(2*j+2<=count){
                if(arr[2*j+1]>arr[2*j+2]){
                    if(arr[2*j+1]>arr[j]){
                        QuickSort.swap(arr,j,2*j+1);
                        j=2*j+1;
                        shiftDown(arr,j,count);
                    }
                }else{
                    if(arr[2*j+2]>arr[j]){
                        QuickSort.swap(arr,j,2*j+2);
                        j=2*j+2;
                        shiftDown(arr,j,count);
                    }
                }
            }else{
                if(arr[j]<arr[2*j+1]){
                    QuickSort.swap(arr,j,2*j+1);
                    j=2*j+1;
                    shiftDown(arr,j,count);
                }
            }
        }
    }

}
