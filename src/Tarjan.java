import java.util.*;

public class Tarjan {

    public static void main(String[] args){
        int N=4;    // number of vertices
        List<List<Integer>> edges=Arrays.asList(Arrays.asList(0,1), Arrays.asList(1,2), Arrays.asList(2,0), Arrays.asList(1,3));

        List<List<Integer>> bridges=findBridges(N, edges);
        bridges.forEach(e->System.out.println("("+e.get(0)+","+e.get(1)+")"));

        List<Integer> articulationPoints=findArticulationPoints(N, edges);
        articulationPoints.forEach(System.out::println);
    }

    private static List<List<Integer>> findBridges(int N, List<List<Integer>> edges){
        List<List<Integer>> result=new ArrayList<>();
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(List<Integer> edge: edges){
            int x=edge.get(0), y=edge.get(1);
            graph.putIfAbsent(x, new HashSet<>());
            graph.get(x).add(y);
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(y).add(x);
        }
        int[] ids=new int[N], lows=new int[N];
        int[] id=new int[]{0};
        Arrays.fill(ids,-1);
        // Iteration to handle disconnected graphs, in a connected graph it will only enter the if logic once
        for(int i=0; i<N; i++){
            if(ids[i]==-1){
                findBridgesHelper(graph, i, i, ids, lows, id, result);
            }
        }
        return result;
    }

    private static void findBridgesHelper(Map<Integer, Set<Integer>> graph, int last, int cur, int[] ids, int[] lows, int[] id, List<List<Integer>> result){
        ids[cur]=id[0]++;
        lows[cur]=ids[cur];
        for(int neighbour: graph.get(cur)){
            if(neighbour!=last){
                if(ids[neighbour]==-1){
                    findBridgesHelper(graph, cur, neighbour, ids, lows, id, result);
                    if(ids[cur]<lows[neighbour]){
                        result.add(Arrays.asList(cur, neighbour));
                    }
                    lows[cur]=Math.min(lows[cur], lows[neighbour]);
                } else{
                    lows[cur]=Math.min(lows[cur], ids[neighbour]);
                }
            }
        }
    }

    private static List<Integer> findArticulationPoints(int N, List<List<Integer>> edges){
        List<Integer> result=new ArrayList<>();
        Map<Integer, Set<Integer>> graph=new HashMap<>();
        for(List<Integer> edge: edges){
            int x=edge.get(0), y=edge.get(1);
            graph.putIfAbsent(x, new HashSet<>());
            graph.get(x).add(y);
            graph.putIfAbsent(y, new HashSet<>());
            graph.get(y).add(x);
        }
        int[] ids=new int[N], lows=new int[N];
        int[] id=new int[]{0};
        Arrays.fill(ids, -1);
        // Iteration to handle disconnected graph, in a connected graph it will only enter the if logic once
        for(int i=0; i<N; i++){
            if(ids[i]==-1){
                findArticulationPointsHelper(graph, i, i, ids, lows, id, result);
            }
        }
        return result;
    }

    private static void findArticulationPointsHelper(Map<Integer, Set<Integer>> graph, int last, int cur, int[] ids, int[] lows, int[] id, List<Integer> result){
        ids[cur]=id[0]++;
        lows[cur]=ids[cur];
        int disconnectedSubgraphCount=0;
        for(int neighbour: graph.get(cur)){
            if(neighbour!=last){
                if(ids[neighbour]==-1){
                    disconnectedSubgraphCount++;
                    findArticulationPointsHelper(graph, cur, neighbour, ids, lows, id, result);
                    // Note here we need to exclude the root because it will always have ids[cur]<=lows[neighbour]
                    if(last!=cur && ids[cur]<=lows[neighbour]){
                        result.add(cur);
                    }
                    lows[cur]=Math.min(lows[cur], lows[neighbour]);
                } else{
                    lows[cur]=Math.min(lows[cur], ids[neighbour]);
                }
            }
        }
        // Current node is the root, and there are more than 1 disconnected children subgraph
        if(last==cur && disconnectedSubgraphCount>1){
            result.add(cur);
        }
    }
}
