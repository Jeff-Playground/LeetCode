package com.wen.EleventhFifty;

/*

Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes
left boundary, leaves, and right boundary in order without duplicate nodes.

Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to
the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or
right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists.
If not, travel to the right subtree. Repeat until you reach a leaf node.

The right-most node is also defined by the same way with left and right exchanged.

Example 1

Input:
  1
   \
    2
   / \
  3   4

Ouput:
[1, 3, 4, 2]

Explanation:
The root doesn't have left subtree, so the root itself is left boundary.
The leaves are node 3 and 4.
The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
So order them in anti-clockwise without duplicates and we have [1,3,4,2].



Example 2

Input:
    ____1_____
   /          \
  2            3
 / \          /
4   5        6
   / \      / \
  7   8    9  10

Ouput:
[1,2,4,7,8,9,10,6,3]

Explanation:
The left boundary are node 1,2,4. (4 is the left-most node according to definition)
The leaves are node 4,7,8,9,10.
The right boundary are node 1,3,6,10. (10 is the right-most node).
So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].

 */

import java.util.ArrayList;
import java.util.List;

public class LQBoundaryOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Use one function to compute all boundaries
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        result.add(root.val);
        bobtHelper(root.left, true, false, result);
        bobtHelper(root.right, false, true, result);
        return result;
    }

    private void bobtHelper(TreeNode cur, boolean isLeft, boolean isRight, List<Integer> result){
        if(cur!=null){
            System.out.println(cur.val);
            if(cur.left==null && cur.right==null){
                result.add(cur.val);
            } else{
                if(isLeft){
                    result.add(cur.val);
                }
                bobtHelper(cur.left, isLeft && cur.left!=null, isRight && cur.right==null, result);
                bobtHelper(cur.right, isLeft && cur.left==null, isRight && cur.right!=null, result);
                if(isRight){
                    result.add(cur.val);
                }
            }
        }
    }

//    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        if(root.left!=null || root.right!=null){
//            result.add(root.val);
//        }
//        leftHelper(root.left, result);
//        leafHelper(root, result);
//        rightHelper(root.right, result, result.size());
//        return result;
//    }
//
//    private void leftHelper(TreeNode cur, List<Integer> result){
//        if(cur==null || (cur.left==null && cur.right==null)){
//            return;
//        } else{
//            result.add(cur.val);
//            if(cur.left!=null){
//                leftHelper(cur.left, result);
//            } else{
//                leftHelper(cur.right, result);
//            }
//        }
//    }
//
//    private void leafHelper(TreeNode cur, List<Integer> result){
//        if(cur!=null){
//            if(cur.left==null && cur.right==null){
//                result.add(cur.val);
//            } else{
//                leafHelper(cur.left, result);
//                leafHelper(cur.right, result);
//            }
//        }
//    }
//
//    private void rightHelper(TreeNode cur, List<Integer> result, int idx){
//        if(cur==null || (cur.left==null && cur.right==null)){
//            return;
//        } else{
//            result.add(idx, cur.val);
//            if(cur.right!=null){
//                rightHelper(cur.right, result, idx);
//            } else{
//                rightHelper(cur.left, result, idx);
//            }
//        }
//    }
}
