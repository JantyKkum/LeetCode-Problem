package com.janty.ProgramingTrain;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/6 22:19
 * @description:
 */
public class Ch10_6_HuffmanTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt(),ans = 0;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            while (n-- > 0){
                queue.add(scanner.nextInt());
            }
            while (queue.size() != 1){
                Integer weight1 = queue.poll();
                Integer weight2 = queue.poll();
                queue.add(weight1+weight2);
                ans += weight1+weight2;
            }
            System.out.println(ans);

        }
        scanner.close();
        System.exit(0);
    }
}
