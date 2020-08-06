package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQEncodeNaryTreeToBinaryTree {
    // Definition for Undirected graph.
    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
    // Definition of TreeNode:
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: binary tree
     * @return: N-ary tree
     */
    public UndirectedGraphNode decode(TreeNode root) {
        if(root==null){
            return null;
        }
        UndirectedGraphNode result=new UndirectedGraphNode(root.val);
        decode(root, result, true);
        return result;
    }

    private void decode(TreeNode curTree, UndirectedGraphNode cur, boolean childInLeft){
        if(childInLeft){
            if(curTree.left!=null){
                TreeNode node=curTree.left;
                while(node!=null){
                    UndirectedGraphNode e=new UndirectedGraphNode(node.val);
                    decode(node, e, !childInLeft);
                    cur.neighbors.add(e);
                    node=node.left;
                }
            }
        } else{
            if(curTree.right!=null){
                TreeNode node=curTree.right;
                while(node!=null){
                    UndirectedGraphNode e=new UndirectedGraphNode(node.val);
                    decode(node, e, !childInLeft);
                    cur.neighbors.add(e);
                    node=node.right;
                }
            }
        }
    }

    /**
     * @param root: N-ary tree
     * @return: binary tree
     */
    public TreeNode encode(UndirectedGraphNode root) {
        if(root==null){
            return null;
        }
        TreeNode result=new TreeNode(root.label);
        encode(root, result, true);
        return result;
    }

    private void encode(UndirectedGraphNode cur, TreeNode curTree, boolean childInLeft){
        List<UndirectedGraphNode> children=cur.neighbors;
        if(children.size()>0){
            TreeNode node=curTree;
            for(UndirectedGraphNode e: children){
                TreeNode eTree=new TreeNode(e.label);
                encode(e, eTree, !childInLeft);
                if(childInLeft){
                    node.left=eTree;
                } else{
                    node.right=eTree;
                }
                node=eTree;
            }
        }
    }
}
