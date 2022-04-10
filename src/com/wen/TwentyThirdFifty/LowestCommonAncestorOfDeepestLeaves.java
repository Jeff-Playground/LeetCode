package com.wen.TwentyThirdFifty;

import java.util.HashMap;
import java.util.Map;

public class LowestCommonAncestorOfDeepestLeaves {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return lcaDeepestLeavesHelper(root, new HashMap<>());
    }

    private TreeNode lcaDeepestLeavesHelper(TreeNode node, Map<TreeNode, Integer> cache){
        if(node!=null){
            if(node.left==null && node.right==null){
                cache.put(node, 1);
                return node;
            } else if(node.left==null){
                TreeNode rightResult=lcaDeepestLeavesHelper(node.right, cache);
                cache.putIfAbsent(node, cache.get(node.right)+1);
                return rightResult;
            } else if(node.right==null){
                TreeNode leftResult=lcaDeepestLeavesHelper(node.left, cache);
                cache.putIfAbsent(node, cache.get(node.left)+1);
                return leftResult;
            } else{
                TreeNode leftResult=lcaDeepestLeavesHelper(node.left, cache);
                TreeNode rightResult=lcaDeepestLeavesHelper(node.right, cache);
                cache.putIfAbsent(node, Math.max(cache.get(node.left), cache.get(node.right))+1);
                if(cache.get(node.left)==cache.get(node.right)){
                    return node;
                } else{
                    return cache.get(node.left)>cache.get(node.right)?leftResult:rightResult;
                }
            }
        } else{
            return null;
        }
    }
}
