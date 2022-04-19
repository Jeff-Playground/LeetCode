package com.wen.TwentiethFifty;

import javafx.util.Pair;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Tree level order traversal
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        TreeMap<Integer, List<Pair<TreeNode, Integer>>> sorted=new TreeMap<>();
        Pair<TreeNode, Integer> rp=new Pair<>(root, 0);
        Queue<Pair<TreeNode, Integer>> q=new LinkedList<>();
        q.offer(rp);
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair<TreeNode, Integer> cp=q.poll();
                TreeNode cur=cp.getKey();
                int ci=cp.getValue();
                sorted.putIfAbsent(ci, new ArrayList<>());
                sorted.get(ci).add(new Pair<>(cur, level));
                if(cur.left!=null){
                    q.offer(new Pair<>(cur.left, ci-1));
                }
                if(cur.right!=null){
                    q.offer(new Pair<>(cur.right, ci+1));
                }
            }
            level++;
        }
        for(int k: sorted.keySet()){
            List<Pair<TreeNode, Integer>> cur=sorted.get(k);
            Collections.sort(cur, (a, b)->a.getValue()!=b.getValue()?a.getValue()-b.getValue():a.getKey().val-b.getKey().val);
            List<Integer> cl=new ArrayList<>();
            cur.forEach(v->cl.add(v.getKey().val));
            result.add(cl);
        }
        return result;
    }
//    // Tree preorder traversal
//    public List<List<Integer>> verticalTraversal(TreeNode root) {
//        List<List<Integer>> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        }
//        TreeMap<Integer, List<Node>> sorted=new TreeMap<>();
//        vtHelper(root, 0, 0, sorted);
//        for(int key: sorted.keySet()){
//            List<Node> cur=sorted.get(key);
//            Collections.sort(cur, (a, b)->a.y!=b.y?b.y-a.y:a.val-b.val);
//            List<Integer> c=new ArrayList<>();
//            cur.forEach(e->c.add(e.val));
//            result.add(c);
//        }
//        return result;
//    }
//
//    private void vtHelper(TreeNode cur, int x, int y, TreeMap<Integer, List<Node>> sorted){
//        sorted.putIfAbsent(x, new ArrayList<>());
//        sorted.get(x).add(new Node(y, cur.val));
//        if(cur.left!=null){
//            vtHelper(cur.left, x-1, y-1, sorted);
//        }
//        if(cur.right!=null){
//            vtHelper(cur.right, x+1, y-1, sorted);
//        }
//    }
//
//    // Introduce a new class Node because the result need sorting on y or if y is same on val
//    class Node{
//        int y;
//        int val;
//
//        public Node(int y, int val){
//            this.y=y;
//            this.val=val;
//        }
//    }
}
