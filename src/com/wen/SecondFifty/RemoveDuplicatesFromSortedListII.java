package com.wen.SecondFifty;

public class RemoveDuplicatesFromSortedListII {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode pre=dummy, cur=head;
        while(cur!=null){
            if(cur.next==null){
                break;
            }
            if(cur.next.val!=cur.val){
                pre=cur;
                cur=cur.next;
            } else{
                int val=cur.val;
                while(cur!=null && cur.val==val){
                    cur=cur.next;
                }
                pre.next=cur;
            }
        }
        return dummy.next;
    }
}
