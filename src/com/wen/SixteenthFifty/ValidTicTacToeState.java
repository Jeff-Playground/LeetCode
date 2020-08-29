package com.wen.SixteenthFifty;

public class ValidTicTacToeState {
    public static boolean validTicTacToe(String[] board) {
        int l=3;
        int xTotal=0, oTotal=0;
        boolean xWin=false, oWin=false;
        int[] row=new int[l], col=new int[l], dia=new int[2];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(board[i].charAt(j)=='X'){
                    xTotal++;
                    row[i]++;
                    col[j]++;
                    if(i==j){
                        dia[0]++;
                    }
                    if(i==l-1-j){
                        dia[1]++;
                    }
                } else if(board[i].charAt(j)=='O'){
                    oTotal++;
                    row[i]--;
                    col[j]--;
                    if(i==j){
                        dia[0]--;
                    }
                    if(i==l-1-j){
                        dia[1]--;
                    }
                }
            }
        }
        for(int i=0; i<l; i++){
            if(row[i]==3 || col[i]==3){
                xWin=true;
            } else if(row[i]==-3 || col[i]==-3){
                oWin=true;
            }
        }
        for(int i=0; i<2; i++){
            if(dia[i]==3){
                xWin=true;
            } else if(dia[i]==-3){
                oWin=true;
            }
        }
        if(xWin && oWin){
            return false;
        } else if(xWin){
            return xTotal==oTotal+1;
        } else if(oWin){
            return xTotal==oTotal;
        } else{
            return xTotal-oTotal>=0 && xTotal-oTotal<=1;
        }
    }
}
