package com.wen.FourteenthFifty;

public class LongestUnivaluePath {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Post order traversal
    public int longestUnivaluePath(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            int[] result=new int[]{0};
            lupHelper(root, result);
            return result[0];
        }
    }

    private int lupHelper(TreeNode cur, int[] cache){
        int result=1, max=0;
        if(cur.left!=null){
            int l=lupHelper(cur.left, cache);
            if(cur.val==cur.left.val){
                result+=l;
                max=l;
            }
        }
        if(cur.right!=null){
            int r=lupHelper(cur.right, cache);
            if(cur.val==cur.right.val){
                result=Math.max(result, 1+r);
                max+=r;
            }
        }
        cache[0]=Math.max(cache[0], max);
        return result;
    }
}
