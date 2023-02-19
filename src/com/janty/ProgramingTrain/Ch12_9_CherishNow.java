package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 背包问题：多重背包
 * @date: 2023/2/12 10:48
 * @description: HDU 2191
 */
public class Ch12_9_CherishNow {
    static final int MAXN =  100+10;
    static int[] weight = new int[MAXN * 20];
    static int[] value = new int[MAXN * 20];
    static int[][] dp = new int[MAXN][MAXN];
    static int[] dp2 = new int[MAXN];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        while (count-- > 0){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int cnt = 0;
            for (int i = 0; i < n; i++) {       //每组数据输入
                int pri = scanner.nextInt();
                int wei = scanner.nextInt();
                int num = scanner.nextInt();
                int temp = 0;
                for(int j = 1; j<= num; j=j*2){
                    weight[cnt] = pri * j;
                    value[cnt] = wei * j;
                    cnt++;
                    temp = num -j;
                }
                if(temp > 0) {
                    weight[cnt] = pri * temp;
                    value[cnt] = wei * temp;
                }
            }

//            for (int i = 0; i <= m; i++) {
//                dp2[i] = 0;
//            }
//            for (int i = 1; i <= cnt; i++) {
//                for (int j = m; j >= weight[i]; j--) {
//                    dp2[j] = Math.max(dp2[j],dp2[j-weight[i]]+value[i]);
//                }
//            }
//            System.out.println(cnt);
//            System.out.println(dp2[m]);

            for (int i = 0; i <= cnt; i++) {      //初始化
                dp[i][0] = 0;
            }
            for (int j = 0; j <= m; j++) {
                dp[0][j] = 0;
            }

            for (int i = 1; i <= cnt; i++) {
                for (int j = 1; j <= m; j++) {
                    if(j < weight[i]) {
                        dp[i][j] = dp[i-1][j];
                    }else {
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-weight[i]]+value[i]);
                    }
                }
            }
            System.out.println(cnt);
            System.out.println(dp[cnt][m]);
        }
    }
}
