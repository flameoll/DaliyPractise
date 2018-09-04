package graph;

public interface Graph {
    public int size();
    public int edgeNum();
    public void connection(int p,int q);
    public boolean hasEdge(int p,int q);
    public void print();
}
