package com.wen.FifteenthFifty;

public class DesignLinkedList {
    // Doubly linked list
    public static class MyLinkedList {    class DoublyLinkedNode{
        int val;
        DoublyLinkedNode prev, next;

        public DoublyLinkedNode(int val){
            this.val=val;
        }
    }


        DoublyLinkedNode head, tail;
        int size;

        public MyLinkedList() {
            size=0;
        }

        public int get(int index) {
            if(index<0 || index>=size){
                return -1;
            } else if(index<size/2){
                DoublyLinkedNode cur=head;
                while(index-->0){
                    cur=cur.next;
                }
                return cur.val;
            } else{
                DoublyLinkedNode cur=tail;
                int count=size-index-1;
                while(count-->0){
                    cur=cur.prev;
                }
                return cur.val;
            }
        }

        public void addAtHead(int val) {
            size++;
            if(size==1){
                DoublyLinkedNode cur=new DoublyLinkedNode(val);
                head=cur;
                tail=cur;
            } else{
                head.prev=new DoublyLinkedNode(val);
                head.prev.next=head;
                head=head.prev;
            }
        }

        public void addAtTail(int val) {
            size++;
            if(size==1){
                DoublyLinkedNode cur=new DoublyLinkedNode(val);
                head=cur;
                tail=cur;
            } else{
                tail.next=new DoublyLinkedNode(val);
                tail.next.prev=tail;
                tail=tail.next;
            }
        }

        public void addAtIndex(int index, int val) {
            if(index<0 || index>size){
                return;
            } else if(index==0){
                addAtHead(val);
            } else if(index==size){
                addAtTail(val);
            } else if(index<size/2){
                DoublyLinkedNode prev=head;
                while(--index>0){
                    prev=prev.next;
                }
                DoublyLinkedNode cur=new DoublyLinkedNode(val);
                prev.next.prev=cur;
                cur.next=prev.next;
                prev.next=cur;
                cur.prev=prev;
                size++;
            } else{
                DoublyLinkedNode next=tail;
                int count=size-index-1;
                while(count-->0){
                    next=next.prev;
                }
                DoublyLinkedNode cur=new DoublyLinkedNode(val);
                next.prev.next=cur;
                cur.prev=next.prev;
                next.prev=cur;
                cur.next=next;
                size++;
            }
        }

        public void deleteAtIndex(int index) {
            if(index<0 || index>=size){
                return;
            } else if(index==0){
                size--;
                if(head==tail){
                    head=null;
                    tail=null;
                } else{
                    head=head.next;
                    head.prev=null;
                }
            } else if(index==size-1){
                size--;
                if(head==tail){
                    head=null;
                    tail=null;
                } else{
                    tail=tail.prev;
                    tail.next=null;
                }
            } else if(index<size/2){
                DoublyLinkedNode prev=head;
                while(--index>0){
                    prev=prev.next;
                }
                prev.next=prev.next.next;
                prev.next.prev=prev;
                size--;
            } else{
                DoublyLinkedNode next=tail;
                int count=size-index-2;
                while(count-->0){
                    next=next.prev;
                }
                next.prev=next.prev.prev;
                next.prev.next=next;
                size--;
            }
        }
    }

//    // Singly linked list
//    public static class MyLinkedList {
//        class SinglyLinkedNode{
//            int val;
//            SinglyLinkedNode next;
//
//            public SinglyLinkedNode(int val){
//                this.val=val;
//            }
//        }
//
//
//        SinglyLinkedNode head, tail;
//        int size;
//
//        public MyLinkedList() {
//            size=0;
//        }
//
//        public int get(int index) {
//            if(index<0 || index>=size){
//                return -1;
//            } else{
//                SinglyLinkedNode cur=head;
//                while(index-->0){
//                    cur=cur.next;
//                }
//                return cur.val;
//            }
//        }
//
//        public void addAtHead(int val) {
//            SinglyLinkedNode cur=new SinglyLinkedNode(val);
//            cur.next=head;
//            head=cur;
//            size++;
//            if(size==1){
//                tail=head;
//            }
//        }
//
//        public void addAtTail(int val) {
//            SinglyLinkedNode cur=new SinglyLinkedNode(val);
//            if(size==0){
//                head=cur;
//            } else{
//                tail.next=cur;
//            }
//            tail=cur;
//            size++;
//        }
//
//        public void addAtIndex(int index, int val) {
//            if(index==0){
//                addAtHead(val);
//            } else if(index==size){
//                addAtTail(val);
//            } else if(index<0 || index>size){
//                return;
//            } else{
//                SinglyLinkedNode prev=head;
//                while(--index>0){
//                    prev=prev.next;
//                }
//                SinglyLinkedNode next=prev.next;
//                prev.next=new SinglyLinkedNode(val);
//                prev.next.next=next;
//                size++;
//            }
//        }
//
//        public void deleteAtIndex(int index) {
//            if(index<0 || index>=size){
//                return;
//            } else{
//                if(index==0){
//                    if(head==tail){
//                        tail=null;
//                    }
//                    head=head.next;
//                } else{
//                    SinglyLinkedNode prev=head;
//                    while(--index>0){
//                        prev=prev.next;
//                    }
//                    if(prev.next==tail){
//                        tail=prev;
//                    }
//                    prev.next=prev.next.next;
//                }
//                size--;
//            }
//        }
//    }
}
