package com.wen.TwentyFifthFifty;

import java.util.Random;
import java.util.Stack;

public class DesignSkiplist {
    class Skiplist {
        private class SkipListNode{
            SkipListNode next, down;
            int val;

            public SkipListNode(int val, SkipListNode next, SkipListNode down){
                this.val=val;
                this.next=next;
                this.down=down;
            }
        }

        private SkipListNode head;

        public Skiplist() {
            head=new SkipListNode(-1, null, null);
        }

        public boolean search(int target) {
            SkipListNode cur=head;
            while(cur!=null){
                while(cur.next!=null && cur.next.val<target){
                    cur=cur.next;
                }
                if(cur.next!=null && cur.next.val==target){
                    return true;
                } else{
                    cur=cur.down;
                }
            }
            return false;
        }

        public void add(int num) {
            Stack<SkipListNode> stack=new Stack<>();
            SkipListNode cur=head, down=null;
            while(cur!=null){
                while(cur.next!=null && cur.next.val<num){
                    cur=cur.next;
                }
                stack.push(cur);
                cur=cur.down;
            }
            boolean insert=true;
            while(insert && !stack.isEmpty()){
                cur=stack.pop();
                cur.next=new SkipListNode(num, cur.next, down);
                down=cur.next;
                insert=(new Random().nextInt(2))==0;
            }
            if(insert){
                head=new SkipListNode(-1, null, head);
            }
        }

        public boolean erase(int num) {
            SkipListNode cur=head;
            boolean found=false;
            while(cur!=null){
                while(cur.next!=null && cur.next.val<num){
                    cur=cur.next;
                }
                if(cur.next!=null && cur.next.val==num){
                    found=true;
                    cur.next=cur.next.next;
                }
                cur=cur.down;
            }
            return found;
        }
    }
}
