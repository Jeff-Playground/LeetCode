package com.wen.SecondFifty;

public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // One cursor
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur=head;
        if(cur== null || cur.next==null){
            return head;
        }
        while(cur!=null){
            if(cur.next==null || cur.val!=cur.next.val){
                cur=cur.next;
            } else{
                cur.next=cur.next.next;
            }
        }
        return head;
    }

    // Two cursors
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode slow=head, fast=head;
        while(fast!=null){
            if(fast.next==null || fast.val!=fast.next.val){
                slow.next=fast.next;
                slow=slow.next;
                fast=fast.next;
            } else{
                fast=fast.next;
            }
        }
        return head;
    }
}
