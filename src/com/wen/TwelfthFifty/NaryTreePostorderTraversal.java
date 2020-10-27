package com.wen.TwelfthFifty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NaryTreePostorderTraversal {
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

        // Iterative
        public List<Integer> postorder(Node root) {
            List<Integer> result=new ArrayList<>();
            if(root==null){
                return result;
            } else{
                Stack<Node> stack=new Stack<>();
                stack.push(root);
                while(!stack.isEmpty()){
                    Node cur=stack.pop();
                    result.add(cur.val);
                    if(cur.children!=null && !cur.children.isEmpty()){
                        for(Node c: cur.children){
                            stack.push(c);
                        }
                    }
                }
                Collections.reverse(result);
                return result;
            }
        }

//        // Recursive
//        public List<Integer> postorder(Node root) {
//            List<Integer> result=new ArrayList<>();
//            if(root==null){
//                return result;
//            } else{
//                if(root.children!=null){
//                    for(Node c: root.children){
//                        result.addAll(postorder(c));
//                    }
//                }
//                result.add(root.val);
//            }
//            return result;
//        }
    }
}
