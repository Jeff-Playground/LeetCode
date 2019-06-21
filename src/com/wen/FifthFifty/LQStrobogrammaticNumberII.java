package com.wen.FifthFifty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LQStrobogrammaticNumberII {
    // BFS
    public List<String> findStrobogrammatic(int n) {
        List<String> seed= Arrays.asList("");
        int i=0;
        if(n%2==1) {
            i=1;
            seed=Arrays.asList("0", "1", "8");
        }
        while(i<n) {
            List<String> cur=new ArrayList<>();
            for(String s: seed) {
                if(i!=n-2) {
                    cur.add("0"+s+"0");
                }
                cur.add("1"+s+"1");
                cur.add("6"+s+"9");
                cur.add("8"+s+"8");
                cur.add("9"+s+"6");
            }
            seed=cur;
            i+=2;
        }
        return seed;
    }

//    // DFS
//    public List<String> findStrobogrammatic(int n) {
//        int count=n/2;
//        List<String> result=new ArrayList<>();
//        char[] validChars=new char[] {'0', '1', '6', '8','9'};
//        findStrobogrammaticDFS(n, count, validChars, 0, new StringBuilder(String.valueOf(new char[n])), result);
//        return result;
//    }
//
//    private void findStrobogrammaticDFS(int n, int count, char[] validChars, int index, StringBuilder sb, List<String> result) {
//        if(index==count) {
//            if(n%2==0) {
//                result.add(sb.toString());
//            } else {
//                for(char c: validChars) {
//                    if(c!='6' && c!='9') {
//                        sb.setCharAt(count, c);
//                        result.add(sb.toString());
//                    }
//                }
//            }
//        } else {
//            for(char c: validChars) {
//                if(index==0 && c=='0') {
//                    continue;
//                }
//                sb.setCharAt(index, c);
//                char cMirror=c=='6'?'9':(c=='9'?'6':c);
//                sb.setCharAt(n-1-index, cMirror);
//                findStrobogrammaticDFS(n, count, validChars, index+1, sb, result);
//            }
//        }
//    }
}
