package com.wen.EighthFifty;

import java.util.Random;

public class LinkedListRandomNode {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    class Solution {
        ListNode head;
        Random r=new Random();

        /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        public Solution(ListNode head) {
            this.head=head;
        }

        /** Returns a random node's value. */
        public int getRandom() {
            int result=head.val;
            ListNode cur=head.next;
            int i=2;
            while(cur!=null){
                if(r.nextInt(i)==0){
                    result=cur.val;
                }
                i++;
                cur=cur.next;
            }
            return result;
        }
    }
}
