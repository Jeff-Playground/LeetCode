package com.wen.TwentySecondFifty;

/*

On a campus represented as a 2D grid, there are N workers and M bikes, with N <= M. Each worker and bike is a 2D coordinate
on this grid.

We assign one unique bike to each worker so that the sum of the Manhattan distances between each worker and their assigned
bike is minimized.

The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.

Return the minimum possible sum of Manhattan distances between each worker and their assigned bike.



Example 1:

Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
Output: 6
Explanation:
We assign bike 0 to worker 0, bike 1 to worker 1. The Manhattan distance of both assignments is 3, so the output is 6.



Example 2:

Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
Output: 4
Explanation:
We first assign bike 0 to worker 0, then assign bike 1 to worker 1 or worker 2, bike 2 to worker 2 or worker 1. Both
assignments lead to sum of the Manhattan distances as 4.


Note:
0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000
All worker and bike locations are distinct.
1 <= workers.length <= bikes.length <= 10

 */

public class CampusBikesII {
//    // DFS backtracking with memorization
//    // Time complexity is O(2^bl), because there're totally 2^bl states that need to be calculated
//    // Space complexity is O(2^bl), because calculated takes this much space
//    public int assignBikes(int[][] workers, int[][] bikes) {
//        // Here can use a state because bikes.length <= 10, meaning we only need 10 bits to identify all bike states
//        // If bike counts is very large, here we can ues a Map to replace calculated, and the keys can be strings(0,3,...,99)
//        return abHelper(workers, bikes, 0, 0, new int[1<<bikes.length]);
//    }
//
//    // Here a state uniquely identifies a situation where we are calculating for a cur and bikes in certain indices are
//    // taken, for example, 1-2- and 2-1- will share same child calculations
//    private int abHelper(int[][] workers, int[][] bikes, int cur, int state, int[] calculated){
//        if(cur==workers.length){
//            return 0;
//        }
//        if(calculated[state]>0){
//            return calculated[state];
//        } else{
//            int result=Integer.MAX_VALUE;
//            for(int j=0; j<bikes.length; j++){
//                if((state&(1<<j))==0){
//                    result=Math.min(result,  Math.abs(workers[cur][0]-bikes[j][0])+Math.abs(workers[cur][1]-bikes[j][1])
//                            +abHelper(workers, bikes, cur+1, state|(1<<j), calculated));
//                }
//            }
//            calculated[state]=result;
//            return result;
//        }
//    }
}
