package com.wen.SeventhFifty;

/*
Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).

If two nodes are in the same row and column, the order should be from left to right.

Examples 1:

Input: [3,9,20,null,null,15,7]

   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7

Output:

[
  [9],
  [3,15],
  [20],
  [7]
]
Examples 2:

Input: [3,9,8,4,0,1,7]

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7

Output:

[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Examples 3:

Input: [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5)

     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2

Output:

[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 */

import com.wen.ThirdFifty.MinimumDepthOfBinaryTree;

import java.util.*;

public class LQBinaryTreeVerticalOrderTraversal {
    public class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Note here it has to be level order traversal, otherwise the order will be messed up
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        TreeMap<Integer, List<Integer>> sorted=new TreeMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        Queue<Integer> qIdx=new LinkedList<>();
        q.offer(root);
        qIdx.offer(0);
        while(!q.isEmpty()){
            TreeNode cur=q.poll();
            int idx=qIdx.poll();
            List<Integer> curList=sorted.getOrDefault(idx, new ArrayList<>());
            curList.add(cur.val);
            sorted.put(idx, curList);
            if(cur.left!=null){
                q.offer(cur.left);
                qIdx.offer(idx-1);
            }
            if(cur.right!=null){
                q.offer(cur.right);
                qIdx.offer(idx+1);
            }
        }
        for(int key: sorted.keySet()){
            result.add(sorted.get(key));
        }
        return result;
    }
}
