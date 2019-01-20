package com.wen.FirstFifty;

public class SwapNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy;
        while(pre.next!=null) {
            ListNode first=pre.next;
            ListNode second=first.next;
            if(pre.next.next==null) {
                break;
            } else {
                pre.next=second;
                first.next=second.next;
                second.next=first;
                pre=first;
            }
        }
        return dummy.next;
    }

//    // Recursive
//    public ListNode swapPairs(ListNode head) {
//        if(head==null || head.next==null) {
//            return head;
//        }
//        ListNode t=head.next;
//        head.next=swapPairs(head.next.next);
//        t.next=head;
//        return t;
//    }
}
