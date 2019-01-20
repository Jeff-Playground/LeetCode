package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> queue1=new LinkedList<>();
        Queue<TreeNode> queue2=new LinkedList<>();
        queue1.offer(root);
        while(!queue1.isEmpty() || !queue2.isEmpty()){
            List<Integer> level1=new ArrayList<>();
            while(!queue1.isEmpty()){
                TreeNode temp=queue1.poll();
                level1.add(temp.val);
                if(temp.left!=null){
                    queue2.offer(temp.left);
                }
                if(temp.right!=null){
                    queue2.offer(temp.right);
                }
            }
            if(level1.size()!=0){
                result.add(level1);
            }
            List<Integer> level2=new ArrayList<>();
            while(!queue2.isEmpty()){
                TreeNode temp=queue2.poll();
                level2.add(0, temp.val);
                if(temp.left!=null){
                    queue1.offer(temp.left);
                }
                if(temp.right!=null){
                    queue1.offer(temp.right);
                }
            }
            if(level2.size()!=0){
                result.add(level2);
            }
        }
        return result;
    }
}
