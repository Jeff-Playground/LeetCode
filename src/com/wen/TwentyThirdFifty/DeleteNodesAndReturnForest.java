package com.wen.TwentyThirdFifty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Optimized by making the helper function return the current root node, so in the input no longer needed to maintain
    // the parent and isLeft from upper level
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result=new ArrayList<>();
        Set<Integer> toDelete=new HashSet<>();
        for(int d: to_delete){
            toDelete.add(d);
        }
        dnHelper(root, true, toDelete, result);
        return result;
    }

    private TreeNode dnHelper(TreeNode node, boolean isRoot, Set<Integer> toDelete, List<TreeNode> result){
        if(node!=null){
            if(toDelete.contains(node.val)){
                dnHelper(node.left, true, toDelete, result);
                dnHelper(node.right, true, toDelete, result);
                return null;
            } else{
                if(isRoot){
                    result.add(node);
                }
                node.left=dnHelper(node.left, false, toDelete, result);
                node.right=dnHelper(node.right, false, toDelete, result);
                return node;
            }
        } else{
            return null;
        }
    }

//    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
//        List<TreeNode> result=new ArrayList<>();
//        Set<Integer> toDelete=new HashSet<>();
//        for(int d: to_delete){
//            toDelete.add(d);
//        }
//        dnHelper(null, false, root, true, toDelete, result);
//        return result;
//    }
//
//    private void dnHelper(TreeNode parent, boolean isLeft, TreeNode node, boolean isRoot, Set<Integer> toDelete, List<TreeNode> result){
//        if(node!=null){
//            if(toDelete.contains(node.val)){
//                if(parent!=null){
//                    if(isLeft){
//                        parent.left=null;
//                    } else{
//                        parent.right=null;
//                    }
//                }
//                dnHelper(null, false, node.left, true, toDelete, result);
//                dnHelper(null, false, node.right, true, toDelete, result);
//            } else{
//                if(isRoot){
//                    result.add(node);
//                }
//                dnHelper(node, true, node.left, false, toDelete, result);
//                dnHelper(node, false, node.right, false, toDelete, result);
//            }
//        }
//    }
}
