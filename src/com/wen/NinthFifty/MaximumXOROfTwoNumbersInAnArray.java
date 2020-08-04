package com.wen.NinthFifty;

import java.util.HashSet;
import java.util.Set;

public class MaximumXOROfTwoNumbersInAnArray {
    // Trie
    private class TrieNode{
        public TrieNode[] nodes;

        public TrieNode(){
            nodes=new TrieNode[2];
        }
    }

    public int findMaximumXOR(int[] nums){
        TrieNode root=new TrieNode();
        int result=0;
        for(int num: nums){
            TrieNode cur=root, opposite=root;
            int curMax=0;
            for(int i=0; i<32; i++){
                curMax<<=1;
                if(((num>>(31-i))&1)==0){
                    if(cur.nodes[0]==null){
                        cur.nodes[0]=new TrieNode();
                    }
                    if(opposite.nodes[1]!=null){
                        opposite=opposite.nodes[1];
                        curMax|=1;
                    } else{
                        opposite=opposite.nodes[0];
                    }
                    cur=cur.nodes[0];
                } else{
                    if(cur.nodes[1]==null){
                        cur.nodes[1]=new TrieNode();
                    }
                    if(opposite.nodes[0]!=null){
                        opposite=opposite.nodes[0];
                        curMax|=1;
                    } else{
                        opposite=opposite.nodes[1];
                    }
                    cur=cur.nodes[1];
                }
            }
            result=Math.max(result, curMax);
        }
        return result;
    }

//    // Bit manipulation, use the formula when a^b=result, then a=b^result
//    public int findMaximumXOR(int[] nums) {
//        int result=0, mask=0;
//        for(int i=31; i>=0; i--){
//            mask|=(1<<i);
//            Set<Integer> prefixes=new HashSet<>();
//            for(int num: nums){
//                prefixes.add(mask&num);
//            }
//            int temp=result|(1<<i);
//            for(int prefix: prefixes){
//                // This means for this bit, there exists a pair to make the same bit in result to be 1, and one of the
//                // number in this pair had already contributed to the existing result
//                if(prefixes.contains(temp^prefix)){
//                    result=temp;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
