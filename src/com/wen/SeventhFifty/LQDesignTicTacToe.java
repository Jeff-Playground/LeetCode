package com.wen.SeventhFifty;

/*
Design a Tic-tac-toe game that is played between two players on a n x n grid.

You may assume the following rules:

A move is guaranteed to be valid and is placed on an empty block.
Once a winning condition is reached, no more moves is allowed.
A player who succeeds in placing n of their marks in a horizontal, vertical, or diagonal row wins the game.


Example:

Given n = 3, assume that player 1 is "X" and player 2 is "O" in the board.

TicTacToe toe = new TicTacToe(3);

toe.move(0, 0, 1); -> Returns 0 (no one wins)
|X| | |
| | | |    // Player 1 makes a move at (0, 0).
| | | |

toe.move(0, 2, 2); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 2 makes a move at (0, 2).
| | | |

toe.move(2, 2, 1); -> Returns 0 (no one wins)
|X| |O|
| | | |    // Player 1 makes a move at (2, 2).
| | |X|

toe.move(1, 1, 2); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 2 makes a move at (1, 1).
| | |X|

toe.move(2, 0, 1); -> Returns 0 (no one wins)
|X| |O|
| |O| |    // Player 1 makes a move at (2, 0).
|X| |X|

toe.move(1, 0, 2); -> Returns 0 (no one wins)
|X| |O|
|O|O| |    // Player 2 makes a move at (1, 0).
|X| |X|

toe.move(2, 1, 1); -> Returns 1 (player 1 wins)
|X| |O|
|O|O| |    // Player 1 makes a move at (2, 1).
|X|X|X|


Follow up:
Could you do better than O(n^2) per move()

Hint:
Could you trade extra space such that move() operation can be done in O(1)?
You need two arrays: int rows[n], int cols[n], plus two variables: diagonal, anti_diagonal.
 */

public class LQDesignTicTacToe {
//    // O(n^2)
//    public class TicTacToe{
//
//        private int[][] board;
//
//        public TicTacToe(int n){
//            board=new int[n][n];
//        }
//
//        public int move(int row, int col, int player){
//            board[row][col]=player;
//            int n=board.length, i=0, j=0;
//            while(i<n){
//                if(board[i][col]!=player){
//                    break;
//                }
//                i++;
//            }
//            if(i==n){
//                return player;
//            }
//            while(j<n){
//                if(board[row][j]!=player){
//                    break;
//                }
//                j++;
//            }
//            if(j==n){
//                return player;
//            }
//            if(row==col){
//                i=0;
//                j=0;
//                while(i<n){
//                    if(board[i][j]!=player){
//                        break;
//                    }
//                    i++;
//                    j++;
//                }
//                if(i==n){
//                    return player;
//                }
//            } else if(row+col==n-1){
//                i=n-1;
//                j=0;
//                while(i>=0){
//                    if(board[i][j]!=player){
//                        break;
//                    }
//                    i--;
//                    j++;
//                }
//                if(i==n){
//                    return player;
//                }
//            }
//            return 0;
//        }
//    }

    public class TicTacToe{
        int[] rows, cols;
        int diag, revDiag, N;

        public TicTacToe(int n){
            rows=new int[n];
            cols=new int[n];
            diag =0;
            revDiag=0;
            N=n;
        }

        public int move(int row, int col, int player){
            int diff=player==1?1:-1;
            rows[row]+=diff;
            cols[col]+=diff;
            if(row==col){
                diag +=diff;
            } else if(row+col==N-1){
                revDiag+=diff;
            }
            return (Math.abs(rows[row])==N || Math.abs(cols[col])==N || Math.abs(diag)==N ||
                    Math.abs(revDiag)==N)?player:0;
        }
    }
}
