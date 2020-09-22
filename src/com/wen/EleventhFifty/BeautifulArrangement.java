package com.wen.EleventhFifty;

public class BeautifulArrangement {
    // DFS2, swap eligible numbers into position, note in the end need to check the last position to ensure all positions
    // are checked and valid
    public static int countArrangement(int N) {
        int[] result=new int[]{0};
        int[] nums=new int[N];
        for(int i=1; i<=N; i++){
            nums[i-1]=i;
        }
        caHelper(0, nums, result);
        return result[0];
    }

    private static void caHelper(int cur, int[] nums, int[] result){
        if(cur==nums.length-1 && (nums[cur]%(cur+1)==0 || (cur+1)%nums[cur]==0)){
            result[0]++;
        } else{
            for(int i=cur; i<nums.length; i++){
                if((nums[i]%(cur+1)==0 || (cur+1)%nums[i]==0)){
                    int temp=nums[cur];
                    nums[cur]=nums[i];
                    nums[i]=temp;
                    caHelper(cur+1, nums, result);
                    nums[i]=nums[cur];
                    nums[cur]=temp;
                }
            }
        }
    }

//    // DFS1, choose number for each index
//    public int countArrangement(int N) {
//        int[] result=new int[1];
//        caHelper(1, N, new int[N], 0, result);
//        return result[0];
//    }
//
//    private void caHelper(int cur, int max, int[] visited, int count, int[] result){
//        if(count==max){
//            result[0]++;
//        } else{
//            for(int i=0; i<visited.length; i++){
//                if(visited[i]==0 && ((i+1)%cur==0 || cur%(i+1)==0)){
//                    visited[i]=1;
//                    caHelper(cur+1, max, visited, count+1, result);
//                    visited[i]=0;
//                }
//            }
//        }
//    }
}
