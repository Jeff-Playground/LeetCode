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

    private List<Integer> robHelper(TreeNode node) {
        if(node==null) {
            return new ArrayList<>(Arrays.asList(0,0));
        } else {
            List<Integer> result=new ArrayList<>();
            result.add(node.val);
            result.add(0);
            List<Integer> left=robHelper(node.left);
            List<Integer> right=robHelper(node.right);
            result.set(0, result.get(0)+left.get(1)+right.get(1));
            result.set(1, Math.max(left.get(0), left.get(1))+Math.max(right.get(0), right.get(1)));
            return result;
        }
    }
}
