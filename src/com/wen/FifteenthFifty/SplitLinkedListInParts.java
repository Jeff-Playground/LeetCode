package com.wen.FifteenthFifty;

import java.util.HashMap;
import java.util.Map;

public class SplitLinkedListInParts {

    public static class ListNode {
        int val;
        public ListNode next;
        public ListNode(int x) { val = x; }
    }

//    public ListNode[] splitListToParts(ListNode root, int k) {
//        ListNode cur=root;
//        int l=0;
//        while(cur!=null){
//            l++;
//            cur=cur.next;
//        }
//        ListNode[] result=new ListNode[k];
//        int min=l/k, numOfMore=l%k;
//        cur=root;
//        for(int i=0; i<k && cur!=null; i++){
//            result[i]=cur;
//            for(int j=1; j<min+(i<numOfMore?1:0); j++){
//                cur=cur.next;
//            }
//            ListNode temp=cur.next;
//            cur.next=null;
//            cur=temp;
//        }
//        return result;
//    }

    public static ListNode[] splitListToParts(ListNode root, int k) {
        Map<Integer, ListNode> nodes=new HashMap<>();
        int i=1;
        ListNode cur=root;
        while(cur!=null){
            nodes.put(i++, cur);
            cur=cur.next;
        }
        int length=i-1, size=length/k+(length%k==0?0:1), bigPartCount=length%k, count=0;
        ListNode[] result=new ListNode[k];
        result[0]=root;
        count++;
        i=size;
        while(i<length){
            if(nodes.get(i).next!=null){
                nodes.get(i).next=null;
                result[count]=nodes.get(i+1);
            }
            if(bigPartCount>0){
                i+=count++>=bigPartCount?size-1:size;
            } else{
                i+=size;
                count++;
            }
        }
        return result;
    }
}
