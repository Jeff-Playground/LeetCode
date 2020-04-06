package com.wen.TwentiethFifty;

public class FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        int[] inDegree=new int[N+1], outDegree=new int[N+1];
        for(int[] t: trust){
            inDegree[t[1]]++;
            outDegree[t[0]]++;
        }
        for(int i=1; i<=N; i++){
            if(inDegree[i]==N-1 && outDegree[i]==0){
                return i;
            }
        }
        return -1;
    }

//    public static int findJudge(int N, int[][] trust) {
//        if(N==1){
//            return 1;
//        }
//        int[][] graph=new int[N+1][N+1];
//        Set<Integer> nonJudge=new HashSet<>();
//        Set<Integer> possibleJudge=new HashSet<>();
//        for(int[] t: trust){
//            nonJudge.add(t[0]);
//            possibleJudge.add(t[1]);
//            graph[t[0]][t[1]]=1;
//        }
//        possibleJudge.removeAll(nonJudge);
//        for(int cur: possibleJudge){
//            boolean isJudge=true;
//            for(int i=1; i<=N; i++){
//                if(i!=cur && graph[i][cur]==0){
//                    isJudge=false;
//                    break;
//                }
//            }
//            if(isJudge){
//                for(int j=1; j<=N; j++){
//                    if(cur!=j && graph[cur][j]==1){
//                        isJudge=false;
//                        break;
//                    }
//                }
//            }
//            if(isJudge){
//                return cur;
//            }
//        }
//        return -1;
//    }
}
