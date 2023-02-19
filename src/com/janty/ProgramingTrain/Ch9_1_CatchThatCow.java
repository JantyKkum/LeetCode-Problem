package com.janty.ProgramingTrain;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: Ch9.1 BFS
 * @date: 2023/2/3 9:18
 * @description: OJ:http://poj.org/problem?id=3278
 */
public class Ch9_1_CatchThatCow {
    static class Route{
        int n;
        int time;

        public Route() {
        }

        public Route(int n, int time) {
            this.n = n;
            this.time = time;
        }

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }
    }

    static int MAXN = 100005;

    static int dfs(int n ,int k){
        Queue<Route> queue = new LinkedList<Route>();
        boolean[] visited = new boolean[MAXN];
        queue.add(new Route(n,0));     //初始状态入队列
        while (!queue.isEmpty()){
            Route temp = queue.poll();
            if(temp.n == k){
                return temp.time;
            }else {
                if(temp.n-1 >= 0 && !visited[temp.n-1]){
                    queue.add(new Route(temp.n-1,temp.time+1));     //当前节点不满足时，搜索树的分支，分别入队列
                    visited[temp.n-1] = true;
                }
                if(temp.n+1 < MAXN && !visited[temp.n+1]) {
                    queue.add(new Route(temp.n+1,temp.time+1));
                    visited[temp.n+1] = true;
                }
                if(temp.n*2 < MAXN && !visited[temp.n*2]){
                    queue.add(new Route(temp.n*2,temp.time+1));
                    visited[temp.n*2] = true;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();


        System.out.println(dfs(n,k));
    }
}
