import java.util.*;

public class UnionFind {
    public static void main(String[] args) {
        List<List<Integer>> availableRoads=new ArrayList<>();
        availableRoads.add(Arrays.asList(1,4));
        availableRoads.add(Arrays.asList(5,4));
        availableRoads.add(Arrays.asList(2,3));
        List<List<Integer>> costNewRoadsConstruct=new ArrayList<>();
        costNewRoadsConstruct.add(Arrays.asList(1,2,5));
        costNewRoadsConstruct.add(Arrays.asList(1,3,10));
        costNewRoadsConstruct.add(Arrays.asList(1,6,2));
        costNewRoadsConstruct.add(Arrays.asList(5,6,5));
        costNewRoadsConstruct.add(Arrays.asList(3,6,1));
        int result=getMinimumCostToConstruct(6,3,availableRoads, 4,costNewRoadsConstruct);
        System.out.println(result);
    }

    public static int componentId=0;
    public static int getMinimumCostToConstruct(int numTotalAvailableCities,
                                                int numTotalAvailableRoads,
                                                List<List<Integer>> availableRoads,
                                                int numNewRoadsConstruct,
                                                List<List<Integer>> costNewRoadsConstruct)
    {
        if(numTotalAvailableCities<2){
            return 0;
        }
        int result=0;
        Map<Integer, Integer> map=new HashMap<>();
        for(List<Integer> road: availableRoads){
            union(map, road);
        }
        Queue<List<Integer>> pq=new PriorityQueue<>(numNewRoadsConstruct, (l1, l2)->{return l1.get(2)-l2.get(2);});
        for(List<Integer> road: costNewRoadsConstruct){
            pq.offer(road);
        }
        while(!pq.isEmpty()){
            List<Integer> road=pq.poll();
            if(union(map, road)){
                result+=road.get(2);
            }
        }
        int component=(int)map.values().toArray()[0];
        for(int key: map.keySet()){
            if(map.get(key)!=component){
                result=-1;
                break;
            }
        }
        return result;
    }

    public static boolean union(Map<Integer, Integer> map, List<Integer> road){
        int a=road.get(0);
        int b=road.get(1);
        if(!map.containsKey(a) && !map.containsKey(b)){
            map.put(a, componentId);
            map.put(b, componentId);
            componentId++;
            return true;
        } else if(map.containsKey(a) && !map.containsKey(b)){
            map.put(b, map.get(a));
            return true;
        } else if(!map.containsKey(a) && map.containsKey(b)){
            map.put(a, map.get(b));
            return true;
        } else{
            int componentA=map.get(a);
            int componentB=map.get(b);
            if(componentA==componentB){
                return false;
            } else {
                for(int key: map.keySet()){
                    if(map.get(key)==componentB){
                        map.put(key, componentA);
                    }
                }
                return true;
            }
        }
    }
}
