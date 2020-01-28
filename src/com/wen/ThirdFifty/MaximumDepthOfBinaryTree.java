package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Level order traverse
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int result=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            result++;
            int size=queue.size();
            for(int i=0; i<size; i++){
                TreeNode temp=queue.poll();
                if(temp.left!=null){
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }

//    // DFS
//    public int maxDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        return 1+Math.max(maxDepth(root.left), maxDepth(root.right));
//    }
}
