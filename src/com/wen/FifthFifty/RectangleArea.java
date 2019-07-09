package com.wen.FifthFifty;

public class RectangleArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left=Math.max(A,E), right=Math.max(left, Math.min(C,G));
        int top=Math.min(D,H), bottom=Math.min(top, Math.max(B, F));
        return (C-A)*(D-B)+(G-E)*(H-F)-(right-left)*(top-bottom);
    }
}
