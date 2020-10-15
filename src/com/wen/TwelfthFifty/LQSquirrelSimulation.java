package com.wen.TwelfthFifty;

/*

There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find
the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can
only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell.
The distance is represented by the number of moves.

Example 1:

Input:
Height : 5
Width : 7
Tree position : [2,2]
Squirrel : [4,4]
Nuts : [[3,0], [2,5]]
Output: 12

Note:

All given positions won't overlap.
The squirrel can take at most one nut at one time.
The given positions of nuts have no order.
Height and width are positive integers. 3 <= height * width <= 10,000.
The given positions contain at least one nut, only one tree and one squirrel.

 */

public class LQSquirrelSimulation {
    // Find out which nut the squirrel should go to first by making sure going to it will save the most distance
    public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int result=0;
        int curTreeDist=getDist(tree, nuts[0]), curNutDist=getDist(nuts[0], squirrel);
        result+=curTreeDist+curNutDist;
        for(int i=1; i<nuts.length; i++){
            int[] nut=nuts[i];
            int treeDist=getDist(tree, nut), nutDist=getDist(nut, squirrel);
            if(treeDist-nutDist>curTreeDist-curNutDist){
                result-=curNutDist;
                result+=curTreeDist;
                result+=nutDist;
                curTreeDist=treeDist;
                curNutDist=nutDist;
            } else{
                result+=treeDist;
            }
            result+=treeDist;
        }
        return result;
    }

    private int getDist(int[] a, int[] b){
        return Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1]);
    }
}
