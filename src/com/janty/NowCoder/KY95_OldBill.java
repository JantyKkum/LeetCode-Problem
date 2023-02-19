package com.janty.NowCoder;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/18 9:48
 * @description: 牛客网：https://www.nowcoder.com/practice/17a30153e092493e8b4d13f321343927?tpId=62&tPage=1&ru=%2Fkaoyan%2Fretest%2F2002&qru=%2Fta%2Fsju-kaoyan%2Fquestion-ranking&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
 */
public class KY95_OldBill {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int z = scanner.nextInt();
            int sum = 0, ans = 0, a = 0, b = 0;
            for (int i = 1; i <= 9; i++) {
                for (int j = 0; j <= 9; j++) {
                    sum = i * 10000 + x * 1000 + y * 100 + z * 10 + j;
                    if (sum % n == 0) {
                        ans = Math.max(sum / n,ans);
                        a = i;
                        b = j;
                    }
                }
            }
            if(ans == 0){
                System.out.println(ans);
            }else{
                System.out.println(a + " " + b + " " + ans);
            }
        }
    }
}
