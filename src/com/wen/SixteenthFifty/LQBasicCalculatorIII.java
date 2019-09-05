package com.wen.SixteenthFifty;

public class LQBasicCalculatorIII {
    public int calculate(String s) {
        int l=s.length();
        int pre=0, cur=0, result=0;
        char preOpt='+';
        for(int i=0; i<l; i++){
            char c=s.charAt(i);
            if(c>='0' && c<='9'){
                cur=cur*10+c-'0';
            }
            if(i==l-1 || c=='+' || c== '-' || c=='*' || c=='/' || c=='('){
                if(c=='('){
                    int bracketCount=1;
                    for(int j=i+1; j<l; j++){
                        if(s.charAt(j)=='('){
                            bracketCount++;
                        } else if(s.charAt(j)==')'){
                            bracketCount--;
                        }
                        if(bracketCount==0){
                            cur=calculate(s.substring(i+1, j));
                            i=j-1;
                            break;
                        }
                    }
                } else{
                    switch(preOpt){
                        case '+':
                            pre+=cur;
                            break;
                        case '-':
                            pre-=cur;
                            break;
                        case '*':
                            pre*=cur;
                            break;
                        case '/':
                            pre/=cur;
                            break;
                    }
                    if(i==l-1 || c=='+' || c=='-'){
                        result+=pre;
                        pre=0;
                    }
                    cur=0;
                    preOpt=c;
                }
            }
        }
        return result;
    }
}
