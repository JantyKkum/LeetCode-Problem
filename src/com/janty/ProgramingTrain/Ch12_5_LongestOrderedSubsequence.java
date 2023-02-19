package com.janty.ProgramingTrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: DP:最长递增子序列
 * @date: 2023/2/10 10:27
 * @description: POJ http://poj.org/problem?id=2533
 */
public class Ch12_5_LongestOrderedSubsequence {
    static final int MAXN = 1000 + 10;
    static int[] memo = new int[MAXN];
    static int[] arr = new int[MAXN];

    //朴素递归+记忆数组
    public static int fun2(int n){
        if(memo[n] != -1) return memo[n];
        int ans = 1;
        if(n == 0) {
            return ans;
        }else{
            ans = 1;
            for (int i = 0; i < n; i++) {
                if(arr[i] < arr[n]){
                    ans = Math.max(ans,fun2(i)+1);
                }
            }
        }
        memo[n] = ans;
        return ans;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Arrays.fill(memo,-1);           //初始化记忆数组memo
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {       //读入数据至数组arr
            arr[i] = scanner.nextInt();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans,fun2(i));
        }
        System.out.println(ans);
    }
}
