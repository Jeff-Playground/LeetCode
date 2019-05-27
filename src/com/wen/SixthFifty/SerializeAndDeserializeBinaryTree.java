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

    // Levelorder traversal (Iterative)
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            return null;
        }
        String result="";
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
                        result+="null,";
                    }
                } else{
                    result+=cur.val+",";
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
        result="["+result.substring(0, result.length()-1)+"]";
        return result;
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
//        TreeNode root = new TreeNode(Integer.valueOf(s));
//        root.left = deserializeDFS(queue);
//        root.right = deserializeDFS(queue);
//        return root;
//    }
}
