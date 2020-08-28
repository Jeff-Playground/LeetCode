package com.wen.TwentyFirstFifty;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterNodeInLinkedList {
    public class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public int[] nextLargerNodes(ListNode head) {
        if(head==null){
            throw new IllegalArgumentException("Invalid input!");
        }
        ListNode cur=head;
        List<Integer> vals=new ArrayList<>();
        while(cur!=null){
            vals.add(cur.val);
            cur=cur.next;
        }
        int l=vals.size();
        int[] result=new int[l];
        cur=head;
        Stack<Integer> stack=new Stack<>();
        for(int i=0; i<l; i++){
            while(!stack.isEmpty() && vals.get(i)>vals.get(stack.peek())){
                result[stack.pop()]=vals.get(i);
            }
            stack.push(i);
        }
        return result;
    }

//    public int[] nextLargerNodes(ListNode head) {
//        if(head==null){
//            throw new IllegalArgumentException("Invalid input!");
//        }
//        int l=0;
//        ListNode dummy=new ListNode(-1);
//        ListNode cur=head;
//        while(cur!=null){
//            l++;
//            ListNode next=cur.next;
//            cur.next=dummy.next;
//            dummy.next=cur;
//            cur=next;
//        }
//        int[] result=new int[l];
//        cur=dummy.next;
//        Stack<Integer> stack=new Stack<>();
//        for(int i=l-1; i>=0; i--){
//            while(!stack.isEmpty() && stack.peek()<=cur.val){
//                stack.pop();
//            }
//            result[i]=stack.isEmpty()?0:stack.peek();
//            stack.push(cur.val);
//            cur=cur.next;
//        }
//        return result;
//    }
}
