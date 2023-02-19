package com.janty.NowCoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/17 9:36
 * @description:
 */
public class KY93_WERTYU {


    public static void main(String[] args) {
        String pattern = "`1234567890-=QWERTYUIOP[]\\ASDFGHJKL;'ZXCVBNM,./";
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            char[] chars = str.toCharArray();
            for (int i = 0; i < str.length(); i++) {
                if(chars[i] != ' '){
                    int tempIndex = pattern.indexOf(chars[i]);
                    chars[i] = pattern.charAt(tempIndex-1);
                }
            }
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
            }
            System.out.println();
        }
        scanner.close();
        System.exit(0);
    }
}
