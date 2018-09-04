package sort;

import java.util.Random;

public class QuickSort {
    public static void main(String[] args){
        /*int[] arr = GetRandomArray.getRandomArray(1000000, 100000);
        run(arr);
        long start_time=System.currentTimeMillis();
        quickSort3way(arr);
        long end_time=System.currentTimeMillis();
        System.out.println("quickSort3way:"+(+end_time-start_time)+"ms");
        int[] arr1 =GetRandomArray.getNearlyOrderArray(1000000);
        run(arr1);

        int[] arr2=GetRandomArray.getMoreRepatetableArray(100000000);
        long start_time1=System.currentTimeMillis();
        quickSort3way(arr1);
        long end_time1=System.currentTimeMillis();
        System.out.println("quickSort3way:"+(+end_time1-start_time1)+"ms");*/
        int[] arr =GetRandomArray.getRandomArray(10001,100000);
        long start_time=System.currentTimeMillis();
        int a=quickSort4N(arr,arr.length/2);
        long end_time=System.currentTimeMillis();
        System.out.println("quickSort4N:"+(+end_time-start_time)+"ms");
        System.out.println(a);
        long start_time1=System.currentTimeMillis();
        for (int n:arr
             ) {
            System.out.print(n+" ");

        }
    }
    public static void run(int[] arr){
        long start_time=System.currentTimeMillis();
        quickSort(arr);
        long end_time=System.currentTimeMillis();
        System.out.println("quickSort2way:"+(+end_time-start_time)+"ms");
    }
    //利用快速排序求数组中第N大的数,数据量1M,N=1000
    public static int quickSort4N(int[] arr,int n){
        if(n>arr.length) return -1;
        return __quickSort4N(arr,0,arr.length-1,arr.length-n);
    }

    private static int __quickSort4N(int[] arr, int left, int right, int n) {
        if(left==right) return arr[left];
        int l =left;
        int r =right;
        Random random = new Random();
        int rannum =random.nextInt(r-l)+l;
        swap(arr,l,rannum);
        int index =arr[l];
        while(l<r){
            while(l<r&&arr[r]>=index) r--;
            arr[l]=arr[r];
            while(l<r&&arr[l]<=index) l++;
            arr[r]=arr[l];
        }
        arr[r]=index;
        if(n>r) {
           return __quickSort4N(arr, r + 1, right,n);
        }else if(n<r){
           return __quickSort4N(arr,left,r-1,n);
        }

        return arr[r];

    }

    public static int[] quickSort3way(int[] arr){
        int left=0;
        int right=arr.length-1;
        return __quickSort3way(arr,left,right);

    }

    private static int[] __quickSort3way(int[] arr, int left, int right) {
        if(right-left<2) return arr;
        if(right-left<15) return new InsertationSort().insertationSort(arr,left,right);
        int l =left;
        int r =right;
        int i =l+1;
        Random random = new Random();
        int rannum =random.nextInt(r-l)+l;
        swap(arr,l,rannum);
        int index =arr[l];
        while(true){
            if(i==r) break;
            if(arr[i]>index){
                swap(arr,i,r);
                r--;
            }else if(arr[i]==index){
                i++;
            }else{
                swap(arr,l+1,i);
                l++;
                i++;
            }
        }
        swap(arr,left,l);
        __quickSort3way(arr,left,l-1);
        __quickSort3way(arr,r,right);
        return arr;
    }

    public static int[] quickSort(int[] arr){
        int left =0;
        int right=arr.length-1;
        return __quickSort(arr,left,right);
    }
    private static int[] __quickSort(int[] arr, int left, int right) {
        if(right==left)  return arr;
        if(right-left<15) return new InsertationSort().insertationSort(arr,left,right);
        int l =left;
        int r =right;
        Random random = new Random();
        int rannum =random.nextInt(r-l)+l;
        swap(arr,l,rannum);
        int index =arr[l];
        while(l<r){
            while(l<r&&arr[r]>=index) r--;
            arr[l]=arr[r];
            while(l<r&&arr[l]<=index) l++;
            arr[r]=arr[l];
        }
        arr[r]=index;
        if(r==left){
            __quickSort(arr,r+1,right);
            return arr;
        }else if(r==right){
            __quickSort(arr,left,r-1);
            return arr;
        }else {
            __quickSort(arr, left, r - 1);
            __quickSort(arr, r + 1, right);
            return arr;
        }
    }

    public static void swap(int[] arr,int n,int i){
        int temp=arr[n];
        arr[n]=arr[i];
        arr[i]=temp;
    }
}
