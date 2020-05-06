package com.wen.EleventhFifty;

/*
Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
The successor of a node p is the node with the smallest key greater than p.val.
You will have direct access to the node but not to the root of the tree. Each node will have a reference to its parent node.

Note:
If the given node has no in-order successor in the tree, return null.
It’s guaranteed that the values of the tree are unique.

Remember that we are using the Node type instead of TreeNode type so their string representation are different.

Follow up: Could you solve it without looking up any of the node’s values?
*/

public class LQInorderSuccessorInBSTII {
    public class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    // Logic accesses node's values
    public Node inorderSuccessor(Node x) {
        if(x==null){
            return null;
        }
        Node result=x.right;
        while(result!=null && result.left!=null){
            result=result.left;
        }
        if(result==null && x.parent!=null){
            result=x.parent;
            while(result!=null && result.val<x.val){
                result=result.parent;
            }
        }
        return result;
    }

//    // Logic doesn't access any node's values
//    public Node inorderSuccessor(Node x) {
//        if(x==null){
//            return null;
//        }
//        Node result=x.right;
//        while(result!=null && result.left!=null){
//            result=result.left;
//        }
//        if(result==null && x.parent!=null){
//            Node parent=x.parent, cur=x;
//            while(parent!=null && parent.left!=cur){
//                cur=parent;
//                parent=cur.parent;
//            }
//            result=parent;
//        }
//        return result;
//    }
}
