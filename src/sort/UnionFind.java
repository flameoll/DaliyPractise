package sort;

public class UnionFind {
    private int[] parent;
    private int count;
    private int[] rank;
    public UnionFind(int count){
        parent=new int[count];
        rank=new int[count];
        this.count=count;
        for(int i=0;i<count;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int key){
        //非递归方式优化find
        while(key!=parent[key]){
            parent[key]=parent[parent[key]];
            key=parent[key];
        }
        /*
        //递归方式
        if(key!=parent[key]){
            parent[key]=find(parent[key]);
        }
        */
        return key;
    }
    public boolean isConnection(int p,int q){
        return find(p)==find(q)?true:false;
    }
    public void connectionElement(int p,int q){
        //将rank小的根连接到rank大的根上,若相等,选其一连接 rank+1
        if(rank[find(p)]<rank[find(q)])
            parent[find(p)]=find(q);
        else if (rank[find(p)]>rank[find(q)])
            parent[find(q)]=find(p);
        else
            parent[find(q)]=find(p);
            rank[find(p)]+=1;
    }
}
