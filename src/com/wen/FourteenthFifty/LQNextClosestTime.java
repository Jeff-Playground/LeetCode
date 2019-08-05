package com.wen.FourteenthFifty;

public class LQNextClosestTime {
    public static String nextClosestTime(String time) {
        int[] nums=new int[10];
        int[] limits=new int[]{2,3,5,9};
        for(int i=0; i<5; i++){
            if(i!=2){
                nums[time.charAt(i)-'0']++;
            }
        }
        for(int i=4; i>=0; i--){
            if(i==2){
                continue;
            }
            int k=i<2?i:i-1;
            int num=time.charAt(i)-'0';
            for(int j=num+1; j<=limits[k]; j++){
                if(nums[j]>0){
                    char first=(char)('0'+j);
                    if(i<4){
                        char second=(char)('0'+num);
                        for(int m=0; m<=num; m++){
                            if(nums[m]>0){
                                second=(char)('0'+m);
                                break;
                            }
                        }
                        String remain="";
                        for(int cur=i+1; cur<5; cur++){
                            if(cur==2){
                                remain+=":";
                            } else{
                                remain+=second;
                            }
                        }
                        return time.substring(0,i)+first+remain;
                    } else{
                        return time.substring(0,4)+first;
                    }
                }
            }
        }
        char min=time.charAt(0);
        return ""+min+min+":"+min+min;
    }
}
