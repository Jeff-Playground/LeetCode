package com.wen.SeventhFifty;

/*Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function
to find the number of connected components in an undirected graph.

Example 1:

0          3

|          |

1 --- 2    4

Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.

Example 2:

0           4

|           |

1 --- 2 --- 3

Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.

Note:

You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as
[1, 0] and thus will not appear together in edges.*/

import java.util.Arrays;

public class LQNumberOfConnectedComponentsInAnUndirectedGraph {
    public static int countComponents(int n, int[][] edges){
        UnionFind uf=new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.total;
    }

    private static class UnionFind{
        public int[] pre=null;
        public int[] count=null;
        public int total=-1;

        public UnionFind(int N){
            pre=new int[N];
            count=new int[N];
            for(int i=0; i<N; i++){
                pre[i]=i;
            }
            Arrays.fill(count, 1);
            total=N;
        }

        public void union(int n1, int n2){
            int pre1=find(n1), pre2=find(n2);
            if(pre1!=pre2){
                if(count[pre1]<count[pre2]){
                    count[pre2]+=count[pre1];
                    pre[pre1]=pre2;
                } else{
                    count[pre1]+=count[pre2];
                    pre[pre2]=pre1;
                }
                total--;
            }
        }

        public int find(int n){
            int cur=n;
            while(pre[cur]!=cur){
                pre[cur]=pre[pre[cur]];
                cur=pre[cur];
            }
            return cur;
        }
    }
}
