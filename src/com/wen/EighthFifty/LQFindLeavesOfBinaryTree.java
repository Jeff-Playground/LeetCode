package com.wen.EighthFifty;

/*
Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:

Input: [1,2,3,4,5]

          1
         / \
        2   3
       / \
      4   5

Output: [[4,5,3],[2],[1]]


Explanation:

1. Removing the leaves [4,5,3] would result in this tree:

          1
         /
        2


2. Now removing the leaf [2] would result in this tree:

          1


3. Now removing the leaf [1] would result in the empty tree:

          []
 */

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
