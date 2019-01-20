package com.wen.SecondFifty;

public class ReverseLinkedListII {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode mPre=dummy, nNext=dummy;
        for(int i=1; i<m; i++){
            mPre=mPre.next;
        }
        nNext=mPre.next;
        ListNode front=null, last=mPre.next;
        for(int i=m; i<=n; i++){
            nNext=nNext.next;
            ListNode cur=mPre.next;
            mPre.next=cur.next;
            cur.next=front;
            front=cur;
        }
        mPre.next=front;
        last.next=nNext;
        return dummy.next;
    }
}
