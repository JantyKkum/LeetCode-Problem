package com.janty.NowCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/18 10:10
 * @description:
 */
public class KY96_Fibonacci {
    static final int MAXN = 30+5;
    static int[] fibList = new int[MAXN];

    public static void fibonacci(){
        fibList[0] = 1;
        fibList[1] = 1;
        for (int i = 2; i < MAXN; i++) {
            fibList[i] = fibList[i-1] + fibList[i-2];
        }
    }

    public static void main(String[] args) throws IOException {
        fibonacci();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while ((s = br.readLine()) != null){
            int i = Integer.parseInt(s);
            System.out.println(fibList[i]);
        }

    }
}
