package graph;

import java.util.Enumeration;
import java.util.Vector;

public class SparseGraph implements Graph {
    private int v,e;
    //邻接表实现稀疏图
    private Vector<Vector<Integer>> g;
    private boolean directed;
    public SparseGraph(int v,boolean directed){
        this.g= new Vector<>();
        this.v=v;
        this.e=0;
        this.directed=directed;
        for (int i=0;i<v;i++){
            g.add(i,new Vector<Integer>());
        }
    }
    public int size(){
        return v;
    }
    public int edgeNum(){
        return e;
    }
    public void connection(int p,int q){
        assert (p>=0&&p<v);
        assert (q>=0&&q<v);
        if(hasEdge(p,q)) return;
        g.get(p).add(q);
        e++;
    }
    public boolean hasEdge(int p,int q){
        return g.get(p).contains(q)||g.get(q).contains(p);
    }
    public void print(){
        for(int i=0;i<v;i++){
            System.out.print(i+":");
            Enumeration e =g.get(i).elements();
            while(e.hasMoreElements())
                System.out.print(e.nextElement()+" ");
            System.out.println();
        }
    }
}
