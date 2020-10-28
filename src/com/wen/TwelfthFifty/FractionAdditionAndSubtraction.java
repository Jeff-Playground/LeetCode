package com.wen.TwelfthFifty;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        if(!expression.startsWith("-")){
            expression="+"+expression;
        }
        expression+="+";
        int numerator=0, denominator=1;
        int last=0, cur=1, pos=1;
        boolean den=false;
        for(char c: expression.toCharArray()){
            if(c=='+' || c=='-'){
                den=false;
                if(denominator==cur){
                    numerator+=pos*last;
                } else{
                    numerator=numerator*cur+pos*last*denominator;
                    denominator*=cur;
                }
                int gcd=gcd(Math.abs(numerator), Math.abs(denominator));
                numerator/=gcd;
                denominator/=gcd;
                pos=c=='+'?1:-1;
                last=0;
                cur=0;
            } else if(c>='0' && c<='9'){
                if(den){
                    cur=cur*10+(c-'0');
                } else{
                    last=last*10+(c-'0');
                }
            } else if(c=='/'){
                den=true;
            }
        }
        return numerator+"/"+denominator;
    }

    private int gcd(int a, int b){
        if(a<b){
            return gcd(b, a);
        }
        if(b==0){
            return a;
        }
        if(a%2==0 && b%2==0){
            return 2*gcd(a>>1, b>>1);
        } else if(a%2==0){
            return gcd(a>>1, b);
        } else if(b%2==0){
            return gcd(a, b>>1);
        } else{
            return gcd(a-b, b);
        }
    }

//    private int gcd(int a, int b){
//        return b==0?a:gcd(b, a%b);
//    }
}
