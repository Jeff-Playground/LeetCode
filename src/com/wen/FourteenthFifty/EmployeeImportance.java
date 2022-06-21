package com.wen.FourteenthFifty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class EmployeeImportance {
    class Employee {
        public int id;
        public int importance;
        public List<Integer> subordinates;
    }

    // DFS
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map=new HashMap<>();
        for(Employee e: employees){
            map.put(e.id, e);
        }
        int result=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(id);
        while(!stack.isEmpty()){
            Employee cur=map.get(stack.pop());
            result+=cur.importance;
            for(int v: cur.subordinates){
                stack.push(v);
            }
        }
        return result;
    }
}
