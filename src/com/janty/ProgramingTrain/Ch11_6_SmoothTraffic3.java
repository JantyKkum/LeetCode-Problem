package com.janty.ProgramingTrain;

import java.util.*;
import java.util.stream.StreamSupport;

/**
 * @author: Janty
 * @projectName: 最短路径 Dijkstra (有难度)
 * @date: 2023/2/8 9:33
 * @description: http://acm.hdu.edu.cn/   第1874题
 */
public class Ch11_6_SmoothTraffic3 {
    static int MAXN = 200+10;       //顶点数的最大值
    static int MAXM = 1000+10;      //边数的最大值

    //邻接表的“边”结构体
    static class Edge{
        int to;
        int distance;

        public Edge() {
        }

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    //邻接表的“表”（用数组来定义）,拉链用向量链表定义
    static List<Edge>[] graph = new Vector[MAXN];          //图的定义
    static int[] dis = new int[MAXN];                      //各点到起点的距离

    //定义可选的点相关信息的结构体
    static class Point{
        int number;
        int distance;

        public Point(int number, int distance) {
            this.number = number;
            this.distance = distance;
        }
    }

    public static void Dijkstra(int start){
        PriorityQueue<Point> queue = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.distance - o2.distance;
            }
        });
        dis[start] = 0;
        queue.add(new Point(start,dis[start]));
        while (!queue.isEmpty()){
            int u = queue.poll().number;                //最近的点
            for (int i = 0; i < graph[u].size(); i++) {    //从图中扫描u能到达的每一个点
                int v = graph[u].get(i).to;
                int d = graph[u].get(i).distance;
                if(dis[v] > dis[u]+d){
                    dis[v] = dis[u] +d;
                    queue.add(new Point(v,dis[v]));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            Arrays.fill(dis,Integer.MAX_VALUE);     //全局变量初始化
            for (int i = 0; i < graph.length; i++) {
                graph[i] = new Vector<Edge>();
            }
            while (m-->0){
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                int distance = scanner.nextInt();
                graph[from].add(new Edge(to,distance));
                graph[to].add(new Edge(from,distance));
            }
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            Dijkstra(start);
            if(dis[end] == Integer.MAX_VALUE) dis[end] = -1;
            System.out.println(dis[end]);
        }
        scanner.close();
        System.exit(0);
    }
}
