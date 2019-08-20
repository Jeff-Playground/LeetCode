import java.util.*;

public class AirbnbTest {
//    Input
//    A Munich Support B
//    B Bohemia Move Prussia
//    C Prussia Hold
//    D Warsaw Move Munich
//
//    Output
//    A [dead]
//    B [dead]
//    C [dead]
//    D [dead]
    static List<String> evaluateActions(List<String> actions) {
        Map<String, Set<String>> locs=new HashMap<>();
        Map<String, Integer> sup=new HashMap<>();
        Map<String, String> pending=new HashMap<>();
        Map<String, String> endState=new TreeMap<>();

        for(String action: actions){
            String[] actSplit=action.split("\\s+");
            String army=actSplit[0], orig=actSplit[1], act=actSplit[2];
            if(act.equals("Hold")){
                locs.putIfAbsent(orig, new HashSet<>());
                locs.get(orig).add(army);
                sup.put(army, sup.getOrDefault(army, 0)+1);
            } else if(act.equals("Move")){
                String dest=actSplit[3];
                locs.putIfAbsent(dest, new HashSet<>());
                locs.get(dest).add(army);
                sup.put(army, sup.getOrDefault(army, 0)+1);
            } else if(act.equals("Support")){
                String supported=actSplit[3];
                locs.putIfAbsent(orig, new HashSet<>());
                locs.get(orig).add(army);
                pending.put(army, supported);
                sup.put(army, sup.getOrDefault(army, 0)+1);
            }
        }

        for(String loc: locs.keySet()){
            if(locs.get(loc).size()>1){
                for(String army: locs.get(loc)){
                    pending.remove(army);
                }
            }
        }

        for(String army: pending.values()){
            sup.put(army,sup.getOrDefault(army, 0)+1);
        }

        for(String loc: locs.keySet()){
            if(locs.get(loc).size()==1){
                endState.put(locs.get(loc).iterator().next(), loc);
            } else{
                String last=null;
                int count=-1;
                boolean diff=false;
                for(String army: locs.get(loc)){
                    if(last==null){
                        last=army;
                        count=sup.getOrDefault(last,0);
                    } else{
                        int cur=sup.get(army);
                        if(cur!=count){
                            diff=true;
                            if(cur>count){
                                last=army;
                                count=cur;
                            }
                        }
                    }
                }
                for(String army: locs.get(loc)){
                    endState.put(army, "[dead]");
                }
                if(diff){
                    endState.put(last, loc);
                }
            }
        }

        List<String> result=new ArrayList<>();
        for(String army: endState.keySet()){
            result.add(army+" "+endState.get(army));
        }
        return result;
    }
}
