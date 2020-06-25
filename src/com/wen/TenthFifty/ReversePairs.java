package com.wen.TenthFifty;

public class ReversePairs {
    // Segment tree
    private class SegmentTree{
        SegmentTree left, right;
        int low, up;
        int count;

        public SegmentTree(int low, int up){
            this.low=low;
            this.up=up;
            this.count=0;
        }

        public void update(int num){
            if(num>=low && num<=up){
                count++;
                if(low!=up){
                    getLeft().update(num);
                    getRight().update(num);
                }
            }
        }

        public int query(int num){
            if(num>=up){
                return count;
            } else if(num>=low && num<up){
                return getLeft().query(num)+getRight().query(num);
            } else{
                return 0;
            }
        }

        private SegmentTree getLeft(){
            if(left==null){
                left=new SegmentTree(low, getMid());
            }
            return left;
        }

        private SegmentTree getRight(){
            if(right==null){
                right=new SegmentTree(getMid()+1, up);
            }
            return right;
        }

        // Note here use long to avoid overflow
        private int getMid(){
            long mid=(long)low+((long)up-(long)low)/2;
            return (int)mid;
        }
    }

    public int reversePairs(int[] nums) {
        int l=nums.length, result=0, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        for(int num: nums){
            min=Math.min(min, num);
            max=Math.max(max, num);
        }
        SegmentTree root=new SegmentTree(min, max);
        for(int i=l-1; i>=0; i--){
            // Note here when num<=0, num/2*2>=num, so it should be num/2-1
            result+=nums[i]%2==0||nums[i]<=0?root.query(nums[i]/2-1):root.query(nums[i]/2);
            root.update(nums[i]);
        }
        return result;
    }
}
