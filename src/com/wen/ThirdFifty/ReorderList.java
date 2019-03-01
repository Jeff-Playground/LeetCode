package com.wen.ThirdFifty;

import java.util.Stack;

public class ReorderList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void reorderList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) {
            return;
        }
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        while(cur!=null) {
            stack.push(cur);
            cur=cur.next;
        }
        int count=(stack.size()-1)/2;
        cur=head;
        while(count-->0) {
            ListNode temp=stack.pop();
            ListNode next=cur.next;
            temp.next=next;
            cur.next=temp;
            cur=next;
        }
        stack.peek().next=null;
    }

//    public void reorderList(ListNode head) {
//        if(head==null || head.next==null || head.next.next==null) {
//            return;
//        }
//        ListNode slow=head, fast=head;
//        while(fast.next!=null && fast.next.next!=null) {
//            slow=slow.next;
//            fast=fast.next.next;
//        }
//        ListNode mid=slow.next;
//        slow.next=null;
//        ListNode next=mid;
//        ListNode pre=null;
//        while(next!=null) {
//            ListNode temp=next.next;
//            next.next=pre;
//            pre=next;
//            next=temp;
//        }
//        slow=head;
//        fast=pre;
//        while(slow!=null && fast!=null) {
//            ListNode temp=fast.next;
//            fast.next=slow.next;
//            slow.next=fast;
//            slow=slow.next.next;
//            fast=temp;
//        }
//    }
}
