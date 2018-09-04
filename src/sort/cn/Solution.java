package sort.cn;

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null) return null;
        int left=0;
        int right=in.length-1;
        return __reConstructBinaryTree(pre,in,left,right);

    }
    private TreeNode __reConstructBinaryTree(int [] pre,int [] in,int left,int right){
        if(left>right) return null;
        TreeNode root = new TreeNode(pre[left]);
        int __left=left;
        int __right=right;
        for(int i=0;i<=7;i++){
            if(in[i]==pre[__left])
                __right=i;
        }
        __left++;
        root.left=__reConstructBinaryTree(pre,in,__left,__right-1);
        root.right=__reConstructBinaryTree(pre,in,__right+1,right);
        return root;
    }
    public void dfs(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node =queue.poll();
            System.out.print(node.val+" ");
            queue.add(node.left);
            queue.add(node.right);
        }
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
  }
