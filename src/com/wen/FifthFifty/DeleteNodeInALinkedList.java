package com.wen.FifthFifty;

public class DeleteNodeInALinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public void deleteNode(ListNode node) {
        if(node!=null && node.next!=null){
            node.val=node.next.val;
            node.next=node.next.next;
        }
    }

//    public void deleteNode(ListNode node) {
//        if(node!=null && node.next!=null){
//            while(node.next!=null){
//                node.val=node.next.val;
//                if(node.next.next==null){
//                    node.next=null;
//                    return;
//                }
//                node=node.next;
//            }
//            node=null;
//        }
//    }
}
