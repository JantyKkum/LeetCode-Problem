package com.janty.ProgramingTrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: DP:最长的相同子序列
 * @date: 2023/2/10 20:27
 * @description: POJ：http://poj.org/problem?id=1458
 */
public class Ch12_6_CommonSubsequence {
    static int[][] memo = new int[1000+10][1000+10];

    public static int findCommon(char[] c1,int n1,char[] c2,int n2){
        if(memo[n1][n2] != -1){
            return memo[n1][n2];
        }
        int ans = 0;
        if(n1 == 0 || n2 == 0) {
            memo[0][0] = 0;
            return ans;
        }
        //分析子问题，长度都-1的情况
        if(c1[n1-1] == c2[n2-1]){            //①序列末尾字符相同
            memo[n1 -1][n2 -1] = findCommon(c1,n1-1,c2,n2-1);
            ans = memo[n1 -1][n2 -1] + 1;
        }else {                             //②序列末尾字符不同
            memo[n1][n2 -1] = findCommon(c1,n1,c2,n2-1);
            memo[n1 -1][n2] = findCommon(c1,n1-1,c2,n2);
            ans = Math.max(memo[n1][n2 -1], memo[n1 -1][n2]);
        }
        memo[n1][n2] = ans;
        return ans;
    }


    public static void findCommon2(char[] c1,char[] c2){
        for (int i = 0; i <= c1.length; i++) {
            for (int j = 0; j <= c2.length; j++) {
                if(i == 0 || j == 0) {
                    memo[i][j] = 0;
                }else{
                    if(c1[i-1] == c2[j-1]){                  //①序列末尾字符相同v
                        memo[i][j] = memo[i-1][j-1] + 1;
                    }else {                             //②序列末尾字符不同
                        memo[i][j] = Math.max(memo[i][j-1], memo[i-1][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            for (int i = 0; i < 1000+10; i++) {
                Arrays.fill(memo[i],-1);       //初始化数组
            }
            char[] c1 = scanner.next().toCharArray();
            char[] c2 = scanner.next().toCharArray();
//            System.out.println(findCommon2(c1,c1.length,c2,c2.length));
            findCommon2(c1,c2);
            System.out.println(memo[c1.length][c2.length]);
        }
        scanner.close();
        System.exit(0);
    }
}
