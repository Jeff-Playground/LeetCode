package com.wen.FourthFifty;
import java.util.Stack;

public class BinarySearchTreeIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    class BSTIterator {
        private Stack<TreeNode> stack=new Stack<>();

        public BSTIterator(TreeNode root) {
            TreeNode cur=root;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
        }

        /** @return the next smallest number */
        public int next() {
            TreeNode result=stack.pop();
            TreeNode cur=result.right;
            while(cur!=null){
                stack.push(cur);
                cur=cur.left;
            }
            return result.val;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
