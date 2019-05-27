package com.wen.FifthFifty;

import java.util.Stack;

public class PalindromeLinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    // Using a stack
//    public boolean isPalindrome(ListNode head) {
//        if(head==null){
//            return true;
//        }
//        ListNode slow=head, fast=head;
//        Stack<Integer> stack=new Stack<>();
//        stack.push(slow.val);
//        while(fast.next!=null && fast.next.next!=null){
//            fast=fast.next.next;
//            slow=slow.next;
//            stack.push(slow.val);
//        }
//        if(fast.next==null){
//            stack.pop();
//        }
//        slow=slow.next;
//        while(slow!=null){
//            int val=stack.pop();
//            if(slow.val!=val){
//                return false;
//            }
//            slow=slow.next;
//        }
//        return true;
//    }

    // O(1) space complexity: Reverse the second part of the list
    public boolean isPalindrome(ListNode head) {
        if(head==null){
            return true;
        }
        ListNode slow=head, fast=head;
        ListNode dummy=new ListNode(-1);
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            ListNode temp=slow.next;
            slow.next=dummy.next;
            dummy.next=slow;
            slow=temp;
        }
        if(fast.next!=null){
            ListNode temp=slow.next;
            slow.next=dummy.next;
            dummy.next=slow;
            slow=temp;
        } else{
            slow=slow.next;
        }
        ListNode cur=dummy.next;
        while(cur!=null){
            if(slow.val!=cur.val){
                return false;
            }
            cur=cur.next;
            slow=slow.next;
        }
        return true;
    }
}
