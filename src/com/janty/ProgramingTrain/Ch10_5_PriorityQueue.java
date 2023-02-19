package com.janty.ProgramingTrain;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/6 11:19
 * @description:
 */
public class Ch10_5_PriorityQueue {
    //定义复数结构体
    static class Plurality{
        int x;
        int y;

        public Plurality() {
        }

        public Plurality(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    //定义方法1：Pop
    public static void Pop(PriorityQueue<Plurality> priorityQueue){
        if(priorityQueue.isEmpty()){
            System.out.println("empty");
        }else {
            Plurality temp = priorityQueue.poll();
            System.out.println(temp.x + "+i" +temp.y);
            System.out.println("SIZE = " +priorityQueue.size());
        }
    }

    //定义方法2：Insert
    public static void Insert(PriorityQueue<Plurality> priorityQueue,int x, int y){
        priorityQueue.add(new Plurality(x,y));
        System.out.println("SIZE = " +priorityQueue.size());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            PriorityQueue<Plurality> priorityQueue = new PriorityQueue<Plurality>(new Comparator<Plurality>() {
                @Override
                public int compare(Plurality o1, Plurality o2) {
                    if((o2.x * o2.x + o2.y * o2.y) == (o1.x * o1.x + o1.y * o1.y)){
                        return o2.x -o1.x;
                    }else {
                        return (o2.x * o2.x + o2.y * o2.y) - (o1.x * o1.x + o1.y * o1.y);
                    }
                }
            });

            while (n-->0){
                String op = scanner.next();

                switch (op) {
                    case "Pop":
                        Pop(priorityQueue);
                        break;
                    case "Insert":
                        String s = scanner.next();
                        String regex = "(\\d+)\\+i(\\d+)";
                        Pattern pattern = Pattern.compile(regex);
                        Matcher matcher = pattern.matcher(s);
                        while (matcher.find()){
                            int x = Integer.parseInt(matcher.group(1));
                            int y = Integer.parseInt(matcher.group(2));
                            Insert(priorityQueue,x,y);
                        }
                        break;
                }
            }
        }
        scanner.close();
        System.exit(0);
    }
}
