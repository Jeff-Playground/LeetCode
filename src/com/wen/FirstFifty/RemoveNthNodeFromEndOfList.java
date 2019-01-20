package com.wen.FirstFifty;

public class RemoveNthNodeFromEndOfList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur=head;
        ListNode pre=head;
        for(int i=0; i<n; i++){
            cur=cur.next;
        }
        if(cur==null){
            return head.next;
        } else{
            while(cur.next!=null){
                cur=cur.next;
                pre=pre.next;
            }
            pre.next=pre.next.next;
            return head;
        }
    }

//    // HashMap
//    public ListNode removeNthFromEnd(ListNode head, int n) {
//        Map<Integer, ListNode> map=new HashMap<Integer, ListNode>();
//        int i=1;
//        ListNode node=head;
//        while(node!=null){
//            map.put(i, node);
//            node=node.next;
//            i++;
//        }
//        int count=i-1;
//        int remove=count+1-n;
//        if(remove==1){
//            return head.next;
//        }
//        map.get(remove-1).next=map.get(remove).next;
//        return head;
//    }
}
