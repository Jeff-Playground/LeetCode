package com.wen.SixthFifty;

public class LQFindTheCelebrity {
    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    public boolean knows(int a, int b){
        return true;
    }

    public int findCelebrity(int n) {
        int celebrity=0;
        for(int i=1; i<n; i++){
            if(knows(celebrity, i)){
                celebrity=i;
            }
        }
        for(int i=0; i<celebrity; i++){
            if(i!=celebrity && (knows(celebrity, i) || !knows(i, celebrity))){
                return -1;
            }
        }
        for(int i=celebrity+1; i<n; i++){
            if(i!=celebrity && !knows(i, celebrity)){
                return -1;
            }
        }
        return celebrity;
    }

//    // My way
//    public int findCelebrity(int n) {
//        int celebrity=-1;
//        for(int i=0; i<n; i++){
//            boolean isCelebrity=true;
//            for(int j=0; j<n; j++){
//                if(j!=i && knows(i, j)){
//                    isCelebrity=false;
//                    break;
//                }
//            }
//            if(isCelebrity==true){
//                celebrity=i;
//                break;
//            }
//        }
//        if(celebrity==-1){
//            return -1;
//        } else{
//            for(int i=0; i<n; i++){
//                if(i!=celebrity && !knows(i, celebrity)){
//                    return -1;
//                }
//            }
//            return celebrity;
//        }
//    }
}
