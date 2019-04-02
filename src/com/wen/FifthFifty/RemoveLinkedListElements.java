package com.wen.FifthFifty;

public class RemoveLinkedListElements {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    // Recursive
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) {
            return null;
        }
        head.next=removeElements(head.next, val);
        return head.val==val ? head.next : head;
    }

//    // Iterative
//    public ListNode removeElements(ListNode head, int val) {
//        while(head!=null && head.val==val) {
//            head=head.next;
//        }
//        if(head==null) {
//            return null;
//        } else {
//            ListNode cur=head;
//            while(cur.next!=null) {
//                if(cur.next.val==val) {
//                    cur.next=cur.next.next;
//                } else {
//                    cur=cur.next;
//                }
//            }
//        }
//        return head;
//    }
}
