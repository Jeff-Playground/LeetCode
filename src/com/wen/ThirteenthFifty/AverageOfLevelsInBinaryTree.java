package com.wen.ThirteenthFifty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Level order traversal
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            long sum=0;
            int count=0;
            for(int i=0; i<size; i++){
                TreeNode cur=q.poll();
                sum+=cur.val;
                count++;
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
            result.add((double)sum/count);
        }
        return result;
    }

//    // Pre-order traversal, recursively
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> result=new ArrayList<>();
//        List<long[]> cache=new ArrayList<>();
//        populateCache(root, cache, 0);
//        for(long[] e: cache){
//            result.add((double)e[0]/e[1]);
//        }
//        return result;
//    }
//
//    private void populateCache(TreeNode cur, List<long[]> cache, long idx){
//        if(cur!=null){
//            if(cache.size()<idx+1){
//                cache.add(new long[]{0,0});
//            }
//            long[] cLevel=cache.get((int)idx);
//            cLevel[0]+=cur.val;
//            cLevel[1]++;
//            populateCache(cur.left, cache, idx+1);
//            populateCache(cur.right, cache, idx+1);
//        }
//    }
}
