package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> generateTrees(int n) {
        if(n==0){
            return new ArrayList<>();
        }
        return generateTreesDFS(1, n);
    }

    private List<TreeNode> generateTreesDFS(int start, int end) {
        List<TreeNode> allTrees=new ArrayList<>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i=start; i<=end; i++){
            List<TreeNode> leftTrees=generateTreesDFS(start, i-1);
            List<TreeNode> rightTrees=generateTreesDFS(i+1, end);

            for(TreeNode l: leftTrees){
                for(TreeNode r: rightTrees){
                    TreeNode currentTree=new TreeNode(i);
                    currentTree.left=l;
                    currentTree.right=r;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }
}
