package com.janty.NowCoder;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/19 14:56
 * @description: 牛客网：https://www.nowcoder.com/practice/42cb1c7f7344466b8cb1710cb12d06b1?tpId=62&tPage=1&ru=%2Fkaoyan%2Fretest%2F2002&qru=%2Fta%2Fsju-kaoyan%2Fquestion-ranking&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
 */
public class KY99_SumofFactorials {
    static int[] arr = new int[10];                 //定义前缀和数组

    static void initArr(){                          //初始化前缀和数组
        int mult = 1,sum = 1;
        arr[0] = 1;
        for (int i = 1; i < 10; i++) {
            mult *= i;
            arr[i] = arr[i-1] + mult;
        }
    }

    static boolean isFactorials(int n){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] - arr[j] == n) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            initArr();
            int n = scanner.nextInt();
            if(isFactorials(n)){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
