package com.wen.EleventhFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindModeInBinarySearchTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode() {}
        public TreeNode(int val) { this.val = val; }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Inorder traversal recursively
    public static int[] findMode(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        int[] cache=new int[]{0, -1, -1};
        findModeHelper(root, result, cache);
        if(cache[1]>=cache[0]) {
            if (cache[1] > cache[0]) {
                result.clear();
            }
            result.add(cache[2]);
            cache[0] = cache[1];
        }
        int[] r=new int[result.size()];
        for(int i=0; i<result.size(); i++){
            r[i]=result.get(i);
        }
        return r;
    }

    private static void findModeHelper(TreeNode cur, List<Integer> result, int[] cache){
        if(cur==null){
            return;
        }
        findModeHelper(cur.left, result, cache);
        if(cache[1]==-1){
            cache[1]=1;
            cache[2]=cur.val;
        } else{
            if(cur.val==cache[2]){
                cache[1]++;
            } else{
                if(cache[1]>=cache[0]) {
                    if (cache[1] > cache[0]) {
                        result.clear();
                    }
                    result.add(cache[2]);
                    cache[0] = cache[1];
                }
                cache[1]=1;
                cache[2]=cur.val;
            }
        }
        findModeHelper(cur.right, result, cache);
    }

//    // Inorder traversal
//    public int[] findMode(TreeNode root) {
//        List<Integer> result=new ArrayList<>();
//        TreeNode cur=root;
//        Stack<TreeNode> stack=new Stack<>();
//        int max=0, count=-1, pre=-1;
//        while(cur!=null || !stack.isEmpty()){
//            if(cur!=null){
//                stack.push(cur);
//                cur=cur.left;
//            } else{
//                cur=stack.pop();
//                if(count==-1){
//                    count=1;
//                    pre=cur.val;
//                } else{
//                    if(cur.val==pre){
//                        count++;
//                    } else{
//                        if(count>=max){
//                            if(count>max){
//                                result.clear();
//                            }
//                            max=count;
//                            result.add(pre);
//                        }
//                        pre=cur.val;
//                        count=1;
//                    }
//                }
//                cur=cur.right;
//            }
//        }
//        if(count>=max){
//            if(count>max){
//                result.clear();
//            }
//            max=count;
//            result.add(pre);
//        }
//        int[] r=new int[result.size()];
//        for(int i=0; i<result.size(); i++){
//            r[i]=result.get(i);
//        }
//        return r;
//    }
}
