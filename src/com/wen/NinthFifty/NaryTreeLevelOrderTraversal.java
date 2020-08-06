package com.wen.NinthFifty;

public class NaryTreeLevelOrderTraversal {
    public static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val){
            this.val=val;
        }
    }

    // Recursive optimized
    public Node flatten(Node head) {
        flattenHelper(head);
        return head;
    }

    private Node flattenHelper(Node head){
        if(head==null){
            return null;
        } else{
            Node cur=head, last=null;
            while(cur!=null){
                if(cur.child!=null){
                    Node next=cur.next;
                    Node end=flattenHelper(cur.child);
                    cur.next=cur.child;
                    cur.child.prev=cur;
                    cur.child=null;
                    if(next!=null){
                        end.next=next;
                        next.prev=end;
                    }
                    cur=next;
                    last=end;
                } else{
                    last=cur;
                    cur=cur.next;
                }
            }
            return last;
        }
    }

//    // Iterative
//    public Node flatten(Node head) {
//        if(head==null){
//            return null;
//        }
//        Node cur=head;
//        while(cur!=null){
//            if(cur.child!=null){
//                Node next=cur.next;
//                cur.next=cur.child;
//                cur.child.prev=cur;
//                cur.child=null;
//                Node last=cur.next;
//                if(next!=null){
//                    while(last.next!=null){
//                        last=last.next;
//                    }
//                    last.next=next;
//                    next.prev=last;
//                }
//            } else{
//                cur=cur.next;
//            }
//        }
//        return head;
//    }

//    // Recursive
//    public Node flatten(Node head) {
//        if(head==null){
//            return null;
//        }
//        Node cur=head;
//        while(cur!=null){
//            if(cur.child!=null){
//                Node next=cur.next;
//                cur.next=flatten(cur.child);
//                cur.next=cur.child;
//                cur.child.prev=cur;
//                cur.child=null;
//                Node last=cur.next;
//                if(next!=null){
//                    while(last.next!=null){
//                        last=last.next;
//                    }
//                    last.next=next;
//                    next.prev=last;
//                }
//            } else{
//                cur=cur.next;
//            }
//        }
//        return head;
//    }
}
