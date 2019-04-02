package com.wen.FifthFifty;

public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Recursive
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) {
            return head;
        }
        ListNode newHead=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newHead;
    }

//    // Iterative
//    public ListNode reverseList(ListNode head) {
//        ListNode dummy=new ListNode(-1);
//        ListNode cur=head;
//        while(cur!=null) {
//            ListNode next=cur.next;
//            ListNode temp=dummy.next;
//            dummy.next=cur;
//            cur.next=temp;
//            cur=next;
//        }
//        return dummy.next;
//    }
}
