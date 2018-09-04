package sort;

public class MaxHeap {
    private int[] arr;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        arr=new int[capacity+1];
        count=0;
        this.capacity=capacity;
    }
    public MaxHeap(int[] arr,int capacity){
        this.arr=new int[capacity+1];
        for(int i=0;i<arr.length;i++){
            this.arr[i+1]=arr[i];
        }
        count=capacity;
        this.capacity=capacity;
        int j=count/2;
        while(j>0){
            shiftDown(j);
            j--;
        }

    }

    public boolean isEmpty(){
        return count==0?true:false;
    }

    public void push(int n){
        assert count+1<=capacity;
        int j=count+1;
        arr[j]=n;
        while(j>1&&arr[j/2]<arr[j]){
            QuickSort.swap(arr,j,j/2);
            j=j/2;
        }
        count++;
    }
    public int poll(){
        int max=arr[1];
        int j=1;
        QuickSort.swap(arr,1,count);
        count--;
        shiftDown(j);
        return max;
    }

    private void shiftDown(int j) {
        if(2*j<=count){
            if(2*j+1<=count){
                if(arr[2*j]>arr[2*j+1]){
                    if(arr[2*j]>arr[j]){
                        QuickSort.swap(arr,j,2*j);
                        j=2*j;
                        shiftDown(j);
                    }
                }else{
                    if(arr[2*j+1]>arr[j]){
                        QuickSort.swap(arr,j,2*j+1);
                        j=2*j+1;
                        shiftDown(j);
                    }
                }
            }else{
                if(arr[j]<arr[2*j]){
                    QuickSort.swap(arr,j,2*j);
                    j=2*j;
                    shiftDown(j);
                }
            }
        }
    }

    public void printMaxHeap(){
        for(int i=1;i<count+1;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
