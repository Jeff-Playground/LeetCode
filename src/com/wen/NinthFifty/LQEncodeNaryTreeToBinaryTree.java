package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.List;

public class LQEncodeNaryTreeToBinaryTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Encode by putting all children in right node, note the siblings are put as left nodes of the right node, this
    // way there's no need to passing down the level info
    class Codec {
        // Encodes an n-ary tree to a binary tree.
        public TreeNode encode(Node root) {
            if(root==null){
                return null;
            } else{
                TreeNode r=new TreeNode(root.val);
                if(root.children!=null && root.children.size()>0){
                    TreeNode t=encode(root.children.get(0));
                    r.right=t;
                    for(int i=1; i<root.children.size(); i++){
                        t.left=encode(root.children.get(i));
                        t=t.left;
                    }
                }
                return r;
            }
        }

        // Decodes your binary tree to an n-ary tree.
        public Node decode(TreeNode root) {
            if(root==null){
                return null;
            } else{
                Node r=new Node(root.val);
                r.children=new ArrayList<>();
                TreeNode tmp=root.right;
                while(tmp!=null){
                    r.children.add(decode(tmp));
                    tmp=tmp.left;
                }
                return r;
            }
        }
    }

//    // Put the children in either left or right subtree based on the level of the root node, this would require
//    // passing down the level as an input
//    class Codec {
//        // Encodes an n-ary tree to a binary tree.
//        public TreeNode encode(Node root) {
//            return encodeHelper(root, 0);
//        }
//
//        private TreeNode encodeHelper(Node cur, int level){
//            if(cur==null){
//                return null;
//            } else{
//                TreeNode root=new TreeNode(cur.val);
//                TreeNode t=root;
//                if(cur.children!=null){
//                    for(Node e: cur.children){
//                        TreeNode et=encodeHelper(e,level+1);
//                        if(level%2==0){
//                            t.left=et;
//                        } else{
//                            t.right=et;
//                        }
//                        t=et;
//                    }
//                }
//                return root;
//            }
//        }
//
//        // Decodes your binary tree to an n-ary tree.
//        public Node decode(TreeNode root) {
//            return decodeHelper(root, 0);
//        }
//
//        private Node decodeHelper(TreeNode cur, int level){
//            if(cur==null){
//                return null;
//            } else{
//                Node root=new Node(cur.val);
//                root.children=new ArrayList<>();
//                TreeNode t=cur;
//                if(level%2==0){
//                    t=t.left;
//                    while(t!=null){
//                        root.children.add(decodeHelper(t,level+1));
//                        t=t.left;
//                    }
//                } else{
//                    t=t.right;
//                    while(t!=null){
//                        root.children.add(decodeHelper(t,level+1));
//                        t=t.right;
//                    }
//                }
//                return root;
//            }
//        }
//    }
}
