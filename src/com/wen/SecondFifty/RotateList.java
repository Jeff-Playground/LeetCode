package com.wen.SecondFifty;

public class RotateList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Make a circle first and then find the break point
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null || head.next==null) {
            return head;
        }
        int length=1;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy.next;
        while(cur.next!=null) {
            length++;
            cur=cur.next;
        }
        cur.next=dummy.next;
        k=k%length;
        for(int i=0; i<length-k; i++) {
            cur=cur.next;
        }
        dummy.next=cur.next;
        cur.next=null;
        return dummy.next;
    }

//    // Fast and slow cursor
//    public ListNode rotateRight(ListNode head, int k) {
//        if(k==0 || head==null || head.next==null) {
//            return head;
//        }
//        int length=1;
//        ListNode dummy=new ListNode(-1);
//        dummy.next=head;
//        ListNode cur=dummy.next;
//        while(cur.next!=null) {
//            length++;
//            cur=cur.next;
//        }
//        k=k%length;
//        ListNode fast=dummy.next, slow=dummy.next;
//        for(int i=0; i<k; i++) {
//            fast=fast.next;
//        }
//        while(fast.next!=null) {
//            fast=fast.next;
//            slow=slow.next;
//        }
//        fast.next=dummy.next;
//        dummy.next=slow.next;
//        slow.next=null;
//        return dummy.next;
//    }
}
