package com.wen.SeventhFifty;

import java.util.*;

public class RemoveInvalidParentheses {
//    // Remove right "token" only, as it always produces one step further to the valid result
//    public List<String> removeInvalidParentheses(String s) {
//        List<String> result=new ArrayList<>();
//        removeInvalidParenthesesHelper(s, 0, 0, new char[]{'(', ')'}, result);
//        return result;
//    }
//
//    private void removeInvalidParenthesesHelper(String s, int start, int lastRemove, char[] token, List<String> result) {
//        int count=0;
//        for(int i=start; i<s.length(); i++){
//            char c=s.charAt(i);
//            if(c==token[0]){
//                count++;
//            } else if(c==token[1]){
//                count--;
//            }
//            if(count<0){
//                for(int j=lastRemove; j<=i; j++){
//                    char cj=s.charAt(j);
//                    if(cj==token[1] && (j==lastRemove || cj!=s.charAt(j-1))){
//                        removeInvalidParenthesesHelper(s.substring(0, j)+s.substring(j+1), i, j, token, result);
//                    }
//                }
//                return;
//            }
//        }
//        String r=new StringBuilder(s).reverse().toString();
//        // If token[0]==')', it means the removing has been done for both directions, so count==0 and produced a valid
//        // string for result
//        if(token[0]=='('){
//            removeInvalidParenthesesHelper(r, 0, 0, new char[]{')', '('}, result);
//        } else{
//            result.add(r);
//        }
//    }

//    // BFS
//    public static List<String> removeInvalidParentheses(String s) {
//        List<String> result=new ArrayList<>();
//        Set<String> checked=new HashSet<>();
//        checked.add(s);
//        Queue<String> queue=new LinkedList<>();
//        queue.offer(s);
//        // When found is first set to true, it means the first valid string is found, and for remaining strings just
//        // need to check if it's valid, for invalid ones no need to further remove characters because all the result
//        // strings should be appearing in the same level(at this level removed a certain number of parentheses)
//        boolean found=false;
//        while(!queue.isEmpty()) {
//            String t=queue.poll();
//            if(isValid(t)) {
//                result.add(t);
//                found=true;
//            }
//            if(!found) {
//                for(int i=0; i<t.length(); i++) {
//                    if(t.charAt(i)=='(' || t.charAt(i)==')') {
//                        String str=t.substring(0, i)+t.substring(i+1);
//                        if(!checked.contains(str)) {
//                            queue.offer(str);
//                            checked.add(str);
//                        }
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private static boolean isValid(String t) {
//        int count=0;
//        for(int i=0; i<t.length(); i++) {
//            if(t.charAt(i)=='(') {
//                count++;
//            } else if(t.charAt(i)==')') {
//                if(count==0) {
//                    return false;
//                } else {
//                    count--;
//                }
//            }
//        }
//        return count==0;
//    }

    // DFS
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result=new ArrayList<>();
        int cl=0, cr=0;
        for(char c: s.toCharArray()) {
            if(c=='(') {
                cl++;
            } else if(c==')') {
                if(cl==0) {
                    cr++;
                } else {
                    cl--;
                }
            }
        }
        removeInvalidParenthesesDFS(s, 0, cl, cr, result);
        return result;
    }

    private static void removeInvalidParenthesesDFS(String s, int start, int cl, int cr, List<String> result) {
        if(cl==0 && cr==0) {
            if(isValid(s)) {
                result.add(s);
                return;
            }
        }
        for(int i=start; i<s.length(); i++) {
            if(i!=start && s.charAt(i)==s.charAt(i-1)) {
                continue;
            }
            if(cl>0 && s.charAt(i)=='(') {
                removeInvalidParenthesesDFS(s.substring(0, i)+s.substring(i+1), i, cl-1, cr, result);
            }
            if(cr>0 && s.charAt(i)==')') {
                removeInvalidParenthesesDFS(s.substring(0, i)+s.substring(i+1), i, cl, cr-1, result);
            }
        }
    }

    private static boolean isValid(String s) {
        int count=0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i)=='(') {
                count++;
            } else if(s.charAt(i)==')') {
                count--;
                if(count<0) {
                    return false;
                }
            }
        }
        return count==0;
    }
}
