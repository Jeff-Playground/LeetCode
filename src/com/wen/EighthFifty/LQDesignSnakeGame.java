package com.wen.EighthFifty;

import java.util.*;

public class LQDesignSnakeGame {
    class SnakeGame{
        int width=-1;
        int height=-1;
        int score=-1;
        int foodIndex=-1;
        List<int[]> food;
        Queue<Integer> snake;
        Set<Integer> snakeBody;

        public SnakeGame(int width, int height, List<int[]> food){
            this.width=width;
            this.height=height;
            this.food=food;
            score=0;
            snake=new LinkedList<>();
            snake.add(0*width+0);
            snakeBody.add(0*width+0);
            foodIndex=0;
        }

        public int move(String direction){
            int row=snake.peek()/width, col=snake.peek()%width;
            if(direction.equals("U")){
                row--;
            } else if(direction.equals("D")){
                row++;
            } else if(direction.equals("L")){
                col--;
            } else if(direction.equals("R")){
                col++;
            }
            // Cross boundary
            if(row<0 || row>=height || col<0 || col>=width){
                score=-1;
                return score;
            }
            if(foodIndex==food.size() || !(row==food.get(foodIndex)[0] && col==food.get(foodIndex)[1])){
                int tail=snake.poll();
                snakeBody.remove(tail);
            } else{
                score++;
                foodIndex++;
            }
            int newHead=row*width+col;
            if(snakeBody.contains(newHead)){  // Bite self
                score=-1;
                return score;
            } else{
                snake.offer(newHead);
                snakeBody.add(newHead);
            }
            return score;
        }
    }
}
