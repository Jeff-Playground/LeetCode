package com.wen.TenthFifty;

public class ImplementRand10UsingRand7 {
    private interface Random{
        static int rand7() {
            return 0;
        }
    }

    public int rand10() {
        while(true){
            int a=Random.rand7(), b=Random.rand7();
            int num=(a-1)*7+b;  // Like Rand49()
            if(num<=40){
                return num%10+1;
            } else{
                a=num-40;   // Like Rand9()
                b=Random.rand7();
                num=(a-1)*7+b;  // Like Rand63()
                if(num<=60){
                    return num%10+1;
                } else{
                    a=num-60;   // Like Rand3()
                    b=Random.rand7();
                    num=(a-1)*7+b;  // Like Rand21()
                    if(num<=20){
                        return num%10+1;
                    }
                }
            }
        }
    }

//    // Recursive
//    public int rand10(){
//        int random=(Random.rand7()-1)*7+Random.rand7();
//        return random<=40?random%10+1:rand10();
//    }

//    // Iterative
//    public int rand10() {
//        int random=(Random.rand7()-1)*7+Random.rand7();
//        while(random>40){
//            random=(Random.rand7()-1)*7+Random.rand7();
//        }
//        return random%10+1;
//    }
}
