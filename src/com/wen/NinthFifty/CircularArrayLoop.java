package com.wen.NinthFifty;

public class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return false;
        } else {
            int l = nums.length;
            for(int i=0; i<l; i++){
                if(nums[i]==0){
                    continue;
                }
                int slow=i, fast=getNext(nums, i), start=nums[i];
                while(start*nums[fast]>0 && start*nums[getNext(nums, fast)]>0){
                    if(fast==slow){
                        if(slow==getNext(nums, slow)){
                            break;
                        } else{
                            return true;
                        }
                    }
                    slow=getNext(nums, slow);
                    fast=getNext(nums, getNext(nums, fast));
                }
                slow=i;
                while(start*nums[slow]>0){
                    int temp=getNext(nums, slow);
                    nums[slow]=0;
                    slow=temp;
                }
            }
        }
        return false;
    }

    public int getNext(int[] nums, int cur){
        int l=nums.length;
        return ((cur+nums[cur])%l+l)%l;
    }

//    public boolean circularArrayLoop(int[] nums) {
//        if (nums == null || nums.length <= 1) {
//            return false;
//        } else {
//            int l = nums.length;
//            int[] checked = new int[l];
//            int cur = 0, count = 0, positive = nums[cur] > 0 ? 1 : -1;
//            while (count < l) {
//                int[] visited = new int[l];
//                while (visited[cur] == 0 && nums[cur] * positive > 0) {
//                    visited[cur] = 1;
//                    if (checked[cur] == 0) {
//                        count++;
//                        checked[cur] = 1;
//                    }
//                    cur = ((cur + nums[cur]) % l + l) % l;
//                }
//                if (visited[cur] == 1 && cur != ((cur + nums[cur]) % l + l) % l) {
//                    return true;
//                } else {
//                    if(count==l){
//                        return false;
//                    }
//                    while (checked[cur] == 1) {
//                        cur = (cur + 1 + l) % l;
//                    }
//                    positive = nums[cur] > 0 ? 1 : -1;
//                }
//            }
//            return false;
//        }
//    }
}
