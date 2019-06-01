package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class LQEqualTreePartition {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> occur=new HashMap<>();
        int total=checkEqualTreeDFS(root, occur);
        if(total%2==0){
            if((total==0 && occur.get(0)>1) || (total!=0 && occur.containsKey(total/2))){
                return true;
            }
        }
        return false;
    }

    public int checkEqualTreeDFS(TreeNode node, Map<Integer, Integer> occur){
        if(node==null){
            return 0;
        } else{
            int val=node.val+checkEqualTreeDFS(node.left, occur)+checkEqualTreeDFS(node.right, occur);
            occur.put(val, occur.getOrDefault(val, 0)+1);
            return val;
        }
    }
}
