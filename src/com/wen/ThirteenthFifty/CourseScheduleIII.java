package com.wen.ThirteenthFifty;

import java.util.Arrays;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    // Greedy
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b)->a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>((a, b)->b-a);
        int l=courses.length, result=0, timer=0;
        for(int i=0; i<l; i++){
            int[] course=courses[i];
            timer+=course[0];
            pq.offer(course[0]);
            if(timer>course[1]){
                timer-=pq.poll();
            }
        }
        return pq.size();
    }
}
