package com.wen.AALocalT;

import java.util.*;

public class test {
    public class MyIterator implements Iterator<Integer> {
        private int[][] array;
        private Queue<int[]> q;

        public MyIterator(int[][] inputArray){
            array=inputArray;
            q=new LinkedList<>();
            for(int i=0; i<array.length; i++){
                q.offer(new int[]{i, 0});
            }
        }

        @Override
        public boolean hasNext() {
            return !q.isEmpty();
        }

        @Override
        public Integer next(){
            if(hasNext()){
                int[] cur=q.poll();
                if(array[cur[0]].length>cur[1]+1){
                    q.offer(new int[]{cur[0], cur[1]+1});
                }
                return (Integer)array[cur[0]][cur[1]];
            } else{
                return null;
            }
        }
    }

    public static void main(String[] args){
        int[][] items=new int[][]{{2,3,0}, {2,2,1},{3,5,1},{4,7,2},{3,6,2}};
        System.out.println(test(5,7,items));
    }

    private static int test(int n, int v, int[][] items){
        Map<Integer, Set<Integer>> tree=new HashMap<>();
        for(int i=0; i<items.length; i++){
            tree.putIfAbsent(items[i][2], new HashSet<>());
            tree.get(items[i][2]).add(i+1);
        }
        int[][] memo=new int[n+1][v+1];
        for(int[] e: memo){
            Arrays.fill(e,-1);
        }
        return dp(tree, items, 0, v, memo);
    }

    private static int dp(Map<Integer, Set<Integer>> tree, int[][] items, int idx, int size, int[][] memo){
        if(memo[idx][size]==-1){
            int w=idx==0?0:items[idx-1][0];
            int v=idx==0?0:items[idx-1][1];
            if(size<w){
                memo[idx][size]=0;
            } else{
                memo[idx][size]=v;
                for(int child: tree.getOrDefault(idx, new HashSet<>())){
                    for(int cs=0; cs<=size-w; cs++){
                        memo[idx][size]=Math.max(memo[idx][size], dp(tree,items,child,cs,memo)+dp(tree,items,idx,size-cs,memo));
                    }
                }
            }
        }
        return memo[idx][size];
    }
}
