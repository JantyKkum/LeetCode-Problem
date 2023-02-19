package com.janty.ProgramingTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 背包问题：0-1背包
 * @date: 2023/2/11 9:17
 * @description: 牛客网：https://www.nowcoder.com/practice/b44f5be34a9143aa84c478d79401e22a?tpId=61&tqId=29538&tPage=2&ru=/kaoyan/retest/1002&qru=/ta/pku-kaoyan/question-ranking
 *               可以化简为1维数组，j从大至小进行遍历
 */
public class Ch12_7_OrderDishes {
    static final int MAXC =  1000+10;
    static final int MAXN =  10000+10;
    static int[] cost = new int[MAXC];
    static int[] score = new int[MAXC];
    static int[][] dp = new int[MAXC][MAXC];   //初始化

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int c = scanner.nextInt();          //总额度》》》列
            int n = scanner.nextInt();          //可点菜目》》》行

            for (int i = 1; i <= n; i++) {      //数组输入数据
                cost[i] = scanner.nextInt();
                score[i] = scanner.nextInt();
            }
            for (int i = 0; i <= n; i++) {      //0行初始化
                dp[i][0] = 0;
            }
            for (int j = 0; j <= c; j++) {      //0列初始化
                dp[0][j] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= c; j++) {
                    if(j < cost[i]) {
                        dp[i][j] = dp[i-1][j];      //情况1：不购买
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-cost[i]]+score[i]);      //情况2：购买
                    }
                }
            }

            System.out.println(dp[n][c]);
        }
    }
}
