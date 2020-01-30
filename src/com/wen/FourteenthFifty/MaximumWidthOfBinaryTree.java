package com.wen.FourteenthFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Recursive, startIdx list stores the most left node index of each level, this is very similar to how a heap is
//    // stored in array
//    public int widthOfBinaryTree(TreeNode root) {
//        List<Integer> startIdx=new ArrayList<>();
//        return widthOfBinaryTreeDFS(root, startIdx, 0, 0);
//    }
//
//    public int widthOfBinaryTreeDFS(TreeNode node, List<Integer> startIdx, int level, int idx){
//        if(node==null){
//            return 0;
//        } else{
//            // This works because the DFS always first goes to the left node of the level
//            if(level>=startIdx.size()){
//                startIdx.add(idx);
//            }
//            return Math.max(idx-startIdx.get(level)+1,
//                    Math.max(widthOfBinaryTreeDFS(node.left, startIdx, level+1, idx*2+1),
//                            widthOfBinaryTreeDFS(node.right, startIdx, level+1, idx*2+2)));
//        }
//    }

    // Level order traversal, can use a new data structure or overwrite node.val to make it use only one Queue, similar
    // to the above recursive method
    public int widthOfBinaryTree(TreeNode root) {
        int result=0;
        if(root==null){
            return result;
        }
        Queue<TreeNode> nodeQ=new LinkedList<>();
        Queue<Integer> idxQ=new LinkedList<>();
        nodeQ.offer(root);
        idxQ.offer(0);
        while(!nodeQ.isEmpty()){
            int size=nodeQ.size(), min=-1, max=-1;
            for(int i=0; i<size; i++){
                TreeNode cur=nodeQ.poll();
                int index=idxQ.poll();
                if(i==0){
                    min=index;
                }
                if(i==size-1){
                    max=index;
                }
                if(cur.left!=null){
                    nodeQ.offer(cur.left);
                    idxQ.offer(index*2+1);
                }
                if(cur.right!=null){
                    nodeQ.offer(cur.right);
                    idxQ.offer(index*2+2);
                }
            }
            if(max!=-1){
                result=Math.max(result, max-min+1);
            } else{
                result=Math.max(result, 1);
            }
        }
        return result;
    }
}
