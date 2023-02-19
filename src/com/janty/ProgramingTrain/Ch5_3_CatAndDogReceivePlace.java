package com.janty.ProgramingTrain;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 简义涛
 * @version V1.0
 */
class Animal{
    int num;
    int order;

    public Animal(int num, int order) {
        this.num = num;
        this.order = order;
    }
}

public class Ch5_3_CatAndDogReceivePlace {

    static Queue<Animal> queueCat = new LinkedList<>();
    static Queue<Animal> queueDog = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),count = 0;

        for (int i = 0; i < n; i++) {
            int op = scanner.nextInt();
            int category = scanner.nextInt();
            if(op == 1){                        //表示动物进入收容所
                if(category > 0) {
                    Animal animal = new Animal(category, count++);
                    queueDog.add(animal);
                }
                if(category < 0) {
                    Animal animal = new Animal(category, count++);
                    queueCat.add(animal);
                }
            }else{                              //表示动物呗收养
                switch (category){
                    case 1:                 //收养狗
                        System.out.print(queueDog.poll().num + " ");
                    case -1:                //收养猫
                        System.out.print(queueCat.poll().num + " ");
                    case 0:                 //不指定收养
                        if(queueCat.isEmpty() || queueCat.peek().order > queueDog.peek().order){
                            System.out.print(queueDog.poll().num + " ");
                        }else{
                            System.out.print(queueCat.poll().num + " ");
                        }
                }

            }
        }
    }
}


