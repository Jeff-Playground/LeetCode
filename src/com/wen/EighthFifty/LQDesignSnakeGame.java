package com.wen.EighthFifty;

/*
Design a Snake game that is played on a device with screen size = width x height. Play the game online if you are not familiar with the game.

The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

You are given a list of food's positions in row-column order. When a snake eats the food, its length and the game's score both increase by 1.

Each food appears one by one on the screen. For example, the second food will not appear until the first food was eaten by the snake.

When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

Example:

Given width = 3, height = 2, and food = [[1,2],[0,1]].

Snake snake = new Snake(width, height, food);

Initially the snake appears at position (0,0) and the food at (1,2).

|S| | |
| | |F|

snake.move("R"); -> Returns 0

| |S| |
| | |F|

snake.move("D"); -> Returns 0

| | | |
| |S|F|

snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

| |F| |
| |S|S|

snake.move("U"); -> Returns 1

| |F|S|
| | |S|

snake.move("L"); -> Returns 2 (Snake eats the second food)

| |S|S|
| | |S|

snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */

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
