package com.janty.ProgramingTrain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 简义涛
 * @version V1.0
 */
public class Ch7_2_FatMouseTrade {
    public static class JavaBeansChoose{
        int fatMouseFood;
        int javaBeans;

        public JavaBeansChoose() {
        }

        public JavaBeansChoose(int fatMouseFood, int javaBeans) {
            this.fatMouseFood = fatMouseFood;
            this.javaBeans = javaBeans;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            if (m != -1 && n != -1){
                JavaBeansChoose[] chooses = new JavaBeansChoose[n];
                for (int i = 0; i < n; i++) {
                    int f = scanner.nextInt();          //FatMouseFood
                    int j = scanner.nextInt();          //JavaBeans
                    chooses[i] = new JavaBeansChoose(f,j);
                }
                Arrays.sort(chooses, new Comparator<JavaBeansChoose>() {
                    @Override
                    public int compare(JavaBeansChoose o1, JavaBeansChoose o2) {
                        return (o1.fatMouseFood/ o1.javaBeans) - (o2.fatMouseFood/ o2.javaBeans);
                    }
                });

                double leftMoney = m;
                double acquiredFood = 0;
                for (int j = 0; j < n; j++) {
                    if(chooses[j].javaBeans >= leftMoney){      //此次花费多余剩余钱时，直接return
                        acquiredFood += leftMoney * chooses[j].fatMouseFood / chooses[j].javaBeans ;
                        System.out.printf("%.3f", acquiredFood);
                        break;
                    }else{
                        leftMoney -= chooses[j].javaBeans;
                        acquiredFood += chooses[j].fatMouseFood;
                        j++;
                    }
                }

            }else{
                System.out.println("exit");
                break;
            }
        }
    }
}
//
//    int[] j = new int[n];               //JavaBeans
//    int[] f = new int[n];               //FatMouseFood
//            for (int i = 0; i < n; i++) {
//        j[i] = scanner.nextInt();
//        f[i] = scanner.nextInt();
//        }
