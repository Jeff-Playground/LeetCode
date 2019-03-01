package com.wen.FourthFifty;

public class LQReadNCharactersGivenRead4 {
    /* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

    private int read4(char[] buffer) {
        return 0;
    }

    // Iterative
    public int read(char[] buf, int n) {
        int charsRead=0;
        char[] buffer=new char[4];
        boolean eof=false;
        while(!eof && charsRead<n){
            int size=read4(buffer);
            if(size<4){
                eof=true;
            }
            if(charsRead+size>n){
                size=n-charsRead;
            }
            System.arraycopy(buffer, 0, buf, charsRead, size);
            charsRead+=size;
        }
        return charsRead;
    }
}
