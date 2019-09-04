package com.wen.Airbnb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TwoDListIterator {
    public static void main(String args[]) {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(3));
        List<List<Integer>> vec2d = new ArrayList<>();
        vec2d.add(list1);
        vec2d.add(list2);
        //1,2
        //3
        MyIterator myIter = new MyIterator(vec2d);
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());
        System.out.println(myIter.hasNext());
        myIter.remove();
        System.out.println(myIter.next());
        for (int i = 0; i < vec2d.size(); i++) {
            if (vec2d.get(i) == null) continue;
            for (int j = 0; j < vec2d.get(i).size(); j++) {
                System.out.println("List" + i + ":" + vec2d.get(i).get(j));
            }

        }
        System.out.println(myIter.hasNext());
        System.out.println(myIter.next());
    }
}

class MyIterator implements Iterator<Integer> {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;

    public MyIterator(List<List<Integer>> vec2d){
        i=vec2d.iterator();
        j=null;
    }

    @Override
    public boolean hasNext(){
        while((j==null || !j.hasNext()) && i.hasNext()){
            j=i.next().iterator();
        }
        return j!=null && j.hasNext();
    }

    @Override
    public Integer next(){
        if(!hasNext()){
            return null;
        }
        return j.next();
    }

    public void remove(){
//        // This part removes the next value if next() hasn't been called yet
//        while(j==null && i.hasNext()){
//            j=i.next().iterator();
//        }
        if(j!=null){
            j.remove();
        }
    }
}
