package com.janty.ProgramingTrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 动态规划-最大连续子序列和
 * @date: 2023/2/9 11:07
 * @description:
 */
public class Ch12_2_MaxContinuousOrder {
    static int MAXN = 1000000+10;
    static long[] arr = new long[MAXN];
    static long[] memo = new long[MAXN];

    //朴素递归
    public static long maxSum1(long[] arr,int end){
        if(end == 0) return arr[end];
        return Math.max(arr[end],maxSum1(arr, end-1)+arr[end]);
    }

    //优化递归，利用数组存放
    public static long maxSum2(int end){
        long ans;
        if(memo[end] != Integer.MIN_VALUE){
            return memo[end];
        }
        if(end == 0) {
            ans = arr[0];
        }else {
            ans = Math.max(arr[end], maxSum2(end - 1) + arr[end]);
        }
        memo[end] = ans;
        return ans;
    }

    //自底向上完成memo数组的记录设置
    public static void maxSum3(int end){
        for (int i = 0; i < end; i++) {
            if(i == 0) {
                memo[i] = arr[0];
            }else {
                memo[i] = Math.max(arr[i], memo[i - 1] + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            Arrays.fill(arr,Integer.MIN_VALUE);         //初始化
            Arrays.fill(memo,Integer.MIN_VALUE);         //初始化
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            long ans = arr[0];
            maxSum3(n);
            for (int i = 0; i < n; i++) {
//                ans = Math.max(ans,maxSum2(i));
                ans = Math.max(ans,memo[i]);
            }
            System.out.println(ans);
        }

    }
}
