package com.wen.TwelfthFifty;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        if(!expression.startsWith("-")){
            expression="+"+expression;
        }
        expression+="+";
        int numerator=0, denominator=1;
        int n=0, d=1, sign=1;
        boolean den=false;
        for(char c: expression.toCharArray()){
            if(c=='+' || c=='-'){
                den=false;
                if(denominator==d){
                    numerator+=sign*n;
                } else{
                    numerator=numerator*d+sign*n*denominator;
                    denominator*=d;
                }
                int gcd=gcd(Math.abs(numerator), Math.abs(denominator));
                numerator/=gcd;
                denominator/=gcd;
                sign=c=='+'?1:-1;
                n=0;
                d=0;
            } else if(c>='0' && c<='9'){
                if(den){
                    d=d*10+(c-'0');
                } else{
                    n=n*10+(c-'0');
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
