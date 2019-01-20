package com.wen.FirstFifty;

public class TrappingRainWater {
    // Two pointers
    public int trap(int[] height) {
        int result=0, left=0, right=height.length-1;
        while(left<right) {
            int min=Math.min(height[left], height[right]);
            if(height[left]<=height[right]) {
                left++;
                while(left<right && height[left]<min) {
                    result+=min-height[left++];
                }
            }else {
                right--;
                while(left<right && height[right]<min) {
                    result+=min-height[right--];
                }
            }
        }
        return result;
    }

//    // Dynamic Programming
//    public static int trap(int[] height) {
//        int result=0, mx=0, n=height.length;
//        int[] dp=new int[n];
//        for(int i=0; i<n; i++){
//            dp[i]=mx;
//            mx=Math.max(mx, height[i]);
//        }
//        mx=0;
//        for(int i=n-1; i>=0; i--){
//            dp[i]=Math.min(dp[i],mx);
//            mx=Math.max(mx, height[i]);
//            if(dp[i]-height[i]>0){
//                result+=dp[i]-height[i];
//            }
//        }
//        return result;
//    }

//    // Stack
//    public int trap(int[] height) {
//        Stack<Integer> s=new Stack<Integer>();
//        int i=0, n=height.length, result=0;
//        while(i<n){
//            if(s.isEmpty() || height[i]<=height[s.peek()]){
//                s.push(i++);
//            }else{
//                int t=s.pop();
//                if(s.isEmpty()){
//                    continue;
//                }
//                result+=(Math.min(height[i], height[s.peek()])-height[t])*(i-s.peek()-1);
//            }
//        }
//        return result;
//    }
}
