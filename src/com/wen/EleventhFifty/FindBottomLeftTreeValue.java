package com.wen.EleventhFifty;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Level-order traversal
    public int findBottomLeftValue(TreeNode root) {
        int result=root.val;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode cur=q.poll();
                if(i==0){
                    result=cur.val;
                }
                if(cur.left!=null){
                    q.offer(cur.left);
                }
                if(cur.right!=null){
                    q.offer(cur.right);
                }
            }
        }
        return result;
    }

//    // Inorder traversal
//    public int findBottomLeftValue(TreeNode root) {
//        int[] cache=new int[]{1, root.val};
//        fblvHelper(root, 1, cache);
//        return cache[1];
//    }
//
//    private void fblvHelper(TreeNode cur, int level, int[] cache){
//        if(cur==null){
//            return;
//        }
//        if(cur.left==null && cur.right==null){
//            if(level>cache[0]){
//                cache[0]=level;
//                cache[1]=cur.val;
//            }
//        } else{
//            fblvHelper(cur.left, level+1, cache);
//            fblvHelper(cur.right, level+1, cache);
//        }
//    }
}
