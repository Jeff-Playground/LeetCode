package com.wen.SecondFifty;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    // DFS
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        if(n<=0 || k<=0 || k>n) {
            return result;
        }
        List<Integer> out=new ArrayList<>();
        combineDFS(n, k, 1, out, result);
        return result;
    }

    private void combineDFS(int n, int k, int start, List<Integer> out, List<List<Integer>> result) {
        if(out.size()==k) {
            List<Integer> outCopy=new ArrayList<Integer>(out);
            result.add(outCopy);
        } else {
            for(int i=start; i<=n; i++) {
                out.add(i);
                combineDFS(n, k, i+1, out, result);
                out.remove(out.size()-1);
            }
        }
    }

//    // Adding each digits in order
//    public List<List<Integer>> combine(int n, int k) {
//        List<List<Integer>> result=new ArrayList<>();
//        List<Integer> out=new ArrayList<>();
//        for(int i=0; i<k; i++) {
//            out.add(0);
//        }
//        int i=0;
//        while(i>=0) {
//            out.set(i, out.get(i)+1);
//            if(out.get(i)>n) {
//                i--;
//            } else if(i==k-1) {
//                List<Integer> outCopy=new ArrayList<>(out);
//                result.add(outCopy);
//            } else {
//                i++;
//                out.set(i, out.get(i-1));
//            }
//        }
//        return result;
//    }

//    // C(n, k)=C(n-1, k-1)+C(n-1, k)
//    public List<List<Integer>> combine(int n, int k) {
//        if(k<0 || k>n) {
//        List<List<Integer>> temp=new ArrayList<>();
//        return temp;
//    }
//        if(k==0) {
//        List<List<Integer>> temp1=new ArrayList<>();
//        List<Integer> temp2=new ArrayList<>();
//        temp1.add(temp2);
//        return temp1;
//    }
//    List<List<Integer>> result=new ArrayList<>();
//    result=combine(n-1, k-1);
//        for(List<Integer> element: result) {
//        element.add(n);
//    }
//        result.addAll(combine(n-1, k));
//        return result;
//    }
}
