package com.wen.EleventhFifty;

import java.util.*;

public class RandomFlipMatrix {
    // Use a HashMap to store flipped nodes as key, for value let it point to a non-flipped node, it will either be the
    // last node or the corresponding value of last node if it's flipped
    class Solution {
        int m, n, size;
        Map<Integer, Integer> flipped;

        public Solution(int n_rows, int n_cols) {
            m=n_rows;
            n=n_cols;
            size=m*n;
            flipped=new HashMap<>();
        }

        public int[] flip() {
            Random r=new Random();
            int cur=r.nextInt(size);
            size--;
            while(flipped.containsKey(cur)){
                cur=flipped.get(cur);
            }
            flipped.put(cur, flipped.containsKey(size)?flipped.get(size):size);
            return new int[]{cur/n, cur%n};
        }

        public void reset() {
            flipped=new HashMap<>();
            size=m*n;
        }
    }

//    // Use a HashSet to store flipped nodes
//    class Solution {
//        int m, n;
//        Set<Integer> flipped;
//
//        public Solution(int n_rows, int n_cols) {
//            m=n_rows;
//            n=n_cols;
//            flipped=new HashSet<>();
//        }
//
//        public int[] flip() {
//            Random r=new Random();
//            int cur=r.nextInt(m*n);
//            while(flipped.contains(cur)){
//                cur=r.nextInt(m*n);
//            }
//            flipped.add(cur);
//            return new int[]{cur/n, cur%n};
//        }
//
//        public void reset() {
//            flipped=new HashSet<>();
//        }
//    }
}
