package com.wen.EighthFifty;

import java.util.*;

public class EvaluateDivision {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int l=values.length;
        Map<String, Map<String, Double>> graph=new HashMap<>();
        for(int i=0; i<l; i++){
            String a=equations.get(i).get(0);
            String b=equations.get(i).get(1);
            Map<String, Double> mapA=graph.getOrDefault(a, new HashMap<>());
            Map<String, Double> mapB=graph.getOrDefault(b, new HashMap<>());
            mapA.put(b, values[i]);
            mapB.put(a, 1/values[i]);
            graph.put(a, mapA);
            graph.put(b, mapB);
        }
        int m=queries.size();
        double[] result=new double[m];
        for(int i=0; i<m; i++){
            String a=queries.get(i).get(0);
            String b=queries.get(i).get(1);
            if(graph.containsKey(a) && graph.containsKey(b)){
                if(a.equals(b)){
                    result[i]=1.0;
                } else{
                    Set<String> reached=new HashSet<>();
                    reached.add(a);
                    result[i]=calcEquationDFS(graph, a, b, reached);
                }
            } else{
                result[i]=-1.0;
            }
        }
        return result;
    }

    public double calcEquationDFS(Map<String, Map<String, Double>> graph, String from, String dest, Set<String> reached){
        Map<String, Double> mapFrom=graph.get(from);
        if(mapFrom==null){
            return -1.0;
        } else{
            for(String to: mapFrom.keySet()){
                if(to.equals(dest)){
                    return mapFrom.get(to);
                } else{
                    if(!reached.contains(to)){
                        reached.add(to);
                        double val=calcEquationDFS(graph, to, dest, reached);
                        if(val!=-1.0){
                            return mapFrom.get(to)*val;
                        }
                    }
                }
            }
            return -1.0;
        }
    }
}
