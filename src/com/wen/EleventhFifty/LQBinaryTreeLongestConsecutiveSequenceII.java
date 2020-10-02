package com.wen.EleventhFifty;

/*

Given a binary tree, you need to find the length of Longest Consecutive Path in Binary Tree.

Especially, this path can be either increasing or decreasing. For example, [1,2,3,4] and [4,3,2,1] are both considered
valid, but the path [1,2,4,3] is not valid. On the other hand, the path can be in the child-Parent-child order, where
not necessarily be parent-child order.

Example 1:

Input:
        1
       / \
      2   3
Output: 2
Explanation: The longest consecutive path is [1, 2] or [2, 1].



Example 2:

Input:
        2
       / \
      1   3
Output: 3
Explanation: The longest consecutive path is [1, 2, 3] or [3, 2, 1].


Note: All the values of tree nodes are in the range of [-1e7, 1e7].

 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LQBinaryTreeLongestConsecutiveSequenceII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public int longestConsecutive2(TreeNode root) {
        if(root==null){
            return 0;
        }
        int[] result=new int[]{1};
        longestConsecutive2DFS(root, result);
        return result[0];
    }

    public int[] longestConsecutive2DFS(TreeNode node, int[] result) {
        if(node==null){
            return null;
        } else{
            int[] left=longestConsecutive2DFS(node.left, result);
            int[] right=longestConsecutive2DFS(node.right, result);
            int[] max=new int[]{1,1};
            if(left!=null){
                if(node.val==node.left.val+1){
                    max[0]=1+left[0];
                } else if(node.val==node.left.val-1){
                    max[1]=1+left[1];
                }
            }
            if(right!=null){
                if(node.val==node.right.val+1){
                    max[0]=Math.max(max[0],1+right[0]);
                } else if(node.val==node.right.val-1){
                    max[1]=Math.max(max[1],1+right[1]);
                }
            }
            result[0]=Math.max(result[0], max[0]+max[1]-1);
            return max;
        }
    }

//    // This has StackOverFlow issue, change return type to int[] from List<Integer> solves this
//    public int longestConsecutive2(TreeNode root) {
//        if(root==null){
//            return 0;
//        }
//        int[] result=new int[]{1};
//        longestConsecutive2DFS(root, result);
//        return result[0];
//    }
//
//    public List<Integer> longestConsecutive2DFS(TreeNode node, int[] result) {
//        if(node==null){
//            return new ArrayList<>();
//        } else{
//            List<Integer> left=longestConsecutive2DFS(node.left, result);
//            List<Integer> right=longestConsecutive2DFS(node.right, result);
//            List<Integer> max=new ArrayList<>(Arrays.asList(1,1));
//            if(left.size()!=0){
//                if(node.val==node.left.val+1){
//                    max.set(0,1+left.get(0));
//                } else if(node.val==node.left.val-1){
//                    max.set(1,1+left.get(1));
//                }
//            }
//            if(right.size()!=0){
//                if(node.val==node.right.val+1){
//                    max.set(0,Math.max(max.get(0),1+right.get(0)));
//                } else if(node.val==node.right.val-1){
//                    max.set(1,Math.max(max.get(1),1+right.get(1)));
//                }
//            }
//            result[0]=Math.max(result[0], max.get(0)+max.get(1)-1);
//            return max;
//        }
//    }
}
