package RandomID;

public class RandomIdTest {
    public static void main(String[] args){
        Long start = System.currentTimeMillis();
        for(int i=0;i<10;i++) {
            String id = RandomID.getID(10);
            System.out.println(id);
        }
        Long end = System.currentTimeMillis();
        System.out.println("get randomID :"+(end-start)+"ms");
    }
}
