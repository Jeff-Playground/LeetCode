package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniqueBinarySearchTreesII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Optimized DFS with cache
    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        } else{
            return generateTreesHelper(1, n, new HashMap<>());
        }
    }

    private List<TreeNode> generateTreesHelper(int start, int end, Map<Integer, Map<Integer, List<TreeNode>>> memo){
        if(memo.containsKey(start) && memo.get(start).containsKey(end)){
            return memo.get(start).get(end);
        }
        List<TreeNode> result=new ArrayList<>();
        if(start>end){
            result.add(null);
        } else{
            for(int i=start; i<=end; i++){
                List<TreeNode> left=generateTreesHelper(start, i-1, memo);
                List<TreeNode> right=generateTreesHelper(i+1, end, memo);
                for(TreeNode l: left){
                    for(TreeNode r: right){
                        TreeNode cur=new TreeNode(i);
                        cur.left=l;
                        cur.right=r;
                        result.add(cur);
                    }
                }
            }
        }
        memo.putIfAbsent(start, new HashMap<>());
        memo.get(start).put(end, result);
        return result;
    }

//    // DFS
//    public List<TreeNode> generateTrees(int n) {
//        if(n==0){
//            return new ArrayList<>();
//        }
//        return generateTreesDFS(1, n);
//    }
//
//    private List<TreeNode> generateTreesDFS(int start, int end) {
//        List<TreeNode> allTrees=new ArrayList<>();
//        if(start>end){
//            // Note null is required here for generating null nodes for leaf nodes
//            allTrees.add(null);
//            return allTrees;
//        }
//
//        for(int i=start; i<=end; i++){
//            List<TreeNode> leftTrees=generateTreesDFS(start, i-1);
//            List<TreeNode> rightTrees=generateTreesDFS(i+1, end);
//
//            for(TreeNode l: leftTrees){
//                for(TreeNode r: rightTrees){
//                    TreeNode currentTree=new TreeNode(i);
//                    currentTree.left=l;
//                    currentTree.right=r;
//                    allTrees.add(currentTree);
//                }
//            }
//        }
//        return allTrees;
//    }
}
