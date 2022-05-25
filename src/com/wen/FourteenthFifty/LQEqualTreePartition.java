package com.wen.FourteenthFifty;

/*
Given the root of a binary tree, return true if you can partition the tree into two trees with equal sums of values after
removing exactly one edge on the original tree.



Example 1:
Input: root = [5,10,10,null,null,2,3]
Output: true


Example 2:
Input: root = [1,2,10,null,null,2,20]
Output: false
Explanation: You cannot split the tree into two trees with equal sums after removing exactly one edge on the tree.


Constraints:
The number of nodes in the tree is in the range [1, 10^4].
-10^5 <= Node.val <= 10^5
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LQEqualTreePartition {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Use a Map to store the count of all sums in the tree
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> count=new HashMap<>();
        int total=checkEqualTreeDFS(root, count);
        if(total%2==0){
            if((total==0 && count.get(0)>1) || (total!=0 && count.containsKey(total/2))){
                return true;
            }
        }
        return false;
    }

    private int checkEqualTreeDFS(TreeNode node, Map<Integer, Integer> count){
        if(node==null){
            return 0;
        } else{
            int val=node.val+checkEqualTreeDFS(node.left, count)+checkEqualTreeDFS(node.right, count);
            count.put(val, count.getOrDefault(val, 0)+1);
            return val;
        }
    }

//    // Use a Stack to store all sums in the tree
//    public boolean checkEqualTree(TreeNode root) {
//        Stack<Integer> sums=new Stack<>();
//        int total=cetHelper(root, sums);
//        sums.pop();
//        if(total%2==0){
//            while(!sums.isEmpty()){
//                if(sums.pop()*2==total){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private int cetHelper(TreeNode node, Stack<Integer> sums){
//        if(node!=null){
//            int sum=node.val+cetHelper(node.left, sums)+cetHelper(node.right, sums);
//            sums.push(sum);
//            return sum;
//        } else{
//            return 0;
//        }
//    }
}
