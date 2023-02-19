package com.janty.ProgramingTrain;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: DFS 注意减枝的方法
 * @date: 2023/2/4 10:48
 * @description: POJ:http://poj.org/problem?id=2362
 */
public class Ch9_4_Square {
    static int MAXM = 20 + 5;
    static boolean[] visit;         //访问数组记录是否遍历过
    static Integer[] arr;           //待处理的输入数组
    static int side;            //正方形的边长

    static boolean dfs(int current, int num, int position){
        if(num == 3) return true;
        int sample = 0;                         //记录失败的长度
        for (int i = position; i < arr.length; i++) {
            if(visit[i] || current+arr[i] > side || arr[i] == sample){
                continue;
            }
            visit[i] = true;
            if(current+arr[i] == side){         //当存在一条边满足要求时，num++
                if(dfs(0,num+1,0)) {
                    return true;
                }else {
                    sample = arr[i];
                }
            }else {
                if(dfs(current+arr[i],num,i+1)) {
                    return true;
                }else {
                    sample = arr[i];
                }
            }
            visit[i] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();              //n组样例输入
        for (int i = 0; i < n; i++) {
            int m = scanner.nextInt();
            int sum = 0;
            visit = new boolean[MAXM];          //初始化visit数组为false;
            arr = new Integer[m];
            for (int j = 0; j < m; j++) {       //每行的m个样例逐个输入
                arr[j] = scanner.nextInt();
                sum += arr[j];
            }
            if(sum % 4 != 0){                   //当总长无法被4整除时
                System.out.println("no");
                continue;
            }
            side = sum / 4;

            Arrays.sort(arr);

            if(arr[m-1] > side){                    //有超过边长的线段时，无需dfs
                System.out.println("no");
                continue;
            }

            if(dfs(0,0,0)){
                System.out.println("yes");
            }else {
                System.out.println("no");
            }
        }
        scanner.close();
        System.exit(0);


    }
}
