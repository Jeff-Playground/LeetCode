package com.wen.FourteenthFifty;

/*
If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

For each integer in this list:

The hundreds digit represents the depth D of this node, 1 <= D <= 4.

The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same
as that in a full binary tree.

The units digit represents the value V of this node, 0 <= V <= 9.


Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return
the sum of all paths from the root towards the leaves.

Example 1:
Input: [113, 215, 221]
Output: 12
Explanation:
The tree that the list represents is:

    3
   / \
  5   1

The path sum is (3 + 5) + (3 + 1) = 12.


Example 2:
Input: [113, 221]
Output: 4
Explanation:
The tree that the list represents is:

    3
     \
      1

The path sum is (3 + 1) = 4.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LQPathSumIV {
    // Preorder traversal
    public int pathSum(int[] nums) {
        Map<Integer, Integer> tree=new HashMap<>();
        for(int num: nums){
            tree.put(num/10, num%10);
        }
        int[] result=new int[]{0};
        pathSumHelper(tree, 11, tree.get(11), result);
        return result[0];
    }

    private void pathSumHelper(Map<Integer, Integer> tree, int idx, int cur, int[] result){
        int left=(idx/10+1)*10+(idx%10)*2-1, right=left+1;
        if(!tree.containsKey(left) && !tree.containsKey(right)){
            result[0]+=cur;
        } else{
            if(tree.containsKey(left)){
                pathSumHelper(tree, left, cur+tree.get(left), result);
            }
            if(tree.containsKey(right)){
                pathSumHelper(tree, right, cur+tree.get(right), result);
            }
        }
    }

//    public int pathSum(int[] nums) {
//        Map<Integer, Integer> cache=new HashMap<>();
//        for(int num: nums){
//            int level=num/100, idx=(num-level*100)/10, val=num%10;
//            if(level==1){
//                cache.put(num/10, val);
//            } else{
//                int parentSum=cache.get((level-1)*10+(idx+1)/2);
//                cache.put(num/10, val+parentSum);
//            }
//        }
//        int result=0;
//        for(int key: cache.keySet()){
//            int level=key/10, idx=key%10;
//            if(!cache.containsKey((level+1)*10+idx*2) && !cache.containsKey((level+1)*10+idx*2-1)){
//                result+=cache.get(key);
//            }
//        }
//        return result;
//    }

//    // Level order traversal
//    public int pathSum(int[] nums) {
//        Map<Integer, Integer> tree=new HashMap<>();
//        for(int num: nums){
//            tree.put(num/10, num%10);
//        }
//        Queue<Integer> q=new LinkedList<>();
//        q.offer(11);
//        int result=0;
//        while(!q.isEmpty()){
//            int cur=q.poll();
//            int left=(cur/10+1)*10+(cur%10)*2-1, right=left+1;
//            if(!tree.containsKey(left) && !tree.containsKey(right)){
//                result+=tree.get(cur);
//            } else{
//                if(tree.containsKey(left)){
//                    tree.put(left, tree.get(left)+tree.get(cur));
//                    q.offer(left);
//                }
//                if(tree.containsKey(right)){
//                    tree.put(right, tree.get(right)+tree.get(cur));
//                    q.offer(right);
//                }
//            }
//        }
//        return result;
//    }
}
