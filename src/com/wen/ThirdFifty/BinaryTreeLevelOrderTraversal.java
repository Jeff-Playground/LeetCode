package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Recursive
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        levelOrderDFS(root, 0, result);
        return result;
    }

    private void levelOrderDFS(TreeNode root, int level, List<List<Integer>> result) {
        if(root==null){
            return;
        }
        if(result.size()==level){
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if(root.left!=null){
            levelOrderDFS(root.left, level+1, result);
        }
        if(root.right!=null){
            levelOrderDFS(root.right, level+1, result);
        }
    }

//    // Iterative(BFS)
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        Queue<TreeNode> queue=new LinkedList<TreeNode>();
//        ((LinkedList<TreeNode>) queue).offer(root);
//        while(!queue.isEmpty()){
//            int size=queue.size();
//            List<Integer> level=new ArrayList<>();
//            for(int i=0; i<size; i++){
//                TreeNode temp=queue.poll();
//                level.add(temp.val);
//                if(temp.left!=null){
//                    queue.offer(temp.left);
//                }
//                if(temp.right!=null){
//                    queue.offer(temp.right);
//                }
//            }
//            result.add(level);
//        }
//        return result;
//    }
}
