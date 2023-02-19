package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 背包问题：完全背包
 * @date: 2023/2/12 10:11
 * @description: HDU 4508
 */
public class Ch12_8_LoseWeight {
    static final int MAXN =  100+10;
    static final int MAXM =  100000+10;
    static int[] weight = new int[MAXN];      //数量限制》》n
    static int[] value = new int[MAXN];       //幸福度，放入最多东西》》m
    static int[][] dp = new int[MAXN][MAXM];       //幸福度，放入最多东西》》m

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();          //数量》》》row
            for (int i = 1; i <= n; i++) {
                value[i] = scanner.nextInt();
                weight[i] = scanner.nextInt();
            }
            int m = scanner.nextInt();          //容量》》》column

            for (int i = 0; i <= n; i++) {      //初始化
                dp[i][0] = 0;
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 0;
            }

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    if(j < weight[i]) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i]);
                    }
                }
            }
            System.out.println(dp[n][m]);
        }
    }

}
