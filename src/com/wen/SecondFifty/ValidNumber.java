package com.wen.SecondFifty;

public class ValidNumber {
    // Normal way
    public static boolean isNumber(String s) {
        if(s==null) {
            return false;
        }
        s=s.trim();
        if(s.length()==0) {
            return false;
        }
        boolean onlyDot=false, dotFlag=false, expFlag=false, signFlag=false, digitFlag=false;
        for(char c: s.toCharArray()) {
            if(c=='+' || c=='-') {
                if(dotFlag || signFlag || digitFlag) {
                    return false;
                } else {
                    signFlag=true;
                }
            } else if(c>='0' && c<='9') {
                digitFlag=true;
                onlyDot=false;
            } else if(c=='.') {
                if(dotFlag || expFlag) {
                    return false;
                } else {
                    if(digitFlag==false) {
                        onlyDot=true;
                    }
                    dotFlag=true;
                }
            } else if(c=='e' || c=='E') {
                if(expFlag || !digitFlag) {
                    return false;
                } else {
                    dotFlag=false;
                    signFlag=false;
                    digitFlag=false;
                    expFlag=true;
                }
            } else {
                return false;
            }
        }
        if(onlyDot) {
            return false;
        }
        return digitFlag;
    }

//    // Regular Expression
//    public static boolean isNumber(String s) {
//        if(s==null || s.trim().length()==0) {
//            return false;
//        }
//        String regex="[-+]?(\\d+\\.?|\\.\\d+)\\d*([eE][-+]?\\d+)?";
//        return s.trim().matches(regex);
//    }

//    // Finite Automata Machine
//    enum InputType{
//        INVALID,
//        SPACE,
//        SIGN,
//        DIGIT,
//        DOT,
//        EXPONENT
//    }
//
//    public boolean isNumber(String s) {
//        int[][] transTable=new int[][] {
//                {-1,0,3,1,2,-1},		//0初始无输入或者只有space的状态
//                {-1,8,-1,1,4,5},		//1输入了数字之后的状态
//                {-1,-1,-1,4,-1,-1},		//2前面无数字，只输入了Dot的状态
//                {-1,-1,-1,1,2,-1},		//3输入了符号状态
//                {-1,8,-1,4,-1,5},		//4前面有数字和有dot的状态
//                {-1,-1,6,7,-1,-1},		//5'e' or 'E'输入后的状态
//                {-1,-1,-1,7,-1,-1},		//6输入e之后输入Sign的状态
//                {-1,8,-1,7,-1,-1},		//7输入e后输入数字的状态
//                {-1,8,-1,-1,-1,-1}		//8前面有有效数输入之后，输入space的状态
//        };
//        int state=0;
//        for(char c:s.toCharArray()) {
//            InputType input=InputType.INVALID;
//            if(c==' ') {
//                input=InputType.SPACE;
//            } else if(c=='+' || c=='-') {
//                input=InputType.SIGN;
//            } else if(c>='0' && c<='9') {
//                input=InputType.DIGIT;
//            } else if(c=='.') {
//                input=InputType.DOT;
//            } else if(c=='e' || c=='E') {
//                input=InputType.EXPONENT;
//            }
//            state=transTable[state][input.ordinal()];
//            if(state==-1) {
//                return false;
//            }
//        }
//        return state==1 || state==4 || state==7 || state==8;
//    }
}
