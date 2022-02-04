package com.wen.ThirteenthFifty;

import java.util.LinkedList;
import java.util.Queue;

public class DotaTwoSenate {
//    // Brute force
//    public String predictPartyVictory(String senate) {
//        char[] array=senate.toCharArray();
//        int l=senate.length();
//        int countR=0, countD=0;
//        for(char c: array){
//            if(c=='R'){
//                countR++;
//            } else{
//                countD++;
//            }
//        }
//        while(countR>0 && countD>0){
//            for(int i=0; i<l; i++){
//                char c=array[i];
//                if(c==' '){
//                    continue;
//                }
//                for(int j=i+1; j<i+l; j++){
//                    if((c=='R' && array[j%l]=='D') || (c=='D' && array[j%l]=='R')){
//                        array[j%l]=' ';
//                        if(c=='R'){
//                            countD--;
//                        } else{
//                            countR--;
//                        }
//                        break;
//                    }
//                }
//            }
//        }
//        return countR==0?"Dire":"Radiant";
//    }

    // Use 2 Queue to track the 2 groups
    public String predictPartyVictory(String senate) {
        int l=senate.length();
        Queue<Integer> q1=new LinkedList<>(), q2=new LinkedList<>();
        for(int i=0; i<l; i++){
            char c=senate.charAt(i);
            if(c=='R'){
                q1.offer(i);
            } else{
                q2.offer(i);
            }
        }
        while(!q1.isEmpty() && !q2.isEmpty()){
            int s1=q1.poll(), s2=q2.poll();
            // Note here +l to ensure each senate doesn't make a second move for the same round
            if(s1<s2){
                q1.offer(s1+l);
            } else{
                q2.offer(s2+l);
            }
        }
        return q1.isEmpty()?"Dire":"Radiant";
    }
}
