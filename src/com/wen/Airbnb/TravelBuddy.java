package com.wen.Airbnb;

import java.util.*;

public class TravelBuddy {
    public static void main(String args[]){
        Set<String> myList = new HashSet<>(Arrays.asList("A", "B", "C", "D"));

        Set<String> peter = new HashSet<>(Arrays.asList("A", "B", "E", "F"));
        Set<String> john = new HashSet<>(Arrays.asList("A", "B", "D", "G"));
        Set<String> casy = new HashSet<>(Arrays.asList("X", "B", "A", "D", "Q"));
        Set<String> jason = new HashSet<>(Arrays.asList("A", "B", "C", "D", "P", "Q"));
        Set<String> ken = new HashSet<>(Arrays.asList("A", "X", "Y", "Z"));

        Map<String, Set<String>> friendLists = new HashMap<>();
        friendLists.put("peter", peter);
        friendLists.put("john", john);
        friendLists.put("casy", casy);
        friendLists.put("jason", jason);
        friendLists.put("ken", ken);


        Solution solution = new Solution(myList, friendLists);
        List<Buddy> buddies = solution.findBuddies();
        for (int i = 0; i < buddies.size(); i++) {
            Buddy b = buddies.get(i);
            System.out.println("Name: " + b.name + " sim: " + b.sim);
        }

        Set<String> cities = solution.recommend(5);
        for (String city : cities) {
            System.out.println(city);
        }
    }

    static class Solution {

        private List<Buddy> buddies;
        private Set<String> myList;
        private Map<String, Set<String>> friendLists;

        public Solution(Set<String> myList, Map<String, Set<String>> friendLists) {
            this.myList = myList;
            this.friendLists = friendLists;
        }

        public List<Buddy> findBuddies() {
            List<Buddy> buddies = new ArrayList<>();
            for (Map.Entry<String, Set<String>> entry : friendLists.entrySet()) {
                Set<String> common = new HashSet<>(myList);
                String name = entry.getKey();
                Set<String> wishList = entry.getValue();
                common.retainAll(wishList);
                if (common.size() >= myList.size() / 2) {
                    buddies.add(new Buddy(name, common.size(), wishList));
                }
            }
            Collections.sort(buddies, new Comparator<Buddy>(){
                public int compare(Buddy b1, Buddy b2) {
                    return b2.sim - b1.sim;
                }
            });
            this.buddies = buddies;
            return buddies;
        }

        public Set<String> recommend(int k){
            Set<String> result = new LinkedHashSet<>();
            for (Buddy buddy : buddies) {
                //注意是从buddy的list中remove我的list，而不是从我的list中remove他们的
                Set<String> diff = new HashSet<>(buddy.list);
                diff.removeAll(myList);
                for (String city : diff) {
                    if (result.size() < k) {
                        result.add(city);
                    } else {
                        return result;
                    }
                }
            }
            return result;
        }
    }
    //Buddy类写Solution类外面，要不然访问不到
    static class Buddy {
        String name;
        int sim;
        Set<String> list;
        public Buddy(String name, int sim, Set<String> list) {
            this.name = name;
            this.sim = sim;
            this.list = list;
        }
    }
}
