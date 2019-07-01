package com.wen.SecondFifty;

public class PartitionList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    // Iterate over the original list
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode cur=dummy;
        while(cur.next!=null){
            if(cur.next.val>=x){
                break;
            } else{
                cur=cur.next;
            }
        }
        ListNode nodeBeforeX=cur;
        while(cur.next!=null){
            if(cur.next.val<x){
                ListNode next=cur.next.next;
                ListNode move=cur.next;
                move.next=nodeBeforeX.next;
                nodeBeforeX.next=move;
                nodeBeforeX=nodeBeforeX.next;
                cur.next=next;
            } else{
                cur=cur.next;
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
