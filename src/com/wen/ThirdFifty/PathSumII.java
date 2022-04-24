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
        Stack<TreeNode> stack=new Stack<>();
        List<Integer> route=new ArrayList<>();
        TreeNode cur=root, pre=null;
        int curSum=0;
        while(cur!=null || !stack.isEmpty()){
            if(cur!=null){
                curSum+=cur.val;
                route.add(cur.val);
                stack.push(cur);
                cur=cur.left;
            } else{
                cur=stack.peek();
                if(cur.right==null){
                    if(cur.left==null && curSum==sum){
                        result.add(new ArrayList<>(route));
                    }
                    curSum-=cur.val;
                    pre=cur;
                    stack.pop();
                    route.remove(route.size()-1);
                    cur=null;
                } else{
                    if(cur.right==pre){
                        curSum-=cur.val;
                        pre=cur;
                        stack.pop();
                        route.remove(route.size()-1);
                        cur=null;
                    } else{
                        cur=cur.right;
                    }
                }
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
