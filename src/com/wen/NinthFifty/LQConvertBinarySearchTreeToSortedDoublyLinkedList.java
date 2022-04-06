package com.wen.NinthFifty;

/*
Convert a Binary Search Tree to a sorted Circular Doubly-Linked List in place.

You can think of the left and right pointers as synonymous to the predecessor and successor pointers in a doubly-linked
list. For a circular doubly linked list, the predecessor of the first element is the last element, and the successor of
the last element is the first element.

We want to do the transformation in place. After the transformation, the left pointer of the tree node should point to
its predecessor, and the right pointer should point to its successor. You should return the pointer to the smallest element
of the linked list.



Example 1:
Input: root = [4,2,5,1,3]
Output: [1,2,3,4,5]
Explanation: The figure below shows the transformed BST. The solid line indicates the successor relationship, while the
dashed line means the predecessor relationship.

Example 2:
Input: root = [2,1,3]
Output: [1,2,3]


Constraints:
The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000
All the values of the tree are unique.
 */

import com.wen.FifthFifty.LowestCommonAncestorOfABinarySearchTree;

import java.util.Stack;

public class LQConvertBinarySearchTreeToSortedDoublyLinkedList {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };

//    // Divide and conquer
//    public Node treeToDoublyList(Node root) {
//        if(root==null){
//            return null;
//        }
//        Node left=treeToDoublyList(root.left);
//        Node right=treeToDoublyList(root.right);
//        if(left==null && right==null){
//            root.left=root;
//            root.right=root;
//            return root;
//        } else if(root.left==null){
//            root.right=right;
//            root.left=right.left;
//            right.left.right=root;
//            right.left=root;
//            return root;
//        } else if(root.right==null){
//            root.right=left;
//            root.left=left.left;
//            left.left.right=root;
//            left.left=root;
//            return left;
//        } else{
//            left.left.right=root;
//            root.left=left.left;
//            root.right=right;
//            right.left.right=left;
//            left.left=right.left;
//            right.left=root;
//            return left;
//        }
//    }

//    // In-order traversal recursively
//    public Node treeToDoublyList(Node root) {
//        if(root==null){
//            return null;
//        }
//        // cache will be used to store the start(cache[0]) and end(cache[1]) from last recursion
//        Node[] cache=new Node[2];
//        ttdlHelper(root, cache);
//        cache[0].left=cache[1];
//        cache[1].right=cache[0];
//        return cache[0];
//    }
//
//    private void ttdlHelper(Node node, Node[] cache){
//        if(node!=null){
//            ttdlHelper(node.left, cache);
//            if(cache[0]==null){
//                cache[0]=node;
//                cache[1]=node;
//            } else{
//                cache[1].right=node;
//                node.left=cache[1];
//                cache[1]=node;
//            }
//            ttdlHelper(node.right, cache);
//        }
//    }

//    // In-order traversal iteratively
//    public static Node treeToDoublyList(Node root) {
//        Node cur=root, head=new Node(-1), last=head;
//        Stack<Node> stack=new Stack<>();
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                last.right=cur;
//                cur.left=last;
//                last=last.right;
//                cur=cur.right;
//            }
//        }
//        last.right=head.right;
//        head.right.left=last;
//        return head.right;
//    }

//    // Morris traversal for in-order traversal, in-place
//    public static Node treeToDoublyList(Node root) {
//        Node head=new Node(-1), last=head;
//        Node cur=root, pre=null;
//        while(cur!=null){
//            if(cur.left!=null){
//                pre=cur.left;
//                while(pre.right!=null && pre.right!=cur){
//                    pre=pre.right;
//                }
//                if(pre.right==null){
//                    pre.right=cur;
//                    cur=cur.left;
//                } else{
//                    pre.right=null;
//                    last.right=cur;
//                    cur.left=last;
//                    last=last.right;
//                    cur=cur.right;
//                }
//            } else{
//                last.right=cur;
//                cur.left=last;
//                last=last.right;
//                cur=cur.right;
//            }
//        }
//        last.right=head.right;
//        head.right.left=last;
//        return head.right;
//    }
}
