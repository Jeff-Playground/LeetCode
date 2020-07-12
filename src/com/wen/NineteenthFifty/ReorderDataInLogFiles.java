package com.wen.NineteenthFifty;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReorderDataInLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        if(logs==null){
            throw new IllegalArgumentException("Input log can't be null!");
        }
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int cmp = split1[1].compareTo(split2[1]);
                if (cmp != 0) return cmp;
                return split1[0].compareTo(split2[0]);
            }
            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
        });
        return logs;
    }

//    public String[] reorderLogFiles(String[] logs) {
//        if(logs==null){
//            throw new IllegalArgumentException("Input log can't be null!");
//        }
//        int l=logs.length;
//        String[] result=new String[l];
//        Queue<String> heap=new PriorityQueue<>(new Comparator<String>(){
//            @Override
//            public int compare(String s1, String s2){
//                int i1=s1.indexOf(" ");
//                int i2=s2.indexOf(" ");
//                String id1=s1.substring(0, i1);
//                String id2=s1.substring(0, i2);
//                String v1=s1.substring(i1+1);
//                String v2=s2.substring(i2+1);
//                if(v1.equals(v2)){
//                    return id1.compareTo(id2);
//                } else{
//                    return v1.compareTo(v2);
//                }
//            }
//        });
//        int p=l-1;
//        for(int i=l-1; i>=0; i--){
//            int index=logs[i].indexOf(" ");
//            String value=logs[i].substring(index+1);
//            if(value.charAt(0)>='0' && value.charAt(0)<='9'){
//                result[p--]=logs[i];
//            } else{
//                heap.offer(logs[i]);
//            }
//        }
//        int size=heap.size();
//        for(int i=0; i<size; i++){
//            result[i]=heap.poll();
//        }
//        return result;
//    }
}
