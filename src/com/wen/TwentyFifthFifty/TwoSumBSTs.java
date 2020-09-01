package com.wen.TwentyFifthFifty;

/*
Given two binary search trees, return True if and only if there is a node in the first tree and a node in the second tree
whose values sum up to a given integer target.

Example 1:
Input: root1 = [2,1,4], root2 = [1,0,3], target = 5
Output: true
Explanation: 2 and 3 sum up to 5.

Example 2:
Input: root1 = [0,-10,10], root2 = [5,1,7,0,2], target = 18
Output: false

Note:
Each tree has at most 5000 nodes.
-10^9 <= target, node.val <= 10^9
 */

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class TwoSumBSTs {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1==null || root2==null){
            return false;
        }
        Stack<TreeNode> stack1=new Stack<>(), stack2=new Stack<>();
        TreeNode cur1=root1, cur2=root2;
        while(true){
            while(cur1!=null){
                stack1.push(cur1);
                cur1=cur1.left;
            }
            while(cur2!=null){
                stack2.push(cur2);
                cur2=cur2.right;
            }
            if(stack1.isEmpty() || stack2.isEmpty()){
                break;
            }
            cur1=stack1.peek();
            cur2=stack2.peek();
            int sum=cur1.val+cur2.val;
            if(sum==target){
                return true;
            } else if(sum<target){
                cur1=cur1.right;
                stack1.pop();
            } else{
                cur2=cur2.left;
                stack2.pop();
            }
        }
        return false;
    }

//    // Preorder traversal and inorder traversal iteratively
//    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
//        if(root1==null || root2==null){
//            return false;
//        }
//        Set<Integer> tree1=new HashSet<>();
//        Stack<TreeNode> stack=new Stack<>();
//        TreeNode cur=root1;
//        while(!stack.isEmpty() || cur!=null){
//            if(cur!=null){
//                tree1.add(cur.val);
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                cur=cur.right;
//            }
//        }
//        cur=root2;
//        while(!stack.isEmpty() || cur!=null){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                if(tree1.contains(target-cur.val)){
//                    return true;
//                }
//                cur=cur.right;
//            }
//        }
//        return false;
//    }
}
