package com.wen.SixteenthFifty;

/*
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and
empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648,
2147483647].

Some examples:
"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12

Note: Do not use the eval built-in library function.
 */

public class LQBasicCalculatorIII {
    public int calculate(String s) {
        int l=s.length();
        int result=0, pre=0, cur=0;
        char sign='+';
        for(int i=0; i<=l; i++){
            char c=i<l?s.charAt(i):'$';
            if(c!=' '){
                if(c>='0' && c<='9'){
                    cur=cur*10+(c-'0');
                } else{
                    if(c=='('){
                        int count=1;
                        for(int j=i+1; j<l; j++){
                            if(s.charAt(j)=='('){
                                count++;
                            } else if(s.charAt(j)==')'){
                                count--;
                                if(count==0){
                                    cur=calculate(s.substring(i+1, j));
                                    i=j;
                                    break;
                                }
                            }
                        }
                    } else if(sign=='+' || sign=='-'){
                        result+=pre;
                        pre=sign=='+'?cur:-cur;
                        cur=0;
                        sign=c;
                    } else if(sign=='*' || sign=='/'){
                        pre=sign=='*'?pre*cur:pre/cur;
                        cur=0;
                        sign=c;
                    }
                    if(c=='$'){
                        result+=pre;
                    }
                }
            }
        }
        return result;
    }
}
