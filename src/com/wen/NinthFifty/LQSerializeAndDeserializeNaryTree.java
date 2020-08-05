package com.wen.NinthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LQSerializeAndDeserializeNaryTree {
    public class Node {
        int data;
        ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // Level-order traversal
    public String serialize(Node root){
        if(root==null){
            return "#";
        }
        StringBuilder result=new StringBuilder();
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            Node cur=q.poll();
            if(cur==null){
                result.append("# ");
            } else{
                result.append(cur.data+" ");
                result.append(cur.children.size()+" ");
                if(cur.children.size()>0){
                    cur.children.forEach(e->q.offer(e));
                }
            }
        }
        return result.substring(0, result.length()-1);
    }

    public Node deserialize(String data){
        if(data==null || data.isEmpty()){
            return null;
        }
        Queue<String> input=new LinkedList<>(Arrays.asList(data.split("\\s")));
        Queue<Node> node=new LinkedList<>();
        Queue<Integer> size=new LinkedList<>();
        String first=input.poll();
        if(first.equals("#")){
            return null;
        }
        Node head=new Node(Integer.valueOf(first));
        node.offer(head);
        size.offer(Integer.valueOf(input.poll()));
        while(!node.isEmpty()){
            Node cur=node.poll();
            int curSize=size.poll();
            while(curSize-->0){
                Node child=new Node(Integer.valueOf(input.poll()));
                node.offer(child);
                size.offer(Integer.valueOf(input.poll()));
                cur.children.add(child);
            }
        }
        return head;
    }

//    // Pre-order traversal
//    public String serialize(Node root){
//        StringBuilder result=new StringBuilder();
//        serialize(root, result);
//        return result.substring(0, result.length()-1);
//    }
//
//    private void serialize(Node cur, StringBuilder result){
//        if(cur==null){
//            result.append("#");
//        } else{
//            result.append(cur.data+" ");
//            result.append(cur.children.size()+" ");
//            for(Node child: cur.children){
//                serialize(child, result);
//            }
//        }
//    }
//
//    public Node deserialize(String data){
//        Queue<String> q=new LinkedList<>(Arrays.asList(data.split("\\s")));
//        return deserialize(q);
//    }
//
//    private Node deserialize(Queue<String> q){
//        String cur=q.poll();
//        if(cur.equals("#")){
//            return null;
//        } else{
//            Node node=new Node(Integer.valueOf(cur));
//            int size=Integer.valueOf(q.poll());
//            while(size-->0){
//                node.children.add(deserialize(q));
//            }
//            return node;
//        }
//    }
}
