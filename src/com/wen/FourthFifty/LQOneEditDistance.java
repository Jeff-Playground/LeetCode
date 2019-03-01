package com.wen.FourthFifty;

public class LQOneEditDistance {
    // Optimized
    public boolean isOneEditDistance(String s, String t) {
        if(s.length()<t.length()){
            return isOneEditDistance(t, s);
        }
        for(int i=0; i<t.length(); i++){
            if(s.charAt(i)!=t.charAt(i)){
                if(s.length()==t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                } else{
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        return s.length()-t.length()==1;
    }

//    public boolean isOneEditDistance(String s, String t) {
//        if(s.length()<t.length()){
//            return isOneEditDistance(t, s);
//        }
//        int m=s.length(), n=t.length(), diff=m-n;
//        if(diff>1){
//            return false;
//        } else if(diff==1){
//            for(int i=0; i<n; i++){
//                if(s.charAt(i)!=t.charAt(i)){
//                    return s.substring(i+1).equals(t.substring(i));
//                }
//            }
//            return true;
//        } else{
//            int count=0;
//            for(int i=0; i<n; i++){
//                if(s.charAt(i)!=t.charAt(i)){
//                    count++;
//                }
//            }
//            return count==1;
//        }
//    }
}
