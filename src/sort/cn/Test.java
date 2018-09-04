package sort.cn;

public class Test {
    public static  void main(String[] args){
    /*    String s ="faabbccdde";
        List<Integer> list = new ArrayList<>();
        int count =1;
        for (int i=0;i<s.length();i++){
            if(i<s.length()-1&&s.charAt(i)==s.charAt(i+1)){
                if(i!=0&&s.charAt(i)!=s.charAt(i-1)) count=1;
                count++;
                continue;
            }
            if(i==s.length()-1&&s.charAt(i)==s.charAt(i-1)) {
                list.add(count);
                break;
            }
            if(i!=0&&s.charAt(i)!=s.charAt(i-1)) {
                count = 1;
            }
            list.add(count);
        }

        double sum=0;
        for(Integer num:list){
            sum+=num;
        }
        System.out.println(sum/list.size());*/
        MergeSort ms = new MergeSort();
        int[] arr ={5,7,11,13,12,1,4,2,3,6,10,9};
        ms.mergeSort(arr);
        for (int s:arr
             ) {
            System.out.print(s+" ");
        }
    }
}
