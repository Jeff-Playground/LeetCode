package com.wen.FourteenthFifty;

public class SecondMinimumNodeInABinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // DFS
    public int findSecondMinimumValue(TreeNode root) {
        int[] cache=new int[]{-1, -1};
        fsmvHelper(root, cache);
        return cache[1];
    }

    private void fsmvHelper(TreeNode cur, int[] cache){
        if(cur!=null){
            if(cur.left!=null){
                fsmvHelper(cur.left, cache);
                fsmvHelper(cur.right, cache);
            } else{
                if(cache[0]==-1 || cur.val<cache[0]){
                    cache[1]=cache[0];
                    cache[0]=cur.val;
                } else if((cache[1]==-1 && cur.val!=cache[0]) || (cur.val>cache[0] && cur.val<cache[1])){
                    cache[1]=cur.val;
                }
            }
        }
    }
}
