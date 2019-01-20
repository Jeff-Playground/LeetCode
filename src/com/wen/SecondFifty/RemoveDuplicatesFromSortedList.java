package com.wen.SecondFifty;

public class RemoveDuplicatesFromSortedList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // One cursor
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cursor=head;
        if(cursor== null || cursor.next==null){
            return head;
        }
        while(cursor!=null){
            if(cursor.next==null || cursor.val!=cursor.next.val){
                cursor=cursor.next;
            } else{
                cursor.next=cursor.next.next;
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
