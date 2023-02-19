package com.janty.ProgramingTrain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/3 11:13
 * @description:
 */
public class Ch9_2_FindTheMultiple {

    static void bfs(int n){
        Queue<Long> queue = new LinkedList<Long>();
        queue.add(1l);
        while(!queue.isEmpty()){
            long temp = queue.poll();
            if(temp % n == 0){
                System.out.println(temp);
                return;
            }
            queue.add(temp * 10);
            queue.add(temp * 10 +1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            if(n == 0) break;
            bfs(n);
        }
        scanner.close();
        System.exit(0);
    }
}
