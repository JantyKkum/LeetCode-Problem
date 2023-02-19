package com.janty.NowCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 字符串匹配
 * @date: 2023/2/16 8:37
 * @description: 牛客网：https://www.nowcoder.com/practice/00438b0bc9384ceeb65613346b42e88a?tpId=62&tqId=29448&tPage=1&ru=/kaoyan/retest/2002&qru=/ta/sju-kaoyan/question-ranking
 */
public class KY91_StringMatching {

    public static void main(String[] args) throws IOException {
        //方法一：调库
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String t = scanner.next();
            String p = scanner.next();
            int n = t.length(), m = p.length(), ans = 0;
            for (int i = 0; i <= n-m; i++) {
                if(t.substring(i,i + m).equals(p)) ans++;
            }
            System.out.println(ans);
        }
        scanner.close();
        System.exit(0);

        //方法二：优化的算法
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s =br.readLine().split(" ");
        char text[]=s[0].toCharArray();
        char pattern[]=s[1].toCharArray();

        int len1=text.length;
        int len2=pattern.length;
        int len=len1-len2;
        boolean flag;
        int count=0;

        for(int i=0;i<=len;++i) {
            flag=true;
            for(int j=0;j<len2;++j) {
                if(text[i+j]!=pattern[j]) {
                    flag=false;
                    break;
                }
            }
            if(flag)count++;
        }
        System.out.print(count);
    }


}
