package com.wen.ThirdFifty;

public class LinkedListCycleII {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next=null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast=head, slow=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(fast==null || fast.next==null){
            return null;
        }
        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}
