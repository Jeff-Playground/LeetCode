package com.wen.SeventhFifty;

import java.util.*;

public class RemoveInvalidParentheses {
    // Iterative with queue
    public List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        Set<String> checked=new HashSet<>();
        checked.add(s);
        Queue<String> queue=new LinkedList<>();
        queue.offer(s);
        boolean found=false;
        while(!queue.isEmpty()) {
            String t=queue.poll();
            if(isValid(t)) {
                result.add(t);
                found=true;
            }
            if(found) {
                continue;
            }
            for(int i=0; i<t.length(); i++) {
                if(t.charAt(i)!='(' && t.charAt(i)!=')') {
                    continue;
                }
                String str=t.substring(0, i)+t.substring(i+1);
                if(!checked.contains(str)) {
                    queue.offer(str);
                    checked.add(str);
                }
            }
        }
        return result;
    }

    private static boolean isValid(String t) {
        int count=0;
        for(int i=0; i<t.length(); i++) {
            if(t.charAt(i)=='(') {
                count++;
            } else if(t.charAt(i)==')') {
                if(count==0) {
                    return false;
                } else {
                    count--;
                }
            }
        }
        return count==0;
    }

//    // DFS
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result=new ArrayList<>();
//        int cl=0, cr=0;
//        for(char c: s.toCharArray()) {
//            if(c=='(') {
//                cl++;
//            } else if(c==')') {
//                if(cl==0) {
//                    cr++;
//                } else {
//                    cl--;
//                }
//            }
//        }
//        removeInvalidParenthesesDFS(s, 0, cl, cr, result);
//        return result;
//    }
//
//    private void removeInvalidParenthesesDFS(String s, int start, int cl, int cr, List<String> result) {
//        if(cl==0 && cr==0) {
//            if(isValid(s)) {
//                result.add(s);
//            }
//        }
//        for(int i=start; i<s.length(); i++) {
//            if(i!=start && s.charAt(i)==s.charAt(i-1)) {
//                continue;
//            }
//            if(cl>0 && s.charAt(i)=='(') {
//                removeInvalidParenthesesDFS(s.substring(0, i)+s.substring(i+1), i, cl-1, cr, result);
//            }
//            if(cr>0 && s.charAt(i)==')') {
//                removeInvalidParenthesesDFS(s.substring(0, i)+s.substring(i+1), i, cl, cr-1, result);
//            }
//        }
//    }
//
//    private boolean isValid(String s) {
//        int count=0;
//        for(int i=0; i<s.length(); i++) {
//            if(s.charAt(i)=='(') {
//                count++;
//            } else if(s.charAt(i)==')') {
//                count--;
//                if(count<0) {
//                    return false;
//                }
//            }
//        }
//        return count==0;
//    }
}
