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
            int num=a*7+b-7;
            if(num<=40){
                return num%10+1;
            } else{
                a=num-40;
                b=Random.rand7();
                num=a*7+b-7;
                if(num<=60){
                    return num%10+1;
                } else{
                    a=num-60;
                    b=Random.rand7();
                    num=a*7+b-7;
                    if(num<=20){
                        return num%10+1;
                    }
                }
            }
        }
    }

//    // Recursive
//    public int rand10(){
//        int random=Random.rand7()*7+Random.rand7()-7;
//        return random<=40?random%10+1:rand10();
//    }

//    // Iterative
//    public int rand10() {
//        int random=Random.rand7()*7+Random.rand7()-7;
//        while(random>40){
//            random=Random.rand7()*7+Random.rand7()-7;
//        }
//        return random%10+1;
//    }
}
