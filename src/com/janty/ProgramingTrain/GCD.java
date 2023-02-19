package com.janty.ProgramingTrain;

import java.util.Scanner;

/**
 * @author 简义涛
 * @version V1.0
 */
public class GCD {
    //最大公约数
    int GCD(int a, int b){      //GCD(a,b) = GCD(b, (a mod b)))
//        int r;                  //a mod b
//        r = a > b ?  a % b : b % a;
        if(b == 0){
            return  a;
        }else {
            return GCD(b, (a % b));
        }
    }

    public static void main(String[] args) {

    }
}
