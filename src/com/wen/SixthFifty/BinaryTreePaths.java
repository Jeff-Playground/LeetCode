package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result=new ArrayList<>();
        if(root==null){
            return result;
        } else{
            binaryTreePathsDFS(root, "", result);
            return result;
        }
    }

    public void binaryTreePathsDFS(TreeNode node, String cur, List<String> result){
        if(node.left==null && node.right==null){
            result.add(cur+node.val);
        } else{
            cur+=node.val+"->";
            if(node.left!=null){
                binaryTreePathsDFS(node.left, cur, result);
            }
            if(node.right!=null){
                binaryTreePathsDFS(node.right, cur, result);
            }
        }
    }
}
