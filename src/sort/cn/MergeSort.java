package sort.cn;

public class MergeSort {
    public int[] mergeSort(int[] arr){
        return __mergeSort(arr,0,arr.length-1);
    }

    private int[] __mergeSort(int[] arr, int left, int right) {
        if(left==right) return arr;
        int mid =left+(right-left)/2;
        __mergeSort(arr,left,mid);
        __mergeSort(arr,mid+1,right);
       return __merger(arr,left,right);

    }

    private int[] __merger(int[] arr, int left, int right) {
        int l=left;
        int mid =left+(right-left)/2;
        int r=mid+1;
        int[] merge_arr = new int[right-left+1];
        for(int i=left;i<=right;i++){
            merge_arr[i-left]=arr[i];
        }
        for(int i=left;i<=right;i++){
            if(r>right){
                arr[i]=merge_arr[l-left];
                l++;
            }else if(l>mid){
                arr[i]=merge_arr[r-left];
                r++;
            }else if(merge_arr[l-left]>merge_arr[r-left]){
                arr[i]=merge_arr[r-left];
                r++;
            }else{
                arr[i]=merge_arr[l-left];
                l++;
            }
        }
        return arr;
    }
}
