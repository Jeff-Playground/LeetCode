package com.wen.TwelfthFifty;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        if (list1 == null || list1.length == 0 || list2 == null || list2.length == 0) {
            throw new IllegalArgumentException("Invalid input!");
        } else {
            Map<String, Integer> map1 = new HashMap<>();
            int min = Integer.MAX_VALUE;
            List<String> result = new ArrayList<>();
            for (int i = 0; i < list1.length; i++) {
                map1.put(list1[i], i);
            }
            for (int i = 0; i < list2.length; i++) {
                if (map1.containsKey(list2[i])) {
                    if (map1.get(list2[i]) + i < min) {
                        min = map1.get(list2[i]) + i;
                        result = new ArrayList<>();
                        result.add(list2[i]);
                    } else if (map1.get(list2[i]) + i == min) {
                        result.add(list2[i]);
                    }
                }
            }
            return result.toArray(new String[result.size()]);
        }
    }
}
