package PowOfN;

/**
 * 计算输入的数 是否为N的次方
 */
public class PowOfN {
    /**
     * 通过位运算 计算是否为2的平方  2的N次方的平方都可以这么算
     * @param target
     * @return
     */
    public boolean powOfTwo(int target){
        int count = 1;
        while(target>count){
            count = count<<1;//1 计算2的平法  2 计算4的平方...
        }
        return count == target;
    }

    /**
     * 应用了 : x%2^n = x &(2^n-1)的性质     hashMap中元素定位时用到过
     * @param target
     * @return
     */
    public boolean powOfTwoOptimize(int target){
        return target>=1&&((target&(target-1))==0);
    }
    public boolean powOf4Optimize(int target){
        return target>=1&&((target&(target-1))==0)&&((target&0x55555555)!= 0);
    }
    public boolean commonPowOfN(int target,int powNum){
        while(target>1){
            if(target%powNum != 0) return false;
            target/=powNum;
        }
        return target == 1;
    }

    public static void main(String[] args){
        PowOfN powOfN = new PowOfN();
//        System.out.println(powOfN.commonPowOfN(9, 3));
//        System.out.println(powOfN.powOf4Optimize(4));
    }
}
