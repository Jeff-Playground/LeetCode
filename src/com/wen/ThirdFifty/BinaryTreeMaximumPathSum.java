package com.wen.ThirdFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeMaximumPathSum {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public int maxPathSum(TreeNode root) {
        int[] result={Integer.MIN_VALUE};
        helper(root, result);
        return result[0];
    }

    public int helper(TreeNode node, int[] result){
        if(node==null){
            return 0;
        }
        int left=Math.max(helper(node.left, result), 0);
        int right=Math.max(helper(node.right, result), 0);
        result[0]=Math.max(result[0], left+right+node.val);
        return Math.max(left, right)+node.val;
    }

//    // Optimized to output the route list as well
//    public int maxPathSum(TreeNode root) {
//        int[] result= {Integer.MIN_VALUE};
//        List<TreeNode> list=new ArrayList<>();
//        helper(root, list, result);
//        list.stream().forEach(element->{
//            System.out.println(element.val);
//        });
//        return result[0];
//    }
//
//    public static List<TreeNode> helper(TreeNode node, List<TreeNode> list, int[] result) {
//        if(node==null) {
//            return new ArrayList<TreeNode>();
//        }
//        int leftSum=0;
//        List<TreeNode> left=helper(node.left, list, result);
//        for(TreeNode element:left) {
//            leftSum+=element.val;
//        }
//        leftSum=leftSum<0?0:leftSum;
//        int rightSum=0;
//        List<TreeNode> right=helper(node.right, list, result);
//        List<TreeNode> reverseRight=new ArrayList<>(right);
//        Collections.reverse(reverseRight);
//        for(TreeNode element:right) {
//            rightSum+=element.val;
//        }
//        rightSum=rightSum<0?0:rightSum;
//        if(result[0]<node.val+leftSum+rightSum) {
//            result[0]=node.val+leftSum+rightSum;
//            list.clear();
//            if(leftSum>0) {
//                list.addAll(left);
//            }
//            list.add(node);
//            if(rightSum>0) {
//                list.addAll(reverseRight);
//            }
//        }
//        if(leftSum>rightSum && leftSum>0) {
//            left.add(node);
//            return left;
//        } else if(rightSum>0) {
//            right.add(0, node);
//            return right;
//        } else {
//            List<TreeNode> temp=new ArrayList<>();
//            temp.add(node);
//            return temp;
//        }
//    }
}
