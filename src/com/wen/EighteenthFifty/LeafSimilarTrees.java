package com.wen.EighteenthFifty;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1=new ArrayList<>(), leaf2=new ArrayList<>();
        getLeafs(root1, leaf1);
        getLeafs(root2, leaf2);
        if(leaf1.size()!=leaf2.size()){
            return false;
        } else{
            int l=leaf1.size();
            for(int i=0; i<l; i++){
                if(leaf1.get(i)!=leaf2.get(i)){
                    return false;
                }
            }
            return true;
        }
    }

    private void getLeafs(TreeNode node, List<Integer> leaf){
        if(node==null){
            return;
        }
        if(node.left==null && node.right==null){
            leaf.add(node.val);
            return;
        } else{
            if(node.left!=null){
                getLeafs(node.left, leaf);
            }
            if(node.right!=null){
                getLeafs(node.right, leaf);
            }
        }
    }
}
