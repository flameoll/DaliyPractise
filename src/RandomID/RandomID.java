package RandomID;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomID {
    private static char[] c ={'_','/'};
    private static char[] cap={'A','B','C','D','E','F','G'};
    private static char[] lower={'a','b','c','d','e','f','g'};
    private static char[] num={'0','1','2','3','4','5','6','7','8','9'};
    private static StringBuilder result_sb;
    private static List<Integer> list;
    public static String getID(int n){
        list=null;
        result_sb= new StringBuilder();
        for(int i=0;i<n;i++){
            int k = new Random().nextInt(4);
            char c =getElement(k);
            result_sb.append(c);
        }
        return result_sb.toString();
    }
    //k表示从哪个数组获取元素
    private static char getElement(int k) {
        if(list==null) list = new ArrayList<>();
        if(list.size()>3&&(
                !list.contains(0)||!list.contains(1)||!list.contains(2)||!list.contains(3))){
            if (!list.contains(0)){
                list.add(0);
                return c[new Random().nextInt(2)];
            }
            if (!list.contains(1)){
                list.add(1);
                return cap[new Random().nextInt(7)];
            }
            if (!list.contains(2)){
                list.add(2);
                return lower[new Random().nextInt(7)];
            }
            if(!list.contains(3)){
                list.add(3);
                return num[new Random().nextInt(10)];
            }
        }
        list.add(k);
        if(k==0) return c[new Random().nextInt(2)];
        if(k==1) return cap[new Random().nextInt(7)];
        if(k==2) return lower[new Random().nextInt(7)];
        return num[new Random().nextInt(10)];
    }
}
