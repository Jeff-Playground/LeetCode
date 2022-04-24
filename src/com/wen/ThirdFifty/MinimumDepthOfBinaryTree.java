package com.wen.ThirdFifty;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    // Tree post order traversal
//    public int minDepth(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        if(root.left==null && root.right==null){
//            return 1;
//        } else if(root.left==null){
//            return 1+minDepth(root.right);
//        } else if(root.right==null){
//            return 1+minDepth(root.left);
//        } else{
//            return 1+Math.min(minDepth(root.left), minDepth(root.right));
//        }
//    }

    // Tree level order traversal
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        } else{
            Queue<TreeNode> q=new LinkedList<>();
            q.offer(root);
            int result=1;
            while(!q.isEmpty()){
                int size=q.size();
                while(size-->0){
                    TreeNode cur=q.poll();
                    if(cur.left==null && cur.right==null){
                        return result;
                    } else{
                        if(cur.left!=null){
                            q.offer(cur.left);
                        }
                        if(cur.right!=null){
                            q.offer(cur.right);
                        }
                    }
                }
                result++;
            }
            return result;
        }
    }
}
