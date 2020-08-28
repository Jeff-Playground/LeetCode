package com.wen.SixteenthFifty;

public class ValidTicTacToeState {
    public static boolean validTicTacToe(String[] board) {
        int l=3;
        int xTotal=0, oTotal=0;
        boolean xWin=false, oWin=false;
        int[] xRow=new int[l], oRow=new int[l], xCol=new int[l], oCol=new int[l], xDia=new int[2], oDia=new int[2];
        for(int i=0; i<l; i++){
            for(int j=0; j<l; j++){
                if(board[i].charAt(j)=='X'){
                    xTotal++;
                    xRow[i]++;
                    xCol[j]++;
                    if(i==j){
                        xDia[0]++;
                    }
                    if(i==l-1-j){
                        xDia[1]++;
                    }
                } else if(board[i].charAt(j)=='O'){
                    oTotal++;
                    oRow[i]++;
                    oCol[j]++;
                    if(i==j){
                        oDia[0]++;
                    }
                    if(i==l-1-j){
                        oDia[1]++;
                    }
                }
            }
        }
        for(int i=0; i<l; i++){
            if(xRow[i]==3 || xCol[i]==3){
                xWin=true;
            } else if(oRow[i]==3 ||oCol[i]==3){
                oWin=true;
            }
        }
        for(int i=0; i<2; i++){
            if(xDia[i]==3){
                xWin=true;
            } else if(oDia[i]==3){
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
