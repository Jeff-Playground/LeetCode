package com.wen.ThirteenthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FindDuplicateFileInSystem {
    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> grouped=new HashMap<>();
        for(String p: paths){
            String[] split=p.split("\\s");
            String dir=split[0];
            for(int i=1; i<split.length; i++){
                String[] fileSplit=split[i].split("\\(");
                String fileName=fileSplit[0], fileContent=fileSplit[1];
                grouped.putIfAbsent(fileContent, new ArrayList<>());
                grouped.get(fileContent).add(dir+"/"+fileName);
            }
        }
        return grouped.values().stream()
                .filter(item->item.size()>1)
                .collect(Collectors.toList());
    }
}
