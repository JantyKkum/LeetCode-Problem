package com.janty.PAT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 贪心
 * @date: 2023/2/15 8:45
 * @description: PAT: https://pintia.cn/problem-sets/994805260223102976/exam/problems/994805301562163200
 */
public class B1020_MoonCake {
    static class MoonCake{
        Double price;
        Double amount;
        Double avg;

        public MoonCake(Double price, Double amount, Double avg) {
            this.price = price;
            this.amount = amount;
            this.avg = avg;
        }
    }

    public static void main(String[] args) {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int d = scanner.nextInt();
        MoonCake[] moonCakes = new MoonCake[n];
        Double[] amounts = new Double[n];
        Double[] prices = new Double[n];
        for (int i = 0; i < n; i++) {
            amounts[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            prices[i] = scanner.nextDouble();
        }
        for (int i = 0; i < n; i++) {
            moonCakes[i] = new MoonCake(prices[i],amounts[i],prices[i]/amounts[i]);
        }
        Arrays.sort(moonCakes, new Comparator<MoonCake>() {
            @Override
            public int compare(MoonCake o1, MoonCake o2) {
                return o2.avg.compareTo(o1.avg);
            }
        });
        double sumAmount = 0,sumPrice = 0;
        for (int i = 0; i < n; i++) {
            if(sumAmount + moonCakes[i].amount < d){
                sumAmount += moonCakes[i].amount;
                sumPrice += moonCakes[i].price;
            }else {
                sumPrice += (d - sumAmount) * (moonCakes[i].avg);
                break;
            }
        }
        System.out.printf("%.2f\n",sumPrice);
        scanner.close();
        System.exit(0);
    }
}