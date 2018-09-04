package redpackge;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MoreUserRedPackge extends Thread {
    private static RedPackge rp = RedPackge.createRedPackge(100,5);

    @Override
    public void run() {
        synchronized (rp) {
            try {
                Thread.sleep(1000);
                SimpleDateFormat sf = new SimpleDateFormat("hh:mm:ss");
                Date date = new Date();
                double money = rp.getMoney();
                System.out.println(Thread.currentThread().getName()+
                        ":获得金额为"+money+"元的红包;"+sf.format(date));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
