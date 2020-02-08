package com.wen.ThirdFifty;

import java.util.*;

public class CopyListWithRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    }

//    // Copy each node and put it right after the copied node in the linked list
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head==null){
//            return null;
//        }
//        RandomListNode cur=head;
//        while(cur!=null){
//            RandomListNode curCopy=new RandomListNode(cur.label);
//            curCopy.next=cur.next;
//            cur.next=curCopy;
//            cur=curCopy.next;
//        }
//        cur=head;
//        while(cur!=null){
//            if(cur.random!=null){
//                cur.next.random=cur.random.next;
//            }
//            cur=cur.next.next;
//        }
//        cur=head;
//        RandomListNode result=head.next;
//        while(cur!=null){
//            RandomListNode tmp=cur.next;
//            cur.next=tmp.next;
//            if(tmp.next!=null){
//                tmp.next=tmp.next.next;
//            }
//            cur=cur.next;
//        }
//        return result;
//    }

//    // DFS recursive
//    public RandomListNode copyRandomList(RandomListNode head) {
//        Map<RandomListNode, RandomListNode> visited=new HashMap<>();
//        return copyRandomListDFS(head, visited);
//    }
//
//    private RandomListNode copyRandomListDFS(RandomListNode node, Map<RandomListNode, RandomListNode> visited) {
//        if(node==null){
//            return null;
//        }
//        if(visited.get(node)!=null){
//            return visited.get(node);
//        } else{
//            RandomListNode copy=new RandomListNode(node.label);
//            visited.put(node, copy);
//            copy.next=copyRandomListDFS(node.next, visited);
//            copy.random=copyRandomListDFS(node.random, visited);
//            return copy;
//        }
//    }

//    // DFS with stack
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head==null){
//            return null;
//        }
//        Map<RandomListNode, RandomListNode> map=new HashMap<>();
//        RandomListNode headCopy=new RandomListNode(head.label);
//        map.put(head, headCopy);
//        Stack<RandomListNode> stack=new Stack<>();
//        stack.push(head);
//        while(!stack.isEmpty()){
//            RandomListNode cur=stack.pop();
//            RandomListNode copy=map.get(cur);
//            RandomListNode nextCopy=null;
//            if(cur.next!=null){
//                if(map.get(cur.next)==null){
//                    stack.push(cur.next);
//                    nextCopy=new RandomListNode(cur.next.label);
//                    map.put(cur.next, nextCopy);
//                } else{
//                    nextCopy=map.get(cur.next);
//                }
//            }
//            copy.next=nextCopy;
//            RandomListNode randomCopy=null;
//            if(cur.random!=null){
//                if(map.get(cur.random)==null){
//                    stack.push(cur.random);
//                    randomCopy=new RandomListNode(cur.random.label);
//                    map.put(cur.random, randomCopy);
//                } else{
//                    randomCopy=map.get(cur.random);
//                }
//            }
//            copy.random=randomCopy;
//        }
//        return headCopy;
//    }

//    // BFS with queue
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if(head==null){
//            return null;
//        }
//        Map<RandomListNode, RandomListNode> map=new HashMap<>();
//        RandomListNode headCopy=new RandomListNode(head.label);
//        map.put(head, headCopy);
//        Queue<RandomListNode> queue=new LinkedList<>();
//        queue.offer(head);
//        while(!queue.isEmpty()){
//            for(int i=queue.size(); i>0; i--){
//                RandomListNode cur=queue.poll();
//                RandomListNode copy=map.get(cur);
//                RandomListNode nextCopy=null;
//                if(cur.next!=null){
//                    if(map.get(cur.next)==null){
//                        queue.offer(cur.next);
//                        nextCopy=new RandomListNode(cur.next.label);
//                        map.put(cur.next, nextCopy);
//                    } else{
//                        nextCopy=map.get(cur.next);
//                    }
//                }
//                copy.next=nextCopy;
//                RandomListNode randomCopy=null;
//                if(cur.random!=null){
//                    if(map.get(cur.random)==null){
//                        queue.offer(cur.random);
//                        randomCopy=new RandomListNode(cur.random.label);
//                        map.put(cur.random, randomCopy);
//                    } else{
//                        randomCopy=map.get(cur.random);
//                    }
//                }
//                copy.random=randomCopy;
//            }
//        }
//        return headCopy;
//    }
}
