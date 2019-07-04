package com.wen.ThirdFifty;

import java.rmi.activation.ActivationGroup_Stub;

public class InsertionSortList {
    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) {
            val = x;
            next=null;
        }
    }

    // O(n^2) time complexity with O(1) space complexity
    public static ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=head;
        while(cur!=null){
            ListNode next=cur.next;
            ListNode temp=dummy;
            while(temp.next!=null && temp.next.val<cur.val){
                temp=temp.next;
            }
            ListNode tempNext=temp.next;
            temp.next=cur;
            cur.next=tempNext;
            cur=next;
        }
        return dummy.next;
    }
}
