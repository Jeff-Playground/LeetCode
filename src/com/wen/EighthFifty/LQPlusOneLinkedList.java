package com.wen.EighthFifty;

/*
Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

Example :
Input: [1,2,3]
Output: [1,2,4]
 */

import java.util.Stack;

public class LQPlusOneLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Get the fist none 9 node, plus 1 to it, and set all nodes after it to 0
    public ListNode plusOne(ListNode head) {
        ListNode lastNotNine=null, cur=head;
        while(cur!=null){
            if(cur.val!=9){
                lastNotNine=cur;
            }
            cur=cur.next;
        }
        if(lastNotNine==null){
            ListNode newHead=new ListNode(1);
            newHead.next=head;
            cur=head;
            head=newHead;
        } else{
            lastNotNine.val++;
            cur=lastNotNine.next;
        }
        while(cur!=null){
            cur.val=0;
            cur=cur.next;
        }
        return head;
    }

//    // Recursive
//    public ListNode plusOne(ListNode head) {
//        int carry=poHelper(head);
//        if(carry==1){
//            ListNode newHead=new ListNode(1);
//            newHead.next=head;
//            return newHead;
//        } else{
//            return head;
//        }
//    }
//
//    private int poHelper(ListNode cur){
//        if(cur==null){
//            return 1;
//        }
//        int carry=poHelper(cur.next);
//        if(carry==1){
//            if(cur.val<9){
//                cur.val++;
//                return 0;
//            } else{
//                cur.val=0;
//                return 1;
//            }
//        } else{
//            return 0;
//        }
//    }

//    // In-place, revert first, calculate, then revert again
//    public ListNode plusOne(ListNode head) {
//        ListNode reverse=new ListNode(-1);
//        ListNode cur=head;
//        while(cur!=null){
//            ListNode next=cur.next;
//            cur.next=reverse.next;
//            reverse.next=cur;
//            cur=next;
//        }
//        cur=reverse.next;
//        while(cur!=null){
//            if(cur.val<9){
//                cur.val++;
//                break;
//            } else{
//                cur.val=0;
//                if(cur.next!=null){
//                    cur=cur.next;
//                } else{
//                    ListNode newTail=new ListNode(1);
//                    cur.next=newTail;
//                    break;
//                }
//            }
//        }
//        cur=reverse.next;
//        reverse.next=null;
//        while(cur!=null){
//            ListNode next=cur.next;
//            cur.next=reverse.next;
//            reverse.next=cur;
//            cur=next;
//        }
//        return reverse.next;
//    }

//    // Stack
//    public ListNode plusOne(ListNode head) {
//        Stack<ListNode> stack=new Stack();
//        ListNode cur=head;
//        while(cur!=null){
//            stack.push(cur);
//            cur=cur.next;
//        }
//        int carry=0;
//        while(!stack.isEmpty()){
//            cur=stack.peek();
//            if(cur.val<9){
//                cur.val++;
//                break;
//            } else{
//                cur.val=0;
//                stack.pop();
//                carry=1;
//            }
//        }
//        if(!stack.isEmpty()){
//            return head;
//        } else{
//            ListNode newHead=new ListNode(1);
//            newHead.next=head;
//            return newHead;
//        }
//    }
}
