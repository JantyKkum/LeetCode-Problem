package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: DFS
 * @date: 2023/2/4 8:22
 * @description: POJ：http://poj.org/problem?id=2488
 */
public class Ch9_3_AKnightsJourney {
    //定义全局变量
    static int MAXN = 26 + 4;
    static boolean[][] visited = new boolean[MAXN][MAXN];
    static int[][] route = {{-1,-2},{1,-2},{-2,-1},{2,-1},{-2,1},{2,1},{-1,2},{1,2}};

    public static boolean dfs(int x, int y, String ans, int step, int p, int q){
        if(step == p * q){                         //递归出口
            System.out.println(ans +"\n");
            return true;
        }
        for (int i = 0; i < 8; ++i) {
            int newx = x + route[i][0];
            int newy = y + route[i][1];
            if(newx < 0  || newx >= p || newy < 0  || newy >= q || visited[newx][newy]){        //若越界或者访问过，跳过此次
                continue;
            }
            char pointx = (char)(newx + '1');
            char pointy = (char)(newy + 'A');
            visited[newx][newy] = true;
            if(dfs(newx,newy,ans+pointy+pointx,step+1,p,q)){
                return true;
            }
            visited[newx][newy] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            visited = new boolean[MAXN][MAXN];
            visited[0][0] = true;
            System.out.println("Scenario #"+(i+1)+":");
            if(!dfs(0,0,"A1",1,p,q)) {
                System.out.println("impossible\n");
            }
        }
        scanner.close();
        System.exit(0);
    }
}
