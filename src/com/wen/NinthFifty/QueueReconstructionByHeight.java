package com.wen.NinthFifty;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    // In-place
    public int[][] reconstructQueue(int[][] people) {
        int l=people.length;
        int[][] result=new int[l][2];
        Arrays.sort(people, (a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        int index=0;
        for(int i=0; i<l; i++){
            int[] p=people[i];
            if(p[1]!=i+1){
                int target=p[1];
                int j=i;
                while(j!=target){
                    people[j]=people[j-1];
                    j--;
                }
                people[j]=p;
            }
        }
        return people;
    }

//    public int[][] reconstructQueue(int[][] people) {
//        int l=people.length;
//        int[][] result=new int[l][2];
//        Arrays.sort(people, (a, b)->a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
//        int index=0;
//        for(int i=0; i<l; i++){
//            int[] p=people[i];
//            if(index==0){
//                result[index++]=p;
//            } else{
//                int last=index-1;
//                while(last+1>p[1]){
//                    last--;
//                }
//                int j=index++;
//                while(j-1>last){
//                    result[j]=result[j-1];
//                    j--;
//                }
//                result[j]=p;
//            }
//        }
//        return result;
//    }
}
