package com.wen.SixthFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LQClosestBinarySearchTreeValueII {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> result=new ArrayList<>();
        Stack<TreeNode> stack=new Stack<>();
        TreeNode cur=root;
        while(!stack.isEmpty() || cur!=null){
            if(cur!=null){
                stack.push(cur);
                cur=cur.left;
            } else{
                cur=stack.pop();
                if(result.size()<k){
                    result.add(cur.val);
                } else{
                    if(Math.abs(cur.val-target)>Math.abs(result.get(0)-target)){
                        break;
                    } else{
                        result.add(cur.val);
                        result.remove(0);
                    }
                }
                cur=cur.right;
            }
        }
        return result;
    }
}
