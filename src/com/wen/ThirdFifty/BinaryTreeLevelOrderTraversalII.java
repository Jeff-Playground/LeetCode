package com.wen.ThirdFifty;

import java.util.*;

public class BinaryTreeLevelOrderTraversalII {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Recursive
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        levelOrderBottom(root, 0, result);
        Collections.reverse(result);
        return result;
    }

    private void levelOrderBottom(TreeNode root, int level, List<List<Integer>> result) {
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            levelOrderBottom(root.left, level+1, result);
        }
        if (root.right != null) {
            levelOrderBottom(root.right, level+1, result);
        }
    }

//    // Iterative
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        if (root == null) {
//            return result;
//        }
//        Queue<TreeNode> queue=new LinkedList<>();
//        queue.offer(root);
//        while(queue.size()!=0){
//            List<Integer> level=new ArrayList<>();
//            int size=queue.size();
//            for(int i=0; i<size; i++){
//                TreeNode temp=queue.poll();
//                level.add(temp.val);
//                if (temp.left != null) {
//                    queue.offer(temp.left);
//                }
//                if (temp.right != null) {
//                    queue.offer(temp.right);
//                }
//            }
//            result.add(0, level);
//        }
//        return result;
//    }
}
