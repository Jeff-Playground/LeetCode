package com.wen.SixthFifty;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        int l=secret.length();
        int A=0, B=0;
        int[] count=new int[10];
        for(int i=0; i<l; i++){
            char s=secret.charAt(i);
            char g=guess.charAt(i);
            if(s==g){
                A++;
            } else{
                if(count[s-'0']++<0){
                    B++;
                }
                if(count[g-'0']-->0){
                    B++;
                }
            }
        }
        return A+"A"+B+"B";
    }

//    public String getHint(String secret, String guess) {
//        int l=secret.length();
//        int A=0, B=0;
//        int[] count=new int[10];
//        int[] miss=new int[10];
//        for(int i=0; i<l; i++){
//            char s=secret.charAt(i);
//            char g=guess.charAt(i);
//            if(s==g){
//                A++;
//            } else{
//                count[s-'0']++;
//                miss[g-'0']++;
//            }
//        }
//        for(int i=0; i<10; i++){
//            B+=Math.min(count[i], miss[i]);
//        }
//        return A+"A"+B+"B";
//    }
}
