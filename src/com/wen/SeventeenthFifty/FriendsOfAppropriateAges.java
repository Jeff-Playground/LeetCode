package com.wen.SeventeenthFifty;

public class FriendsOfAppropriateAges {
//    // The 3 conditions:
//    //      y <= 0.5 * x + 7
//    //      y > x
//    //      y > 100 && x < 100
//    // condition 3 is redundant, and since these are the condition for x NOT sending friend request to y.
//    // So the condition for x to send friend request to y would be:
//    //      0.5 * x + 7 < y <=x
//    // also since 0.5 * x + 7 < x, we also have:
//    //      x>14
//    public int numFriendRequests(int[] ages) {
//        int[] count=new int[121];
//        for(int a: ages){
//            count[a]++;
//        }
//        int result=0;
//        for(int i=15; i<=120; i++){
//            int cur=0;
//            for(int j=i/2+7+1; j<=i; j++){
//                cur+=count[j];
//            }
//            if(cur>1){
//                // use (cur-1) because i as the sender is also included in cur
//                result+=(cur-1)*count[i];
//            }
//        }
//        return result;
//    }

    // Similar idea except also build a rangeCount array to avoid the for loop for adding range counts
    public int numFriendRequests(int[] ages) {
        int[] count=new int[121];
        for(int a: ages){
            count[a]++;
        }
        int[] rangeCount=new int[121];
        for(int i=1; i<=120; i++){
            rangeCount[i]+=count[i]+rangeCount[i-1];
        }
        int result=0;
        for(int i=15; i<=120; i++){
            int cur=rangeCount[i]-rangeCount[i/2+7];
            if(cur>1){
                result+=(cur-1)*count[i];
            }
        }
        return result;
    }
}
