package com.wen.SeventhFifty;

public class OddEvenLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {
        if(head!=null){
            int count=1;
            ListNode cur=head;
            while(cur.next!=null){
                count++;
                cur=cur.next;
            }
            if(count>2){
                ListNode end=cur;
                cur=head;
                for(int i=0; i<count/2; i++){
                    ListNode next=cur.next.next;
                    end.next=cur.next;
                    end=end.next;
                    end.next=null;
                    cur.next=next;
                    cur=cur.next;
                }
            }
        }
        return head;
    }
}
