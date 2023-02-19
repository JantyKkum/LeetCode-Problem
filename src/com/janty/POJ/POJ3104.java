package com.janty.POJ;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author 简义涛
 * @version V1.0
 */
public class POJ3104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ans = 0;
        int n = scanner.nextInt();                    //n输入
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {      //大根堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < n; i++) {                 //录入n件衣服
            queue.add(scanner.nextInt());
        }
        int k = scanner.nextInt();                    //n输入

        //如果衣服水量低于n-1，最后选择时会自然风干
        while (!queue.isEmpty()) {
            if (queue.peek() >= k) {                    //当衣服含水量多于k时，烘干最多的衣服并放入大根堆
                queue.add(queue.poll() - k);
            } else {
                queue.poll();                         //当衣服含水量小于k时，移出此件衣服
            }                                         //一次处理完成后，所有元素水量-1
            PriorityQueue<Integer> temp = new PriorityQueue<>(new Comparator<Integer>() {      //大根堆
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
            while (!queue.isEmpty()) {
                if (queue.peek() > 1) {
                    temp.add(queue.poll() - 1);         //当衣服含水量小于k时，不加入此件衣服
                } else {
                    break;
                }
            }
            queue = temp;
            ans++;
        }
        System.out.println(ans);
    }
}
