package com.wen.SixthFifty;

import java.util.Iterator;
import java.util.List;

public class LQFlatten2DVector {
    public class Vector2D implements Iterator<Integer> {
        List<List<Integer>> vec2d;
        int vec2dIndex=-1;
        int vec2dSize=-1;
        int index=-1;
        int[] vecIndices=null;

        int remove=-1;

        public Vector2D(List<List<Integer>> vec2d) {
            this.vec2d=vec2d;
            vec2dSize=this.vec2d.size();
            vec2dIndex=0;
            vecIndices=new int[vec2dSize];
            for(int i=0; i<vec2dSize; i++){
                vecIndices[i]=this.vec2d.get(i).size();
            }
            index=0;
        }

        @Override
        public Integer next() {
            if(hasNext()){
                remove=index;
                return this.vec2d.get(vec2dIndex).get(index++);
            } else{
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            if(vec2dIndex<vec2dSize){
                if(index<vecIndices[vec2dIndex]){
                    return true;
                } else{
                    index=0;
                    vec2dIndex++;
                    return hasNext();
                }
            } else{
                return false;
            }
        }

        @Override
        public void remove() {
            if(remove!=-1){
                this.vec2d.get(vec2dIndex).remove(remove);
                vecIndices[vec2dIndex]--;
                remove=-1;
            }
        }
    }
}
