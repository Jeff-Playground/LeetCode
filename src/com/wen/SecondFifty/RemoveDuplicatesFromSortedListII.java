package com.wen.SecondFifty;

public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode start=new ListNode(-1);
        start.next=head;
        ListNode slow=start;
        ListNode fast=head;
        while(fast!=null){
            if(fast.next==null || fast.val!=fast.next.val){
                if(slow.next==fast){
                    slow=fast;
                } else{
                    slow.next=fast.next;
                }
                fast=fast.next;
            } else{
                fast=fast.next;
            }
        }
        return start.next;
    }
}
