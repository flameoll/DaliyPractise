package redpackge;

import java.math.BigDecimal;

public class RedPackge  {
    private double left_money;
    private int count;
    private double[] sum;

    public RedPackge(double left_money,int count){
        this.left_money=left_money;
        this.count=count;
        sum=new double[count+1];
        sum[0]=left_money;
    }


    public static RedPackge createRedPackge(double left_money,int count){
        return new RedPackge(left_money,count);
    }

    public double getMoney() throws Exception {
        if(count==0){
            throw new Exception("红包已被抢光");
        }
        if(count==1){
            double total=0;
            for(int i=count+1;i<sum.length;i++){
                total=new BigDecimal(total).add(new BigDecimal(sum[i])).doubleValue();
            }
            BigDecimal bd = new BigDecimal(sum[0]).subtract(new BigDecimal(total));
            double last=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
            sum[count]=last;
            count--;
            return last;
        }
        double avg =left_money/count;
        double money =Math.random()*(2*avg-0.01)+0.01;
        BigDecimal bd = new BigDecimal(money);
        money=bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        sum[count]=money;
        count--;
        left_money-=money;
        return money;
    }

    public boolean checkMoney() {
        BigDecimal total= new BigDecimal(0);
        for(int i=1;i<sum.length;i++){
            total=total.add(new BigDecimal(sum[i]));
        }
        if(sum[0]==total.doubleValue()) return true;
        return false;
    }
}
