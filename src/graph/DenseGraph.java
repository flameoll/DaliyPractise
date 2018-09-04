package graph;

import java.util.Vector;

public class DenseGraph implements Graph{
    //e edge 边数 v 元素数
    private int e,v;
    //邻接矩阵实现稠密图
    private Vector<Vector<Boolean>> g;
    private boolean directed;
    public DenseGraph(int v,boolean directed){
        this.g=new Vector<>();
        this.v=v;
        this.e=0;
        this.directed=directed;
        for(int i =0;i<v;i++){
            Vector vec =new Vector<Boolean>();
            for (int j=0;j<v;j++){
                vec.add(j,false);
            }
            g.add(i,vec);
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
        g.get(p).add(q,true);
        e++;
    }
    public boolean hasEdge(int p,int q){

        return g.get(p).get(q)||g.get(q).get(p);
    }
    public void print(){
        System.out.print("\t");
        for(int i=0;i<v;i++){
            System.out.print(i+"\t");
        }
        System.out.println();
        for (int i=0;i<v;i++){
            System.out.print(i+"\t");
            for(int j=0;j<v;j++){
                System.out.print(g.get(i).get(j)+"\t");
            }
            System.out.println();
        }
    }
}
