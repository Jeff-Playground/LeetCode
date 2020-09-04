package com.wen.TenthFifty;

public class MagicalString {
    public static int magicalString(int n) {
        if(n<=0){
            return 0;
        } else if(n<=3){
            return 1;
        }
        int last=2, total=3, idx=2, result=1;
        StringBuilder sb=new StringBuilder("122");
        while(total<n){
//            int cur=last==1?2:1;
            int cur=last^3;
            int count=sb.charAt(idx++)-'0';
            total+=count;
            if(cur==1){
                result+=count;
            }
            while(count-->0){
                sb.append(String.valueOf(cur));
            }
            last=cur;
        }
        if(last==1 && total>n){
            result-=total-n;
        }
        return result;
    }
}
