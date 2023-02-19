package com.janty.NowCoder;

import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/16 8:59
 * @description: 牛客网：https://www.nowcoder.com/practice/071f1acaada4477f94193f8c0b9054f4?tpId=62&tPage=1&ru=%2Fkaoyan%2Fretest%2F2002&qru=%2Fta%2Fsju-kaoyan%2Fquestion-ranking&difficulty=&judgeStatus=&tags=&title=&sourceUrl=&gioEnter=menu
 */
public class KY92_QuadraticEquationCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String originS = scanner.next();
            String[] s = originS.split("=");
            String[] split1 = s[0].split("[+]");
            String[] split2 = s[1].split("[+]");
            double a = 0,b = 0,c = 0,ans;
            for (int i = 0; i < split1.length; i++) {
                int index1 = split1[i].indexOf("x^2");
                if(index1 != -1){                   //为2次方
                    if(index1 == 0) a += 1;
                    else a += Double.parseDouble(split1[i].substring(0,index1));
                }else{
                    int index2 = split1[i].indexOf("x");
                    if(index2 != -1){               //为1次方
                        if(index2 == 0) b += 1;
                        else b += Double.parseDouble(split1[i].substring(0,index2));
                    }else {                         //为0次方
                        c += Double.parseDouble(split1[i]);
                    }
                }
            }
            for (int i = 0; i < split2.length; i++) {
                int index1 = split2[i].indexOf("x^2");
                if(index1 != -1){                   //为2次方
                    if(index1 == 0) a -= 1;
                    else a -= Double.parseDouble(split2[i].substring(0,index1));
                }else{
                    int index2 = split2[i].indexOf("x");
                    if(index2 != -1){               //为1次方
                        if(index2 == 0) b -= 1;
                        else b -= Double.parseDouble(split2[i].substring(0,index2));
                    }else {                         //为0次方
                        c -= Double.parseDouble(split2[i]);
                    }
                }
            }
            double delta = b * b - 4 * a * c;
            if(delta < 0){
                System.out.println("No Solution");
            }else if(delta == 0f){
                System.out.printf("%.2f\n",- b / 2 / a);
            }else {
                System.out.printf("%.2f ",(- b - Math.sqrt(delta))/ 2 / a);
                System.out.printf("%.2f\n",(- b + Math.sqrt(delta))/ 2 / a);
            }
        }
    }
}
