package com.wen.ThirdFifty;

import java.rmi.activation.ActivationGroup_Stub;

public class InsertionSortList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next=null;
        }
    }

    // O(n^2) time complexity with O(1) space complexity
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy=new ListNode(-1);
        ListNode cur=dummy;
        ListNode p=head;
        while(p!=null){
            ListNode temp=p.next;
            cur=dummy;
            while(cur.next!=null && cur.next.val<=p.val) {
                cur=cur.next;
            }
            p.next=cur.next;
            cur.next=p;
            p=temp;
        }
        return dummy.next;
    }
}
