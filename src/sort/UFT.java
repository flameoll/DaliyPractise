package sort;


public class UFT {
    public static void main(String[] args){
        int count =10;
        UnionFind uf = new UnionFind(count);
        uf.connectionElement(0,1);
        uf.connectionElement(1,2);
        uf.connectionElement(5,4);
        uf.connectionElement(3,4);
        uf.connectionElement(4,2);
        System.out.println(uf.isConnection(5,6));
        System.out.println(uf.isConnection(5,0));
        for(int i=0;i<count;i++){
            System.out.println(i+":"+uf.find(i));
        }

    }
    public void testUF(UnionFind uf,int count){
        System.out.println("UnionFind:"+2*count+" obs");
        Long starttime = System.currentTimeMillis();
        for (int i=0;i<count;i++){
            int p = (int) (Math.random()*count);
            int q = (int) (Math.random()*count);
            uf.connectionElement(p,q);
        }
        for(int i=0;i<count;i++){
            System.out.println(uf.find(i));
        }
        Long endtime = System.currentTimeMillis();
        System.out.println("cost time:"+(endtime-starttime)+"ms");
    }
}
