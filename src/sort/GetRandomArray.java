package sort;

import java.util.Random;

public class GetRandomArray {

    public static int[] getRandomArray(int n,int max){
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i]= (int) (Math.random()*max+1);
        }
        System.out.println("RandomArray;Size="+n+";Range:[0,"+max+"]");
        return arr;
    }
    public static int[] getNearlyOrderArray(int n){
        int[] arr =new int[n];
        for(int i=1;i<=n;i++){
            arr[i-1]=i;
        }
        swapArray(arr,5);
        System.out.println("NearlyOrderRandomArray;Size="+n);
        return arr;
    }
    public static int[] getMoreRepatetableArray(int n){
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i]= (int) (Math.random()*10)+1;
        }
        System.out.println("MoreRepatetableArray:Size"+n);
        return arr;
    }
    public static void swapArray(int[] arr,int n){
        for(int i=1;i<=n;i++){
            Random random = new Random();
            int j=random.nextInt(arr.length);
            int k=random.nextInt(arr.length);
            swap(arr,j,k);
        }
    }
    public static void swap(int[] arr,int n,int i){
        int temp=arr[n];
        arr[n]=arr[i];
        arr[i]=temp;
    }
}
