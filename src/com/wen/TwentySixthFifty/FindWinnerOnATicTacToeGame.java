package com.wen.TwentySixthFifty;

public class FindWinnerOnATicTacToeGame {
    public String tictactoe(int[][] moves) {
        int[] row=new int[3], col=new int[3], dia=new int[2];
        for(int i=0; i<moves.length; i++){
            int[] move=moves[i];
            int x=move[0], y=move[1];
            if(i%2==0){
                row[x]++;
                col[y]++;
                if(x==y){
                    dia[0]++;
                }
                if(x+y==2){
                    dia[1]++;
                }
            } else{
                row[x]--;
                col[y]--;
                if(x==y){
                    dia[0]--;
                }
                if(x+y==2){
                    dia[1]--;
                }
            }
        }
        boolean aWin=false, bWin=false;
        for(int i=0; i<3; i++){
            if(row[i]==3 || col[i]==3){
                aWin=true;
            }
            if(row[i]==-3 || col[i]==-3){
                bWin=true;
            }
        }
        for(int i=0; i<2; i++){
            if(dia[i]==3){
                aWin=true;
            }
            if(dia[i]==-3){
                bWin=true;
            }
        }
        if(aWin){
            return "A";
        } else if(bWin){
            return "B";
        } else if(moves.length<9){
            return "Pending";
        } else{
            return "Draw";
        }
    }
}
