package com.wen.EighthFifty;

import java.util.*;

public class EvaluateDivision {
    // Union find
    public static class Info{
        public String node;
        public double value;

        public Info(String node, double value){
            this.node=node;
            this.value=value;
        }
    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Info> pre=new HashMap<>();
        int l=values.length, m=queries.size();
        for(int i=0; i<l; i++){
            String x=equations.get(i).get(0);
            String y=equations.get(i).get(1);
            if(findPre(x, pre)==null && findPre(y, pre)==null){
                pre.put(y, new Info(y, 1.0));
                pre.put(x, new Info(y, values[i]));
            } else if(findPre(x, pre)==null){
                pre.put(x, new Info(y, values[i]));
            } else if(findPre(y, pre)==null){
                pre.put(y, new Info(x, 1/values[i]));
            } else{
                Info preX=findPre(x, pre);
                Info preY=findPre(y, pre);
                if(!preX.node.equals(preY.node)){
                    preX.node=preY.node;
                    preX.value=values[i]*preY.value;
                }
            }
        }
        double[] result=new double[m];
        for(int i=0; i<m; i++){
            String x=queries.get(i).get(0);
            String y=queries.get(i).get(1);
            Info preX=findPre(x, pre);
            Info preY=findPre(y, pre);
            if(preX!=null && preY!=null && preX.node.equals(preY.node)){
                result[i]=preX.value/preY.value;
            } else{
                result[i]=-1.0;
            }
        }
        return result;
    }

    public static Info findPre(String node, Map<String, Info> pre){
        if(pre.containsKey(node)){
            String cur=node;
            while(!pre.get(cur).node.equals(cur)){
                pre.get(cur).value*=pre.get(pre.get(cur).node).value;
                pre.get(cur).node=pre.get(pre.get(cur).node).node;
                cur=pre.get(cur).node;
            }
            return pre.get(node);
        } else{
            return null;
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
