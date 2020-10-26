package com.wen.TwelfthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NaryTreePreorderTraversal {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Iterative
    public List<Integer> preorder(Node root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        } else{
            Stack<Node> stack=new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node cur=stack.pop();
                result.add(cur.val);
                if(cur.children!=null){
                    for(int i=cur.children.size()-1; i>=0; i--){
                        stack.push(cur.children.get(i));
                    }
                }
            }
            return result;
        }
    }

//    // Recursive
//    public List<Integer> preorder(Node root) {
//        List<Integer> result=new ArrayList<>();
//        if(root==null){
//            return result;
//        } else{
//            result.add(root.val);
//            if(root.children!=null){
//                for(Node cur: root.children){
//                    result.addAll(preorder(cur));
//                }
//            }
//            return result;
//        }
//    }
}
