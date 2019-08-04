package com.wen.TwelfthFifty;

public class StudentAttendanceRecordI {
    public boolean checkRecord(String s) {
        int absentCount=0, lateCount=0;
        for(char c: s.toCharArray()){
            if(c=='A'){
                lateCount=0;
                if(absentCount==1){
                    return false;
                } else{
                    absentCount++;
                }
            } else if(c=='L'){
                if(lateCount==2){
                    return false;
                } else{
                    lateCount++;
                }
            } else{
                lateCount=0;
            }
        }
        return true;
    }
}
