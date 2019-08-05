package com.wen.FourteenthFifty;

public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int N=edges.length;
        int[] root=new int[N+1];
        int[] first=null, second=null;
        for(int[] edge: edges){
            int n1=edge[0], n2=edge[1];
            if(root[n2]==0){
                root[n2]=n1;
            } else{
                first=new int[]{root[n2], n2};
                second=new int[]{n1, n2};
                // Delete second edge
                edge[1]=0;
            }
        }
        for(int i=1; i<N+1; i++){
            root[i]=i;
        }
        for(int[] edge: edges){
            int n1=edge[0], n2=edge[1];
            // Handle deleted edge
            if(n2==0){
                continue;
            }
            int root1=getRoot(root, n1), root2=getRoot(root, n2);
            // Found there's still a loop
            if(root1==root2){
                // if first!=null, means deleted wrong edge
                return first==null?edge:first;
            }
            root[root2]=root1;
        }
        return second;
    }

    public int getRoot(int[] root, int node){
        while(root[node]!=node){
            root[node]=root[root[node]];
            node=root[node];
        }
        return node;
    }
}
