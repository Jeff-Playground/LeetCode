package com.wen.SecondFifty;

public class PartitionList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode dummy1=new ListNode(-1);
        ListNode dummy2=new ListNode(-1);
        ListNode less=dummy1;
        ListNode more=dummy2;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val<x){
                less.next=cur;
                less=less.next;
            } else{
                more.next=cur;
                more=more.next;
            }
            cur=cur.next;
        }
        more.next=null;
        less.next=dummy2.next;
        return dummy1.next;
    }
}
