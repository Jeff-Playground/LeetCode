package com.wen.TwentyFourthFifty;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class FizzBuzzMultithreaded {
    private class IntConsumer implements Consumer<Integer>{

        @Override
        public void accept(Integer o) {

        }
    }

    // Use AtomicInteger
    class FizzBuzz {
        private int n;
        private AtomicInteger curNum;

        public FizzBuzz(int n) {
            this.n = n;
            curNum=new AtomicInteger(1);
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            int cur;
            while((cur=curNum.get())<=n){
                if(cur%3==0 && cur%5!=0){
                    printFizz.run();
                    curNum.incrementAndGet();
                }
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            int cur;
            while((cur=curNum.get())<=n){
                if(cur%3!=0 && cur%5==0){
                    printBuzz.run();
                    curNum.incrementAndGet();
                }
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            int cur;
            while((cur=curNum.get())<=n){
                if(cur%3==0 && cur%5==0){
                    printFizzBuzz.run();
                    curNum.incrementAndGet();
                }
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            int cur;
            while((cur=curNum.get())<=n){
                if(cur%3!=0 && cur%5!=0){
                    printNumber.accept(cur);
                    curNum.incrementAndGet();
                }
            }
        }
    }

//    // Use synchronized
//    class FizzBuzz {
//        private int n;
//        private int curNum;
//
//        public FizzBuzz(int n) {
//            this.n = n;
//            this.curNum=1;
//        }
//
//        // printFizz.run() outputs "fizz".
//        public synchronized void fizz(Runnable printFizz) throws InterruptedException {
//            while(curNum<=n){
//                if(curNum%3==0 && curNum%5!=0){
//                    printFizz.run();
//                    curNum++;
//                }
//            }
//        }
//
//        // printBuzz.run() outputs "buzz".
//        public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
//            while(curNum<=n){
//                if(curNum%3!=0 && curNum%5==0){
//                    printBuzz.run();
//                    curNum++;
//                }
//            }
//        }
//
//        // printFizzBuzz.run() outputs "fizzbuzz".
//        public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//            while(curNum<=n){
//                if(curNum%3==0 && curNum%5==0){
//                    printFizzBuzz.run();
//                    curNum++;
//                }
//            }
//        }
//
//        // printNumber.accept(x) outputs "x", where x is an integer.
//        public synchronized void number(IntConsumer printNumber) throws InterruptedException {
//            while(curNum<=n){
//                if(curNum%3!=0 && curNum%5!=0){
//                    printNumber.accept(curNum);
//                    curNum++;
//                }
//            }
//        }
//    }
}
