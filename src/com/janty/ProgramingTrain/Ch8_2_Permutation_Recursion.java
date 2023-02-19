package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: Ch8.2 全排列——递归方式
 * @date: 2023/2/2 11:36
 * @description: 牛客网 http://t.cn/Ai0K0hXZ
 */
public class Ch8_2_Permutation_Recursion {
    static int n = 10;
    static boolean[] visit = new boolean[n];
    static char[] sequence = new char[n];

    static void getSequence(String str,int depth){
        if(depth == str.length()){
            for (int i = 0; i < str.length(); i++) {
                System.out.print(sequence[i]);
            }
            System.out.println();
        }
        for (int i = 0; i < str.length(); i++) {
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            sequence[depth] = str.charAt(i);
            getSequence(str,depth+1);
            visit[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();        //输入原始字符串
        getSequence(str,0);
    }
}
