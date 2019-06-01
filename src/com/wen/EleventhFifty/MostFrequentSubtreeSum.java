package com.wen.EleventhFifty;

import java.util.*;

public class MostFrequentSubtreeSum {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null){
            return new int[]{};
        }
        Map<Integer, Set<Integer>> freqs=new TreeMap<>();
        Map<Integer, Integer> count=new HashMap<>();
        findFrequentTreeSumDFS(root, freqs, count);
        return ((TreeMap<Integer, Set<Integer>>) freqs).lastEntry().getValue().stream().mapToInt(i->i).toArray();
    }

    public int findFrequentTreeSumDFS(TreeNode node, Map<Integer, Set<Integer>> freqs, Map<Integer, Integer> count){
        if(node==null){
            return 0;
        }
        int left=findFrequentTreeSumDFS(node.left, freqs, count);
        int right=findFrequentTreeSumDFS(node.right, freqs, count);
        int val=node.val+left+right;
        if(count.containsKey(val)){
            int freq=count.get(val);
            count.put(val, freq+1);
            freqs.get(freq).remove(val);
            Set<Integer> set=freqs.get(freq+1);
            if(set==null){
                set=new HashSet<>();
            }
            set.add(val);
            freqs.put(freq+1, set);
        } else{
            count.put(val, 1);
            Set<Integer> set=freqs.get(1);
            if(set==null){
                set=new HashSet<>();
            }
            set.add(val);
            freqs.put(1, set);
        }
        return val;
    }
}
