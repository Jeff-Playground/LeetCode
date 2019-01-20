package com.wen.FirstFifty;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        helper(n, n, "", res);
        return res;
    }

    private void helper(int left, int right, String out, List<String> res) {
        if(left<0 || right<0 || left>right) {
            return;
        }
        if(left==0&&right==0) {
            res.add(out);
            return;
        }
        helper(left-1, right, out+"(", res);
        helper(left, right-1, out+")", res);
    }

//    // "()" after "(" and at last put "()" at the front
//    public List<String> generateParenthesis(int n) {
//        Set<String> res=new HashSet<String>();
//        if(n==0) {
//            res.add("");
//        }else {
//            List<String> pre=generateParenthesis(n-1);
//            for(String str: pre) {
//                for(int i=0; i<str.length(); i++) {
//                    if(str.charAt(i)=='(') {
//                        str=str.substring(0, i+1) + "()" + str.substring(i+1, str.length());
//                        res.add(str);
//                        str=str.substring(0, i+1)+str.substring(i+3,str.length());
//                    }
//                }
//                res.add("()"+str);
//            }
//        }
//        return new ArrayList(res);
//    }
}
