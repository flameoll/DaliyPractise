package sort;

public class IndexMaxHeapTest {
    public static void main(String[] args){
        IndexMaxHeap heap = new IndexMaxHeap(100);

        heap.push(1,88);
        heap.push(100,89);
        while(!heap.isEmpty()){
            System.out.println(heap.poll());
        }
    }
}
