package com.wen.NinthFifty;

/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored
in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or
another computer environment.

Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has
no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You
just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original
tree structure.


Example 1:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]


Example 2:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,null,3,2,4,null,5,6]


Example 3:
Input: root = []
Output: []


Constraints:
The number of nodes in the tree is in the range [0, 104].
0 <= Node.val <= 104
The height of the n-ary tree is less than or equal to 1000
Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */

import java.util.*;

public class LQSerializeAndDeserializeNaryTree {
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

//    // Level-order traversal, encode the string like "node_val node_children_size "
//    class Codec {
//        // Encodes a tree to a single string.
//        public String serialize(Node root) {
//            if(root==null){
//                return "#";
//            }
//            StringBuilder result=new StringBuilder();
//            Queue<Node> q=new LinkedList<>();
//            q.offer(root);
//            while(!q.isEmpty()){
//                Node cur=q.poll();
//                if(cur==null){
//                    result.append("# ");
//                } else{
//                    result.append(cur.val+" ");
//                    result.append(cur.children.size()+" ");
//                    if(cur.children.size()>0){
//                        cur.children.forEach(e->q.offer(e));
//                    }
//                }
//            }
//            return result.substring(0, result.length()-1);
//        }
//
//        // Decodes your encoded data to tree.
//        public Node deserialize(String data) {
//            if(data==null || data.isEmpty()){
//                return null;
//            }
//            Queue<String> input=new LinkedList<>(Arrays.asList(data.split("\\s")));
//            Queue<Node> node=new LinkedList<>();
//            Queue<Integer> size=new LinkedList<>();
//            String first=input.poll();
//            if(first.equals("#")){
//                return null;
//            }
//            Node head=new Node(Integer.valueOf(first), new ArrayList<>());
//            node.offer(head);
//            size.offer(Integer.valueOf(input.poll()));
//            while(!node.isEmpty()){
//                Node cur=node.poll();
//                int curSize=size.poll();
//                while(curSize-->0){
//                    Node child=new Node(Integer.valueOf(input.poll()), new ArrayList<>());
//                    node.offer(child);
//                    size.offer(Integer.valueOf(input.poll()));
//                    cur.children.add(child);
//                }
//            }
//            return head;
//        }
//    }

    // Pre-order traversal, encode the string like "node_val node_children_size "
    class Codec {
        // Encodes a tree to a single string.
        public String serialize(Node root) {
            StringBuilder result=new StringBuilder();
            serialize(root, result);
            return result.substring(0, result.length()-1);
        }

        private void serialize(Node cur, StringBuilder result){
            if(cur==null){
                result.append("# ");
            } else{
                result.append(cur.val+" ");
                result.append(cur.children.size()+" ");
                for(Node child: cur.children){
                    serialize(child, result);
                }
            }
        }

        // Decodes your encoded data to tree.
        public Node deserialize(String data) {
            Queue<String> q=new LinkedList<>(Arrays.asList(data.split("\\s")));
            return deserialize(q);
        }

        private Node deserialize(Queue<String> q){
            String cur=q.poll();
            if(cur.equals("#")){
                return null;
            } else{
                Node node=new Node(Integer.valueOf(cur), new ArrayList<>());
                int size=Integer.valueOf(q.poll());
                while(size-->0){
                    node.children.add(deserialize(q));
                }
                return node;
            }
        }
    }
}
