package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author 简义涛
 * @version V1.0
 */
public class KMP_ {
    //定义全局变量：next数组
    static int[] next = new int[100];

    //求解next数组方法
    static void findNext(String p) {
        int m = p.length();
        int j = 0; 							//模式串指针
        next[j] = -1;
        int t = next[j];
        while(j<m) {
            if(t == -1 || p.charAt(t) == p.charAt(j)) {
                t++;
                j++;
                next[j] = t;
            }else {
                t = next[t];
            }
        }
    }

    //KMP主方法
    static int KMP(String s, String p) {
        findNext(p);						//调用findNext
        int n = s.length(), m = p.length();
        int i = 0; 							//主串指针
        int j = 0; 							//模式串指针
        while(i<n && j<m) {
            if(j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }else {
                j = next[j];
            }
        }
        if(j == m) {
            return i-j;
        }else {
            return -1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        String p= scanner.nextLine();
        System.out.println(KMP(s,p));
    }

}
