package com.janty.ProgramingTrain;

import java.util.Arrays;

/**
 * @author 简义涛
 * @version V1.0
 */
public class Ch7_3_SeniorsGun {
    public static void main(String[] args) {
        int[] a ={5,2,5,8,43,21,6,1};
        Arrays.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
