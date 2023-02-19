package com.janty.ProgramingTrain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 最小生成树
 * @date: 2023/2/7 10:48
 * @description: 牛客网：https://www.nowcoder.com/practice/d6bd75dbb36e410995f8673a6a2e2229?tpId=63&tqId=29595&tPage=2&ru=/kaoyan/retest/9001&qru=/ta/zju-kaoyan/question-ranking
 */
public class Ch11_4_SmoothTraffic {
    //定义边的结构体
    static class Edge{
        int x;
        int y;
        int dis;

        public Edge() {
        }

        public Edge(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }

    static int MAXN = 100+10;
    static int[] arr = new int[MAXN];
    static int[] height = new int[MAXN];

    //初始化方法
    public static void initial(int n){
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
            height[i] = 0;
        }
    }

    //find方法
    public static int find(int i){
        if(arr[i] != i){
            arr[i] = find(arr[i]);
        }
        return arr[i];
    }

    //Union方法
    public static void union(int i ,int j){
        i = find(i);
        j = find(j);
        if(i != j){                 //不属于同一集合时才合并
            if(height[i] > height[j]){
                arr[j] = i;
            }else if(height[i] < height[j]){
                arr[i] = j;
            }else {
                arr[i] = j;
                height[j]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();                          //n个顶点
            int m = n*(n-1)/2;                                  //m条边
            if (n==0) break;
            Edge[] edges = new Edge[m];
            for (int i = 0; i < m; i++) {                       //扫描添加至边的数组
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int dis = scanner.nextInt();
                edges[i] = new Edge(x,y,dis);
            }
            Arrays.sort(edges, new Comparator<Edge>() {         //按距离从小至大进行排序
                @Override
                public int compare(Edge o1, Edge o2) {
                    return o1.dis - o2.dis;
                }
            });

            initial(n);
            int ans = 0;
            for (int i = 0; i < m; i++) {
                if(find(edges[i].x) != find(edges[i].y)){       //不在同一集合，即加入
                    union(edges[i].x,edges[i].y);
                    ans += edges[i].dis;
                }
            }
            System.out.println(ans);
        }
        scanner.close();
        System.exit(0);
    }
}
