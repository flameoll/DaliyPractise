
package src.StringAllArray;

/**
 * 今天看了个讲算法的视频,关于字符串全排列这块,算法很棒,所以记录下
 * String s = "1234";  求出这个字符串的全排列你会怎么做?
 * 分为了 有重复数据 和 没有重复数据
 * 思路:
 * 1:234 1作为开头   后面子串排列
 * 2:134 2作为开头   后面子串排列
 * 3:124
 * 4:123
 * 有重复:  "1224"
 * 1:224
 * 2:124  2是重复
 * 4:122
 * 2018.9.5
 */
public class AllArray4String {
    /**
     * 字符串全排列
     * @param s
     * @param from
     * @param to
     */
    public  void  array(String s,int from , int to){
        assert s!=null;
        if(from == to){//输出 排列后的字符串
            System.out.println(s);
            return;
        }

        for (int i = from; i <=to ; i++) {
            if (isRepeat(s,from,i))//去重步骤 :判断i 之前是否已经有相同数据 做个开头了
                continue;
            s = swap(s,from , i);    //交换 首位 i=from=0  1234->1234
                                    // i = 1   1234 ->2134 ...
            array(s,from+1,to);

            s = swap(s,i,from);     //重点:在经历过递归后,s已不再是"1234" 这一步是将 s 还原成"1234"
        }
    }

    private boolean isRepeat(String s,int from , int i) {
        if (i == 0) return false;
        for(int x = from;x<i;x++){
            if (s.charAt(i) == s.charAt(x))
                return true;
        }
        return false;
    }

    private String swap(String s, int from, int i) {
        char[] chars = s.toCharArray();
        char temp = chars[from];
        chars[from] = chars[i];
        chars[i] = temp;
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            sb.append(aChar);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        AllArray4String allArray4String = new AllArray4String();
//        allArray4String.array("1334",0,3);
        System.out.println("------------");
        allArray4String.array("12345",0,4);
    }
}
