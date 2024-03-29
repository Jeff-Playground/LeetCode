package com.wen.SixthFifty;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // Levelorder traversal (Iterative), note here it doesn't have to be level by level, and notNullCountCur can be merged
    // with notNullCountNext as notNullCount, details available in SerializeAndDeserializeBST
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        StringBuilder result=new StringBuilder();
        Queue<TreeNode> queue=new LinkedList<>();
        int notNullCountCur=1, notNullCountNext=0;
        queue.offer(root);
        while(!queue.isEmpty() && notNullCountCur>0){
            int size=queue.size();
            for(int i=size; i>0; i--){
                TreeNode cur=queue.poll();
                if(cur==null){
                    if(notNullCountCur==0 && notNullCountNext==0){
                        break;
                    } else{
                        result.append("null,");
                    }
                } else{
                    result.append(cur.val+",");
                    notNullCountCur--;
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                    if(cur.left!=null){
                        notNullCountNext++;
                    }
                    if(cur.right!=null){
                        notNullCountNext++;
                    }
                }
            }
            notNullCountCur=notNullCountNext;
            notNullCountNext=0;
        }
        result.delete(result.length()-1, result.length()).insert(0,"[").append("]");
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null){
            return null;
        }
        String[] nodes=data.substring(1, data.length()-1).split(",");
        Queue<TreeNode> queue=new LinkedList<>();
        TreeNode head=new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(head);
        int i=1;
        while(i<nodes.length){
            TreeNode cur=queue.poll();
            if(cur!=null){
                TreeNode left=nodes[i].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i]));
                i++;
                cur.left=left;
                queue.offer(left);
                if(i<nodes.length){
                    TreeNode right=nodes[i].equals("null")?null:new TreeNode(Integer.parseInt(nodes[i]));
                    i++;
                    cur.right=right;
                    queue.offer(right);
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
//        }
//        return root.val+","+serialize(root.left)+","+serialize(root.right);
//    }
//
//    // Decodes your encoded data to tree.
//    public TreeNode deserialize(String data) {
//        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
//        return deserializeDFS(queue);
//    }
//
//    private TreeNode deserializeDFS(Queue<String> queue) {
//        String s = queue.poll();
//        if (s.equals("null")) return null;
//        TreeNode node = new TreeNode(Integer.valueOf(s));
//        node.left = deserializeDFS(queue);
//        node.right = deserializeDFS(queue);
//        return node;
//    }
}
