package com.wen.NinthFifty;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Use a count Map to store the count of the existing sums starting from the root, and when a sum is obtained, it
    // actually means the path starts from a node above to current node
    public int pathSum(TreeNode root, int sum) {
        int[] result=new int[]{0};
        Map<Integer, Integer> count=new HashMap<>();
        count.put(0,1);
        pathSumDFS(root, count, 0, sum, result);
        return result[0];
    }

    public void pathSumDFS(TreeNode node, Map<Integer, Integer> count, int curSum, int sum, int[] result){
        if(node==null){
            return;
        }
        int existing=curSum+node.val-sum;
        if(count.containsKey(existing) && count.get(existing)>0){
            result[0]+=count.get(existing);
        }
        count.put(curSum+node.val, count.getOrDefault(curSum+node.val, 0)+1);
        pathSumDFS(node.left, count, curSum+node.val, sum, result);
        pathSumDFS(node.right, count, curSum+node.val, sum, result);
        // This is necessary, it is to ensure the right subtree will not be affected by left subtree
        count.put(curSum+node.val, count.getOrDefault(curSum+node.val, 0)-1);
    }

//    // This method is not as effective as above, it finds the path by going through all nodes as starting point for the
//    // path
//    public int pathSum(TreeNode root, int sum) {
//        int[] result=new int[]{0};
//        pathSumHelper(root, sum, result);
//        return result[0];
//    }
//
//    public void pathSumHelper(TreeNode node, int sum, int[] result){
//        pathSumDFS(node, sum, result);
//        if(node!=null){
//            pathSumHelper(node.left, sum, result);
//            pathSumHelper(node.right, sum, result);
//        }
//
//    }
//
//    public void pathSumDFS(TreeNode node, int target, int[] result){
//        if(node==null){
//            return;
//        }
//        if(node.val==target){
//            result[0]++;
//        }
//        pathSumDFS(node.left, target-node.val, result);
//        pathSumDFS(node.right, target-node.val, result);
//    }
}
