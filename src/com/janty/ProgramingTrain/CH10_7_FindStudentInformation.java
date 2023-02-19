package com.janty.ProgramingTrain;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author: Janty
 * @projectName: 散列表
 * @date: 2023/2/7 8:59
 * @description: 牛客网：https://www.nowcoder.com/practice/fe8bff0750c8448081759f3ee0d86bb4?tpId=60&tqId=29499&tPage=2&ru=/kaoyan/retest/1001&qru=/ta/tsing-kaoyan/question-ranking
 */
public class CH10_7_FindStudentInformation {
    //定义学生类
    static class Student{
        String name;
        String gender;
        int age;

        public Student() {
        }

        public Student(String name, String gender, int age) {
            this.name = name;
            this.gender = gender;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Student> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();              //n行输入学生信息
        while (n-- >0){
            String num = scanner.next();
            String name = scanner.next();
            String gender = scanner.next();
            int age = scanner.nextInt();
            map.put(num,new Student(name,gender,age));
        }
        int m = scanner.nextInt();              //m行查询学生信息
        while (m-- >0){
            String num = scanner.next();
            if(map.get(num) != null){
                Student temp = map.get(num);
                System.out.println(num + " "+ temp.name + " "+ temp.gender + " "+ temp.age);
            }else {
                System.out.println("No Answer!");
            }
        }
    }
}
