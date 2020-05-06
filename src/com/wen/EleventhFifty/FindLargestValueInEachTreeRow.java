package com.wen.EleventhFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Inorder traversal
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        lvHelper(root, 0, result);
        return result;
    }

    private void lvHelper(TreeNode cur, int level, List<Integer> result){
        if(cur==null){
            return;
        }
        if(result.size()<level+1){
            result.add(cur.val);
        } else{
            int max=result.get(level);
            if(max<cur.val){
                result.set(level, cur.val);
            }
        }
        lvHelper(cur.left, level+1, result);
        lvHelper(cur.right, level+1, result);
    }

//    // Level-order traversal
//    public List<Integer> largestValues(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        Queue<TreeNode> q=new LinkedList<>();
//        q.offer(root);
//        while(!q.isEmpty()){
//            int size=q.size(), max=Integer.MIN_VALUE;
//            for(int i=0; i<size; i++){
//                TreeNode cur=q.poll();
//                max=Math.max(max, cur.val);
//                if(cur.left!=null){
//                    q.offer(cur.left);
//                }
//                if(cur.right!=null){
//                    q.offer(cur.right);
//                }
//            }
//            result.add(max);
//        }
//        return result;
//    }
}
