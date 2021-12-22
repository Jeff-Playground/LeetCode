package com.wen.NineteenthFifty;

import java.util.Stack;

public class OnlineStockSpan {
    // Monotonic stack
    class StockSpanner {
        private Stack<int[]> stack;

        public StockSpanner() {
            stack=new Stack<>();
        }

        public int next(int price) {
            int count=1;
            while(!stack.isEmpty() && stack.peek()[0]<=price){
                int[] priv=stack.pop();
                count+=priv[1];
            }
            stack.push(new int[]{price, count});
            return count;
        }
    }
}
