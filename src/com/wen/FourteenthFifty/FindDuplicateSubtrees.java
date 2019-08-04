package com.wen.FourteenthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateSubtrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result=new ArrayList<>();
        Map<String, Integer> map=new HashMap<>();
        findDuplicateSubtreesHelper(root, map, result);
        return result;
    }

    public String findDuplicateSubtreesHelper(TreeNode node, Map<String, Integer> map, List<TreeNode> result){
        if(node==null){
            return "null";
        } else{
            String left=findDuplicateSubtreesHelper(node.left, map, result);
            String right=findDuplicateSubtreesHelper(node.right, map, result);
            String nodeString=node.val+left+right;
            if(map.containsKey(nodeString)){
                if(map.get(nodeString)==1){
                    map.put(nodeString, 2);
                    result.add(node);
                }
            } else{
                map.put(nodeString, 1);
            }
            return nodeString;
        }
    }
}
