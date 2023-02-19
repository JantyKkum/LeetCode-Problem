package com.janty.test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author 简义涛
 * @version V1.0
 */
public class Test_20230201_HorseChessBoard {
    static int row = 8;
    static int col = 8;
    static int[][] board = new int[row][col];
    static int step = 1;
    static class Coordinate{
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //找到下一步的方法
    public static List<Coordinate> findNextStep(Coordinate c){
        ArrayList<Coordinate> list = new ArrayList<>();
        if(board[c.x+2][c.y] == 0 && c.x+2<8 && 0<=c.y-1){
            list.add(new Coordinate(c.x,c.y));
        }else if(board[c.x][c.y] == 0 && 0<=c.x && c.x<8 && 0<=c.y && c.y<8){
            list.add(new Coordinate(c.x,c.y));
        }
        return list;
    }

    public static void main(String[] args) {
        //1.假设从点（0,0）开始
        Coordinate start = new Coordinate(0, 0);
        board[0][0] = step;
        //2.可走的下一步入栈，选择走下一步
        Stack<Coordinate> stack = new Stack<>();
        List<Coordinate> list = findNextStep(start);
        for (Coordinate coordinate : list) {
            stack.push(coordinate);
        }
        //3.选择下一步为栈顶元素

        //打印结果
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
