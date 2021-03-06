package com.wen.NinthFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
    public static class TreeNode {
        int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    // Level order traversal
    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if(root==null){
            return "";
        }
        StringBuilder result=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        int notNull=1;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(cur==null){
                result.append(",null");
            } else{
                result.append(","+cur.val);
                notNull--;
                queue.offer(cur.left);
                if(cur.left!=null){
                    notNull++;
                }
                queue.offer(cur.right);
                if(cur.right!=null){
                    notNull++;
                }
                if(notNull==0){
                    break;
                }
            }
        }
        return result.substring(1);
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.isEmpty()){
            return null;
        }
        String[] nodes=data.split(",");
        TreeNode head=new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(head);
        int i=1;
        while(i<nodes.length){
            TreeNode cur=queue.poll();
            if(cur!=null){
                TreeNode leftChild=nodes[i].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                cur.left=leftChild;
                queue.offer(leftChild);
                if(i<nodes.length){
                    TreeNode rightChild=nodes[i].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i]));
                    i++;
                    cur.right=rightChild;
                    queue.offer(rightChild);
                }
            }
        }
        return head;
    }

//    // Preorder traversal (Recursive)
//    // Encodes a tree to a single string.
//    public String serialize(TreeNode root) {
//        if(root==null){
//            return "null";
//        } else{
//            return root.val+","+serialize(root.left)+","+serialize(root.right);
//        }
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        if(data.equals("null")){
//            return null;
//        } else{
//            Queue<String> queue=new LinkedList(Arrays.asList(data.split(",")));
//            return deserializeDFS(queue);
//        }
//    }
//
//    private TreeNode deserializeDFS(Queue<String> queue){
//        String node=queue.poll();
//        if(node.equals("null")){
//            return null;
//        } else{
//            TreeNode n=new TreeNode(Integer.parseInt(node));
//            n.left=deserializeDFS(queue);
//            n.right=deserializeDFS(queue);
//            return n;
//        }
//    }
}
