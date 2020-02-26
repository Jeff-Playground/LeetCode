package com.wen.FourteenthFifty;

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    // Segment tree
    // Value here stands for the count of subsequences with length in the corresponding range(the range the node stands
    // for -- [leftRange, rightRange])
    class Value{
        int length;
        int count;
        public Value(int l, int c) {
            length=l;
            count=c;
        }
    }

    class Node{
        int leftRange, rightRange;
        Node left, right;
        Value v;

        public Node(int l, int r) {
            leftRange=l;
            rightRange=r;
            left=null;
            right=null;
            v=new Value(0, 1);
        }

        public int getRangeMid() {
            return leftRange+(rightRange-leftRange)/2;
        }

        public Node getLeft() {
            if(left==null) {
                left=new Node(leftRange, getRangeMid());
            }
            return left;
        }

        public Node getRight() {
            if(right==null) {
                right=new Node(getRangeMid()+1, rightRange);
            }
            return right;
        }
    }

    public int findNumberOfLIS(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for(int num: nums) {
            min=Math.min(min, num);
            max=Math.max(max, num);
        }
        Node root=new Node(min, max);
        for(int num: nums) {
            Value v=query(root, num-1);
            insert(root, num, new Value(v.length+1, v.count));
        }
        return query(root, max).count;
    }

    private void insert(Node node, int key, Value value) {
        if(node.leftRange==node.rightRange) {
            node.v=merge(node.v, value);
            return;
        } else if(key<=node.getRangeMid()){
            insert(node.getLeft(), key, value);
        } else {
            insert(node.getRight(), key, value);
        }
        node.v=merge(node.getLeft().v, node.getRight().v);
    }

    private Value query(Node node, int max) {
        if(max>=node.rightRange) {
            return node.v;
        } else if(max<node.leftRange) {
            return new Value(0, 1);
        } else {
            return merge(query(node.getLeft(), max), query(node.getRight(), max));
        }
    }

    private Value merge(Value v1, Value v2) {
        if(v1.length==v2.length) {
            if(v1.length==0) {
                return v1;      // This is essentially returning new Value(0,1) without creating a new object
            } else {
                return new Value(v1.length, v1.count+v2.count);
            }
        } else {
            return v1.length>v2.length?v1:v2;
        }
    }

//    // DP
//    // dp[i] stands for the length of longest increasing subsequence ends with nums[i], count[i] stands for the number
//    // of the LIS ends with nums[i]
//    public int findNumberOfLIS(int[] nums) {
//        if(nums==null || nums.length==0) {
//            return 0;
//        }
//        int l=nums.length;
//        int[] dp=new int[l];
//        int[] count=new int[l];
//        Arrays.fill(dp, 1);
//        Arrays.fill(count, 1);
//        int maxLength=1, maxCount=1;
//        for(int i=1; i<l; i++) {
//            for(int j=i-1; j>=0 && j>=dp[i]-2; j--) {
//                if(nums[j]<nums[i]) {
//                    if(dp[j]+1>dp[i]) {
//                        dp[i]=dp[j]+1;
//                        count[i]=count[j];
//                    } else if(dp[j]+1==dp[i]) {
//                        count[i]+=count[j];
//                    }
//                }
//            }
//            if(dp[i]>maxLength) {
//                maxLength=dp[i];
//                maxCount=count[i];
//            } else if(dp[i]==maxLength) {
//                maxCount+=count[i];
//            }
//        }
//        return maxCount;
//    }
}
