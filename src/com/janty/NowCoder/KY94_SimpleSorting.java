package com.janty.NowCoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author: Janty
 * @projectName: LeetCode-Problem
 * @date: 2023/2/17 9:59
 * @description:
 */
public class KY94_SimpleSorting {

    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()){
//            int n = scanner.nextInt();
//            Set<Integer> set = new HashSet<>();
//            for (int i = 0; i < n; i++) {
//                int temp = scanner.nextInt();
//                set.add(temp);
//            }
//            Integer[] arr = new Integer[set.size()];
//            int count = 0;
//            for (Integer integer : set) {
//                arr[count++] = integer;
//            }
//            Arrays.sort(arr);
//            for (int i = 0; i < arr.length; i++) {
//                System.out.print(arr[i] + " ");
//            }
//            System.out.println();
//        }
//        scanner.close();
//        System.exit(0);



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sNum ;
        while ( (sNum = br.readLine()) != null){
            int n = Integer.parseInt(sNum);
            Set<Integer> set = new HashSet<>();
            String[] strs = br.readLine().split(" ");
            for (int i = 0; i < strs.length; i++) {
                int temp = Integer.parseInt(strs[i]);
                set.add(temp);
            }
            Integer[] arr = new Integer[set.size()];
            int count = 0;
            for (Integer integer : set) {
                arr[count++] = integer;
            }
            Arrays.sort(arr);
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
        br.close();
        System.exit(0);
    }
}
