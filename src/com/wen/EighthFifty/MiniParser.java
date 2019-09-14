package com.wen.EighthFifty;

import java.util.List;
import java.util.Stack;

public class MiniParser {
    public interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();


        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value);

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni);

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList();
    }

//    public NestedInteger deserialize(String s) {
//        if(s==null && s.isEmpty()) {
//            return null;
//        } else if(!s.startsWith("[")){
//            return new NestedInteger(Integer.parseInt(s));
//        } else{
//            int l=s.length();
//            Stack<NestedInteger> stack=new Stack<>();
//            int start=0;
//            for(int i=0; i<l; i++) {
//                char c=s.charAt(i);
//                if(c=='[') {
//                    stack.push(new NestedInteger());
//                    start=i+1;
//                } else if(c==',' || c==']') {
//                    if(start<i) {
//                        stack.peek().add(deserialize(s.substring(start,  i)));
//                    }
//                    start=i+1;
//                    if(c==']') {
//                        NestedInteger cur=stack.pop();
//                        if(stack.empty()) {
//                            return cur;
//                        } else {
//                            stack.peek().add(cur);
//                        }
//                    }
//                }
//            }
//            return null;
//        }
//    }

//    public NestedInteger deserialize(String s) {
//        if(s==null || s.isEmpty()) {
//            return null;
//        } else if(!s.startsWith("[")) {
//            return new NestedInteger(Integer.parseInt(s));
//        } else if(s.length()<=2) {
//            return new NestedInteger();
//        } else {
//            int l=s.length();
//            NestedInteger result=new NestedInteger();
//            int level=0, start=1;
//            for(int i=1; i<l; i++) {
//                char c=s.charAt(i);
//                if(level==0 && (i==l-1 || c==',')) {
//                    result.add(deserialize(s.substring(start, i)));
//                    start=i+1;
//                } else if(c=='[') {
//                    level++;
//                } else if(c==']') {
//                    level--;
//                }
//            }
//            return result;
//        }
//    }

//    public NestedInteger deserialize(String s) {
//        if(s==null || s.isEmpty()) {
//            return null;
//        } else {
//            NestedInteger result=new NestedInteger();
//            int l=s.length();
//            int val=0, sign=1;
//            boolean isInteger=!s.contains("[") && !s.contains(",");
//            for(int i=0; i<l; i++) {
//                char c=s.charAt(i);
//                if(isNumber(c)) {
//                    val=val*10+(c-'0');
//                    if(i+1==l || !isNumber(s.charAt(i+1))) {
//                        if(isInteger) {
//                            result.setInteger(val*sign);
//                            return result;
//                        } else {
//                            result.add(new NestedInteger(val*sign));
//                            val=0;
//                            sign=1;
//                        }
//                    }
//                } else if(c=='-') {
//                    sign*=-1;
//                } else if(c=='[') {
//                    if(i>0) {
//                        int count=1;
//                        for(int j=i+1; j<l; j++) {
//                            if(s.charAt(j)=='[') {
//                                count++;
//                            } else if(s.charAt(j)==']') {
//                                count--;
//                                if(count==0) {
//                                    NestedInteger sub=deserialize(s.substring(i, j+1));
//                                    result.add(sub);
//                                    i=j+1;
//                                    break;
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//            return result;
//        }
//    }
//
//    private boolean isNumber(char c) {
//        return c>='0' && c<='9';
//    }
}
