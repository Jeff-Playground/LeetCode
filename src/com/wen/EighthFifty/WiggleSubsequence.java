package com.wen.EighthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WiggleSubsequence {
    // DP, pos stores the maximum length of subsequence ends at nums[i] where last pair is positive, neg stores the
    // maximum length of subsequence ends at nums[i] where last pair is negative
    public int wiggleMaxLength(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int l=nums.length;
        int[] pos=new int[l], neg=new int[l];
        Arrays.fill(pos, 1);
        Arrays.fill(neg, 1);
        for(int i=1; i<l; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    pos[i]=Math.max(pos[i], neg[j]+1);
                } else if(nums[i]<nums[j]){
                    neg[i]=Math.max(neg[i], pos[j]+1);
                }
            }
        }
        return Math.max(pos[l-1], neg[l-1]);
    }

//    // Greedy, pos is the count of the sequence for when the last pair is positive, and neg is the count of the sequence
//    // when the last pair is negative
//    public int wiggleMaxLength(int[] nums) {
//        int pos=1, neg=1, l=nums.length;
//        for(int i=1; i<l; i++){
//            if(nums[i]>nums[i-1]){
//                pos=neg+1;
//            } else if(nums[i]<nums[i-1]){
//                neg=pos+1;
//            }
//        }
//        return Math.min(l, Math.max(pos, neg));
//    }

//    // Greedy, where the seq List maintains the subsequence
//    public static int wiggleMaxLength(int[] nums) {
//        if(nums==null || nums.length==0){
//            return 0;
//        } else if(nums.length==1){
//            return 1;
//        } else{
//            List<Integer> seq=new ArrayList<>();
//            Boolean positive=null;
//            for(int num: nums){
//                if(seq.size()==0){
//                    seq.add(num);
//                } else{
//                    int last=seq.get(seq.size()-1);
//                    if(num!=last){
//                        if(positive==null || (positive && num<last) || (!positive && num>last)){
//                            seq.add(num);
//                            positive=last<num;
//                        } else{
//                            if(positive){
//                                seq.set(seq.size()-1, Math.max(last, num));
//                            } else{
//                                seq.set(seq.size()-1, Math.min(last, num));
//                            }
//                        }
//                    }
//                }
//            }
//            return seq.size();
//        }
//    }
}
