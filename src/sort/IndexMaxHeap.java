package sort;

public class IndexMaxHeap {
    private int[] index;
    private int[] data;
    private int count;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        index=new int[capacity+1];
        data = new int[capacity+1];
        count=0;
        this.capacity=capacity;
    }
    public IndexMaxHeap(int[] index, int capacity){
        this.index=new int[capacity+1];
        for(int i=0;i<index.length;i++){
            this.index[i+1]=index[i];
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
    public int size(){return count;}

    public void push(int n,int item){
        assert count+1<=capacity;
        assert n<=capacity;
        int j=count+1;
        index[j]=n;
        data[n]=item;
        while(j>1&&data[index[j/2]]<data[index[j]]){
            QuickSort.swap(index,j,j/2);
            j=j/2;
        }
        count++;
    }
    public int poll(){
        int max=data[index[1]];
        int j=1;
        QuickSort.swap(index,1,count);
        count--;
        shiftDown(j);
        return max;
    }

    private void shiftDown(int j) {
        while(2*j<=count){
            int k =2*j;
            if(k+1<=count&&data[index[k]]<data[index[k+1]]){
                if(data[index[j]]<data[index[k+1]]){
                    QuickSort.swap(index,j,k+1);
                    j=k+1;
               }
            }
            if(data[index[k]]<data[index[j]])
                break;
            QuickSort.swap(index,j,k);
            j=k;
        }
    }

    public void printMaxHeap(){
        for(int i=1;i<count+1;i++){
            System.out.println(data[index[i]]);
        }
    }

}
