package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PathSumII {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Iterative
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root, pre=null;
        int val=0;
        while(cur!=null || !stack.isEmpty()){
            while(cur!=null){
                stack.push(cur);
                val+=cur.val;
                cur=cur.left;
            }
            cur=stack.peek();
            if(cur.left==null && cur.right==null && val==sum){
                List<Integer> temp=new ArrayList<>();
                stack.stream().forEach(node ->{
                    temp.add(node.val);
                });
                result.add(temp);
            }
            if(cur.right!=null && cur.right!=pre){
                cur=cur.right;
            } else{
                pre=cur;
                val-=cur.val;
                stack.pop();
                cur=null;
            }
        }
        return result;
    }

//    // Recursive
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        List<Integer> out=new ArrayList<>();
//        pathSumDFS(root, sum, out, result);
//        return result;
//    }
//
//    private void pathSumDFS(TreeNode root, int sum, List<Integer> out, List<List<Integer>> result) {
//        if(root==null){
//            return;
//        }
//        out.add(root.val);
//        if(root.left==null && root.right==null && root.val==sum){
//            List<Integer> temp=new ArrayList<>(out);
//            result.add(temp);
//        }
//        pathSumDFS(root.left, sum-root.val, out, result);
//        pathSumDFS(root.right, sum-root.val, out, result);
//        out.remove(out.size()-1);
//    }
}
