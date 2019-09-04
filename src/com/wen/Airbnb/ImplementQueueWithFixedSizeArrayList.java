package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.List;

public class ImplementQueueWithFixedSizeArrayList {
    public static void main(String args[]) {
        QueueWithFixedArray queue = new QueueWithFixedArray(5);
        System.out.println(queue.poll());//null
        queue.offer(1);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        queue.offer(4);
        queue.offer(5);
        queue.offer(6);
        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//1
        System.out.println(queue.poll());//2
        System.out.println(queue.poll());//3
        System.out.println(queue.poll());//4
        queue.offer(7);
        System.out.println("size: " + queue.size());//size:3
        System.out.println(queue.poll());//5
        System.out.println(queue.poll());//6
        System.out.println(queue.poll());//7
        System.out.println(queue.poll());//null
    }
}

class QueueWithFixedArray {
    private int fixedSize;
    private int count;
    private int head;
    private int tail;
    List<Object> headList;
    List<Object> tailList;

    public QueueWithFixedArray(int size) {
        this.fixedSize = size;
        this.count = 0;
        this.head = 0;
        this.tail = 0;
        this.headList = new ArrayList<>();
        this.tailList = this.headList;
    }

    public void offer(int num) {
        if (tail == fixedSize - 1) {
            List<Object> newList = new ArrayList<>();
            tailList.add(newList);
            tailList = newList;
            tail = 0;
        }
        tailList.add(num);
        tail++;
        count++;
    }

    public Integer poll() {
        if (count == 0) {
            return null;
        }
        if (head == fixedSize - 1) {
            headList = (List<Object>) headList.get(head);
            head = 0;
        }
        count--;
        return (int) headList.get(head++);
    }

    public int size() {
        return this.count;
    }
}
