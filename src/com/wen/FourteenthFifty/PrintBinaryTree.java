package com.wen.FourteenthFifty;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Tree inorder traversal
    public List<List<String>> printTree(TreeNode root) {
        int height=getTreeHeight(root);
        int col=(int)Math.pow(2, height)-1;
        List<List<String>> result=new ArrayList<>();
        ptHelper(root, 0, (col-1)/2, result, height);
        for(List<String> l: result){
            while(l.size()<col){
                l.add("");
            }
        }
        return result;
    }

    private void ptHelper(TreeNode cur, int level, int idx, List<List<String>> result, int height){
        if(level>result.size()-1){
            result.add(new ArrayList<>());
        }
        List<String> list=result.get(level);
        while(list.size()<idx){
            list.add("");
        }
        list.add(""+cur.val);
        if(cur.left!=null){
            ptHelper(cur.left, level+1, idx-(int)Math.pow(2, height-level-2), result, height);
        }
        if(cur.right!=null){
            ptHelper(cur.right, level+1, idx+(int)Math.pow(2, height-level-2), result, height);
        }
    }

//    // Tree level order traversal
//    public List<List<String>> printTree(TreeNode root) {
//        int h=getTreeHeight(root);
//        int col=(int)Math.pow(2, h)-1;
//        List<List<String>> result=new ArrayList<>();
//        Queue<Pair<TreeNode, Integer>> q=new LinkedList<>();
//        q.offer(new Pair<>(root, (col-1)/2));
//        while(!q.isEmpty()){
//            int size=q.size();
//            result.add(new ArrayList<>());
//            List<String> list=result.get(result.size()-1);
//            while(size-->0){
//                Pair<TreeNode, Integer> cur=q.poll();
//                TreeNode t=cur.getKey();
//                int i=cur.getValue();
//                while(list.size()<i){
//                    list.add("");
//                }
//                list.add(""+t.val);
//                if(t.left!=null){
//                    q.offer(new Pair<>(t.left, i-(int)Math.pow(2, h-result.size()-1)));
//                }
//                if(t.right!=null){
//                    q.offer(new Pair<>(t.right, i+(int)Math.pow(2, h-result.size()-1)));
//                }
//            }
//            while(list.size()<col){
//                list.add("");
//            }
//        }
//        return result;
//    }

    private int getTreeHeight(TreeNode root){
        if(root==null){
            return 0;
        } else{
            int leftHeight=getTreeHeight(root.left), rightHeight=getTreeHeight(root.right);
            return Math.max(leftHeight, rightHeight)+1;
        }
    }
}
