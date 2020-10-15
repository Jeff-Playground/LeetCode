package com.wen.TwelfthFifty;

import java.util.Stack;

public class SubtreeOfAnotherTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

//    // Recursive
//    public boolean isSubtree(TreeNode s, TreeNode t) {
//        if(t==null){
//            return true;
//        }
//        if(s==null){
//            return t==null;
//        } else{
//            if(isSame(s, t)){
//                return true;
//            } else{
//                return isSubtree(s.left, t) || isSubtree(s.right, t);
//            }
//        }
//    }
//
//    private boolean isSame(TreeNode cur, TreeNode t){
//        if(cur==null && t==null){
//            return true;
//        } else if(cur==null || t==null){
//            return false;
//        } else if(cur.val!=t.val){
//            return false;
//        } else{
//            return isSame(cur.left, t.left) && isSame(cur.right, t.right);
//        }
//    }

    // Serialize and check if is substring, note this works because all null nodes are also serialized
    public boolean isSubtree(TreeNode s, TreeNode t) {
        StringBuilder sb=new StringBuilder(), tb=new StringBuilder();
        serialize(s, sb);
        serialize(t, tb);
        return sb.indexOf(tb.toString())!=-1;
    }

    private void serialize(TreeNode root, StringBuilder s){
        if(root==null){
            s.append(",#");
        } else{
            TreeNode cur=root;
            Stack<TreeNode> stack=new Stack<>();
            while(cur!=null || !stack.isEmpty()){
                if(cur!=null){
                    s.append(","+cur.val);
                    stack.push(cur);
                    cur=cur.left;
                } else{
                    s.append(",#");
                    cur=stack.pop().right;
                }
            }
            // Note this is critical as it's serializing the ending null node
            s.append(",#");
        }
    }
}
