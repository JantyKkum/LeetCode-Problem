package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 并查集
 * @date: 2023/2/7 9:30
 * @description: 牛客网：https://www.nowcoder.com/practice/569e89823a5141fe8a11ab7d4da21edf?tpId=65&tqId=29622&tPage=1&ru=/kaoyan/retest/4001&qru=/ta/jlu-kaoyan/question-ranking
 */
public class CH11_2_ConnectedGraph {
    static int MAXN = 1000+10;
    static int[] arr = new int[MAXN];
    static int[] height = new int[MAXN];

    //初始化方法
    public static void initial(int n){
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
            height[i] = 0;
        }
    }

    //find方法
    public static int find(int i){
        if(arr[i] != i){
            arr[i] = find(arr[i]);
        }
        return arr[i];
    }

    //Union方法
    public static void union(int i ,int j){
        i = find(i);
        j = find(j);
        if(i != j){                 //不属于同一集合时才合并
            if(height[i] > height[j]){
                arr[j] = i;
            }else if(height[i] < height[j]){
                arr[i] = j;
            }else {
                arr[i] = j;
                height[j]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()){
            int n = scanner.nextInt();      //第一行的n
            int m = scanner.nextInt();      //第一行的m
            if(n==0 && m==0) break;

            initial(n);                      //初始化
            while (m-- > 0){                //m行数据输入
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                union(a,b);
            }
            int component = 0;
            for (int i = 1; i <= n; i++) {
                if(arr[i] == i){
                    component++;
                }
            }
            if (component == 1) System.out.println("YES");
            if (component != 1) System.out.println("NO");
        }
        scanner.close();
        System.exit(0);
    }
}
