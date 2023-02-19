package com.janty.ProgramingTrain;

import java.util.*;

/**
 * @author: Janty
 * @projectName: 拓扑排序
 * @date: 2023/2/9 8:57
 * @description:
 */
public class Ch11_9_ContestOrder {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Integer>[] graph= new Vector[n];   //角标+1 = 真实点的序号
        for (int i = 0; i < n; i++) {
            graph[i] = new Vector<>();
        }
        int[] inDegree = new int[n];
        for (int i = 0; i < m; i++) {           //添加m行数据
            int num1 = scanner.nextInt();       //方向为num1->num2
            int num2 = scanner.nextInt();
            graph[num1-1].add(num2-1);
            inDegree[num2-1]++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if(inDegree[i] == 0) queue.add(i);
        }
        while (!queue.isEmpty()){
            Integer u = queue.poll();
            System.out.print(u+1 +" ");
            for (int i = 0; i < graph[u].size(); i++) {   //移出节点后相关节点入度-1
                Integer v = graph[u].get(i);
                inDegree[v] --;
                if(inDegree[v] == 0) queue.add(v);
            }
        }
    }
}
