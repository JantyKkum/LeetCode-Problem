package com.janty.NowCoder;

import java.awt.*;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/19 10:19
 * @description: 牛客网：https://www.nowcoder.com/practice/368c98c7bff54a30bba29ae1ba017d55?tpId=62&tPage=1&ru=%2Fkaoyan%2Fretest%2F2002&qru=%2Fta%2Fsju-kaoyan%2Fquestion-ranking&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
 */
public class KY98_BoardGame {
    static final int size = 6;
    static int[][] board = new int[size][size];
    static boolean[][] visit = new boolean[size][size];
    static int[][] direct = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int target_x, target_y, minCost = Integer.MAX_VALUE;

    static void dfs(int x,int y,int status,int cost){
        //一、节点处理
        if(x == target_x && y == target_y) {
            minCost = Math.min(cost,minCost);
            return;                                                                    //到达终点返回
        }
        if(visit[x][y]) return;
        if(cost > minCost) return;                                                     //剪枝
        //二、分支处理
        visit[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newx = x + direct[i][0];
            int newy = y + direct[i][1];
            if(newx < 0 || newx >= size || newy < 0 || newy >= size || visit[newx][newy]) continue;    //排除不可走的路线
//            cost += status * board[newx][newy];
//            status = cost % 4 + 1;
            int costAdd = status * board[newx][newy];
            int statusNew = costAdd % 4 + 1;
            dfs(newx,newy,statusNew,cost+costAdd);
        }
        visit[x][y] = false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            for (int i = 0; i < size; i++) {                                   //扫描输入数组
                for (int j = 0; j < size; j++) {
                    board[i][j] = scanner.nextInt();
                    visit[i][j] = false;                                       //初始化visit数组
                }
            }

            int x = scanner.nextInt();                                          //扫描起点
            int y = scanner.nextInt();                                          //扫描起点
            target_x = scanner.nextInt();                                   //扫描终点
            target_y = scanner.nextInt();                                   //扫描终点
            dfs(x,y,1,0);
            System.out.println(minCost);
        }
    }
}
