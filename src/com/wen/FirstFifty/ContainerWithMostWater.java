package com.wen.FirstFifty;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxArea=0;
        int i=0, j=height.length-1;
        while(i<j) {
            int h=Math.min(height[i], height[j]);
            maxArea=Math.max(maxArea, (j-i)*h);
            while(i<j && h==height[i]) {
                i++;
            }
            while(i<j && h==height[j]) {
                j--;
            }
        }
        return maxArea;
    }
}
