package com.wen.EleventhFifty;

import java.util.PriorityQueue;

public class RelativeRanks {
    // Use PriorityQueue
    public String[] findRelativeRanks(int[] nums) {
        if(nums==null || nums.length==0){
            throw new IllegalArgumentException("Invalid input!");
        }
        int l=nums.length;
        String[] result=new String[l];
        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b)->b[0]-a[0]);
        for(int i=0; i<l; i++){
            pq.offer(new int[]{nums[i], i});
        }
        int rank=1;
        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            if(rank==1){
                result[cur[1]]="Gold Medal";
            } else if(rank==2){
                result[cur[1]]="Silver Medal";
            } else if(rank==3){
                result[cur[1]]="Bronze Medal";
            } else{
                result[cur[1]]=String.valueOf(rank);
            }
            rank++;
        }
        return result;
    }

//    // Use TreeMap
//    public String[] findRelativeRanks(int[] nums) {
//        if(nums==null || nums.length==0){
//            throw new IllegalArgumentException("Invalid input!");
//        }
//        int l=nums.length;
//        String[] result=new String[l];
//        Map<Integer, Integer> sort=new TreeMap<>((a, b)->b-a);
//        for(int i=0; i<l; i++){
//            sort.put(nums[i], i);
//        }
//        int rank=1;
//        for(int key: sort.keySet()){
//            if(rank==1){
//                result[sort.get(key)]="Gold Medal";
//            } else if(rank==2){
//                result[sort.get(key)]="Silver Medal";
//            } else if(rank==3){
//                result[sort.get(key)]="Bronze Medal";
//            } else{
//                result[sort.get(key)]=String.valueOf(rank);
//            }
//            rank++;
//        }
//        return result;
//    }

//    // Use Array
//    public String[] findRelativeRanks(int[] nums) {
//        if(nums==null || nums.length==0){
//            throw new IllegalArgumentException("Invalid input!");
//        }
//        int l=nums.length;
//        String[] result=new String[l];
//        int[] copy=Arrays.copyOf(nums, l);
//        Arrays.sort(copy);
//        for(int i=0; i<l; i++){
//            int num=nums[i];
//            int left=0, right=l-1;
//            while(left<right){
//                int mid=left+(right-left)/2;
//                if(copy[mid]<num){
//                    left=mid+1;
//                } else{
//                    right=mid;
//                }
//            }
//            if(left==l-1){
//                result[i]="Gold Medal";
//            } else if(left==l-2){
//                result[i]="Silver Medal";
//            } else if(left==l-3){
//                result[i]="Bronze Medal";
//            } else{
//                result[i]=String.valueOf(l-left);
//            }
//        }
//        return result;
//    }
}
