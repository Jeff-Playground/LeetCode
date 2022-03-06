package com.wen.EighthFifty;

import java.util.*;

public class EvaluateDivision {
    // Union find
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int l=equations.size();
        UnionFind uf=new UnionFind();
        for(int i=0; i<l; i++){
            List<String> e=equations.get(i);
            double division=values[i];
            uf.union(e.get(0), e.get(1), division);
        }
        int resultLength=queries.size();
        double[] result=new double[resultLength];
        for(int i=0; i<resultLength; i++){
            List<String> q=queries.get(i);
            String x=q.get(0), y=q.get(1);
            Pair rx=uf.find(x), ry=uf.find(y);
            if(rx!=null && ry!=null && rx.s.equals(ry.s)){
                result[i]=rx.v/ry.v;
            } else{
                result[i]=-1.0;
            }
        }
        return result;
    }

    private class Pair{
        String s;
        double v;

        public Pair(String s, double v){
            this.s=s;
            this.v=v;
        }
    }

    private class UnionFind{
        Map<String, String> root;
        Map<String, Double> value;

        public UnionFind(){
            root=new HashMap<>();
            value=new HashMap<>();
        }

        public Pair find(String x){
            if(!root.containsKey(x)){
                return null;
            }
            if(root.get(x).equals(x)){
                return new Pair(x, 1.0);
            } else{
                Pair result=find(root.get(x));
                root.put(x, result.s);
                result.v*=value.get(x);
                value.put(x, result.v);
                return result;
            }
        }

        public void union(String x, String y, double division){
            root.putIfAbsent(x, x);
            value.putIfAbsent(x, 1.0);
            root.putIfAbsent(y, y);
            value.putIfAbsent(y, 1.0);
            Pair rx=find(x), ry=find(y);
            if(!rx.s.equals(ry.s)){
                root.put(rx.s, ry.s);
                value.put(rx.s, division/rx.v*ry.v);
            }
        }
    }

//    // Topological sort
//    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
//        int l=values.length;
//        Map<String, Map<String, Double>> graph=new HashMap<>();
//        for(int i=0; i<l; i++){
//            String a=equations.get(i).get(0);
//            String b=equations.get(i).get(1);
//            graph.putIfAbsent(a, new HashMap<>());
//            graph.putIfAbsent(b, new HashMap<>());
//            Map<String, Double> mapA=graph.get(a);
//            Map<String, Double> mapB=graph.get(b);
//            mapA.put(b, values[i]);
//            mapB.put(a, 1/values[i]);
//        }
//        int m=queries.size();
//        double[] result=new double[m];
//        for(int i=0; i<m; i++){
//            String a=queries.get(i).get(0);
//            String b=queries.get(i).get(1);
//            if(graph.containsKey(a) && graph.containsKey(b)){
//                if(a.equals(b)){
//                    result[i]=1.0;
//                } else{
//                    Set<String> reached=new HashSet<>();
//                    reached.add(a);
//                    result[i]=calcEquationDFS(graph, a, b, reached);
//                }
//            } else{
//                result[i]=-1.0;
//            }
//        }
//        return result;
//    }
//
//    public double calcEquationDFS(Map<String, Map<String, Double>> graph, String from, String dest, Set<String> reached){
//        Map<String, Double> mapFrom=graph.get(from);
//        if(mapFrom==null){
//            return -1.0;
//        } else{
//            for(String to: mapFrom.keySet()){
//                if(to.equals(dest)){
//                    return mapFrom.get(to);
//                } else{
//                    if(!reached.contains(to)){
//                        reached.add(to);
//                        double val=calcEquationDFS(graph, to, dest, reached);
//                        if(val!=-1.0){
//                            return mapFrom.get(to)*val;
//                        }
//                    }
//                }
//            }
//            return -1.0;
//        }
//    }
}
