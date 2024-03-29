package com.wen.TwelfthFifty;

public class LogicalOROfTwoBinaryGridsRepresentedAsQuadTrees {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {}

        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public Node intersect(Node quadTree1, Node quadTree2) {
        if(quadTree1.isLeaf && quadTree2.isLeaf){
            quadTree1.val|=quadTree2.val;
        } else if(!quadTree1.isLeaf && !quadTree2.isLeaf){
            quadTree1.topLeft=intersect(quadTree1.topLeft, quadTree2.topLeft);
            quadTree1.topRight=intersect(quadTree1.topRight, quadTree2.topRight);
            quadTree1.bottomLeft=intersect(quadTree1.bottomLeft, quadTree2.bottomLeft);
            quadTree1.bottomRight=intersect(quadTree1.bottomRight, quadTree2.bottomRight);
            if(quadTree1.topLeft.isLeaf && quadTree1.topRight.isLeaf && quadTree1.bottomLeft.isLeaf && quadTree1.bottomRight.isLeaf){
                if((quadTree1.topLeft.val && quadTree1.topRight.val && quadTree1.bottomLeft.val && quadTree1.bottomRight.val) ||
                        (!quadTree1.topLeft.val && !quadTree1.topRight.val && !quadTree1.bottomLeft.val && !quadTree1.bottomRight.val)){
                    quadTree1.isLeaf=true;
                    quadTree1.val=quadTree1.topLeft.val;
                    quadTree1.topLeft=null;
                    quadTree1.topRight=null;
                    quadTree1.bottomLeft=null;
                    quadTree1.bottomRight=null;
                }
            }
        } else if(quadTree1.isLeaf){
            if(!quadTree1.val){
                return quadTree2;
            }
        } else{
            return intersect(quadTree2, quadTree1);
        }
        return quadTree1;
    }
}
