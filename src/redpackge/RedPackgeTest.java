package redpackge;

public class RedPackgeTest {
    public static  void main(String[] args){
        MoreUserRedPackge mr = new MoreUserRedPackge();
        Thread t1 = new Thread(mr);
        t1.setName("旺仔QQ糖");
        Thread t2 = new Thread(mr);
        t2.setName("背影依然");
        Thread t3 = new Thread(mr);
        t3.setName("傻狗子1");
        Thread t4 = new Thread(mr);
        t4.setName("傻狗子2");
        Thread t5 = new Thread(mr);
        t5.setName("傻狗子3");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }


}
