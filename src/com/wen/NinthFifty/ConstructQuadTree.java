package com.wen.NinthFifty;

public class ConstructQuadTree {
    // Definition for a QuadTree node.
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public Node construct(int[][] grid) {
        return construct(grid, 0, 0, grid.length-1, grid.length-1);
    }

    private Node construct(int[][] grid, int x1, int y1, int x2, int y2){
        if(x1==x2 && y1==y2){
            return new Node(grid[x1][y1]==1, true, null, null, null, null);
        } else{
            int midX=x1+(x2-x1)/2, midY=y1+(y2-y1)/2;
            Node topLeft=construct(grid, x1, y1, midX, midY);
            Node topRight=construct(grid, x1, midY+1, midX, y2);
            Node bottomLeft=construct(grid, midX+1, y1, x2, midY);
            Node bottomRight=construct(grid, midX+1, midY+1, x2, y2);
            if((topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf) &&
                    (((topLeft.val && topRight.val && bottomLeft.val && bottomRight.val) ||
                            (!topLeft.val && !topRight.val && !bottomLeft.val && !bottomRight.val)))){
                return new Node(topLeft.val, true, null, null, null, null);
            } else{
                return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
    }
}
