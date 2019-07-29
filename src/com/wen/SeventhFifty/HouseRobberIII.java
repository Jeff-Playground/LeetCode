package com.wen.SeventhFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HouseRobberIII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int rob(TreeNode root) {
        List<Integer> result=robHelper(root);
        return Math.max(result.get(0), result.get(1));
    }

    // List has two elements, 0 - maximum when doesn't rob current node, 1 - maximum when rob current node
    private List<Integer> robHelper(TreeNode node) {
        if(node==null) {
            return new ArrayList<>(Arrays.asList(0,0));
        } else {
            List<Integer> result=new ArrayList<>();
            List<Integer> left=robHelper(node.left);
            List<Integer> right=robHelper(node.right);
            result.add(Math.max(left.get(0), left.get(1))+Math.max(right.get(0), right.get(1)));
            result.add(node.val+left.get(0)+right.get(0));
            return result;
        }
    }
}
