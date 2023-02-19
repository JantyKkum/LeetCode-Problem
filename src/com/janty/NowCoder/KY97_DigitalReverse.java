package com.janty.NowCoder;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/18 10:22
 * @description: 数字反转
 */
public class KY97_DigitalReverse {


    static int reverse(int num){
        int ans = 0;
        while (num / 10 != 0){
            ans *= 10;
            ans += num % 10;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int aRev = reverse(a);
            int bRev = reverse(b);
            if(reverse(a+b) == (aRev+bRev)){
                System.out.println(a+b);
            }else {
                System.out.println("No");
            }
        }
    }
}
