package com.wen.TwentiethFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        TreeMap<Integer, List<Node>> sorted=new TreeMap<>();
        vtHelper(root, 0, 0, sorted);
        for(int key: sorted.keySet()){
            List<Node> cur=sorted.get(key);
            Collections.sort(cur, (a, b)->a.y!=b.y?b.y-a.y:a.val-b.val);
            List<Integer> c=new ArrayList<>();
            cur.forEach(e->c.add(e.val));
            result.add(c);
        }
        return result;
    }

    private void vtHelper(TreeNode cur, int x, int y, TreeMap<Integer, List<Node>> sorted){
        sorted.putIfAbsent(x, new ArrayList<>());
        sorted.get(x).add(new Node(y, cur.val));
        if(cur.left!=null){
            vtHelper(cur.left, x-1, y-1, sorted);
        }
        if(cur.right!=null){
            vtHelper(cur.right, x+1, y-1, sorted);
        }
    }

    class Node{
        int y;
        int val;

        public Node(int y, int val){
            this.y=y;
            this.val=val;
        }
    }
}
