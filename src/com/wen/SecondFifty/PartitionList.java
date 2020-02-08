package com.wen.SecondFifty;

public class PartitionList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // Iterate over the original list
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy, lastLess=null;
        while(cur!=null){
            if(lastLess==null){
                if(cur.next!=null && cur.next.val>=x){
                    lastLess=cur;
                }
                cur=cur.next;
            } else{
                if(cur.next!=null && cur.next.val<x){
                    ListNode temp=cur.next;
                    cur.next=cur.next.next;
                    temp.next=lastLess.next;
                    lastLess.next=temp;
                    lastLess=lastLess.next;
                } else{
                    cur=cur.next;
                }
            }
        }
        return dummy.next;
    }

//    // Make two lists and merge
//    public ListNode partition(ListNode head, int x) {
//        ListNode dummy1=new ListNode(-1);
//        ListNode dummy2=new ListNode(-1);
//        ListNode less=dummy1;
//        ListNode more=dummy2;
//        ListNode cur=head;
//        while(cur!=null){
//            if(cur.val<x){
//                less.next=cur;
//                less=less.next;
//            } else{
//                more.next=cur;
//                more=more.next;
//            }
//            cur=cur.next;
//        }
//        more.next=null;
//        less.next=dummy2.next;
//        return dummy1.next;
//    }
}
