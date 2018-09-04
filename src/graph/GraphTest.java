package graph;

import java.util.Random;

public class GraphTest {

    public static void test(Graph graph,int n){
        for(int i=0;i<=10;i++){
            int p = new Random().nextInt(n-1);
            int q = new Random().nextInt(n-1);
            if(p==q) continue;
            graph.connection(p,q);
        }
        System.out.println("EdgeNum"+graph.edgeNum());
        System.out.println("ElementNum"+graph.size());
        graph.print();
    }
    public static void main(String[] args){
        //sort(new DenseGraph(10,false),10);
        test(new SparseGraph(15,false),15);
    }
}
