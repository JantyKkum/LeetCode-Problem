package com.janty.test;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/3 11:13
 * @description:
 */
public class Main {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String regex = "(\\d+)\\+i(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()){
            System.out.println(matcher.group(0));
            int x = Integer.parseInt(matcher.group(1));
            System.out.println("x = " + x);
            int y = Integer.parseInt(matcher.group(2));
            System.out.println("y = " + y);
        }
    }
}
