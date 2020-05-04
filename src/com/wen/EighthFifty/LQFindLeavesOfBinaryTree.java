package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LQFindLeavesOfBinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

//    public List<List<Integer>> findLeaves(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        findLeavesHelper(root, result);
//        return result;
//    }
//
//    private int findLeavesHelper(TreeNode cur, List<List<Integer>>result){
//        if(cur==null){
//            return 0;
//        }
//        int left=findLeavesHelper(cur.left, result), right=findLeavesHelper(cur.right, result);
//        int h=Math.max(left, right)+1;
//        if(result.size()<h){
//            result.add(new ArrayList<>());
//        }
//        result.get(h-1).add(cur.val);
//        return h;
//    }

    public static List<List<Integer>> findLeaves(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> left=findLeaves(root.left), right=findLeaves(root.right);
        List<List<Integer>> deeper=left.size()>=right.size()?left:right, shallower=left.size()<right.size()?left:right;
        for(int i=0; i<shallower.size(); i++){
            deeper.get(i).addAll(shallower.get(i));
        }
        deeper.add(new ArrayList<>(Arrays.asList(root.val)));
        return deeper;
    }
}
