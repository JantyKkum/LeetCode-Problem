/**
 * Given a string s, check if it can be constructed by taking a substring of it
 * and appending multiple copies of the substring together.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: s = "abab"
 * Output: true
 * Explanation: It is the substring "ab" twice.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * <p>
 * Input: s = "aba"
 * Output: false
 * <p>
 * <p>
 * Example 3:
 * <p>
 * <p>
 * Input: s = "abcabcabcabc"
 * Output: true
 * Explanation: It is the substring "abc" four times or the substring "abcabc"
 * twice.
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * <p>
 * 1 <= s.length <= 10⁴
 * s consists of lowercase English letters.
 * <p>
 * <p>
 * Related Topics 字符串 字符串匹配 👍 856 👎 0
 */

package com.jianyitao.leetcode.editor.cn;


import java.util.*;
import java.util.Map;

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        News news = new News();
        System.out.println(news.getTitle());
        A a = new A();
        a.play();

        Employee e1 = new Employee("tom", 2000, new MyDate(1990, 7, 8));
        Employee e2 = new Employee("bom", 2000, new MyDate(1990, 7, 8));
        Employee e3= new Employee("bill", 3000, new MyDate(1980, 9, 8));
        Employee e4 = new Employee("bill", 6000, new MyDate(1950, 9, 8));
        Employee e5 = new Employee("hank", 4000, new MyDate(1970, 2, 8));
        ArrayList<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        list.add(e5);
        System.out.println("===排序前===");
        for (Employee e : list) {
            System.out.println(e);
        }

        list.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getName() != e2.getName()){
                    return e1.getName().compareTo(e2.getName());
                }else
                    return e1.birthday.compareTo(e2.birthday);
            }

        });
        System.out.println("===排序后===");
        for (Employee e : list) {
        System.out.println(e);
    }


}
    static class A{
        void play(){}
    }
    class B{
        void play(){}
    }

    public static class Car {
        String name;
        int price;

        public Car(String name, int price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    public static class News {
        String title = "TITLE123";
        String content;

        public News() {
        }
        public News(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "News{" + "title='" + title + '}';
        }
    }

    public static class Employee {
        String name;
        double salary;
        MyDate birthday;

        @Override
        public String toString() {
            return "Employee{" +
                    "name='" + name + '\'' +
                    ", salary=" + salary +
                    ", birthday=" + birthday +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }

        public MyDate getBirthday() {
            return birthday;
        }

        public void setBirthday(MyDate birthday) {
            this.birthday = birthday;
        }

        public Employee(String name, double salary, MyDate birthday) {
            this.name = name;
            this.salary = salary;
            this.birthday = birthday;
        }
    }

    public static class MyDate implements Comparable<MyDate>{
        int year;
        int month;
        int day;

        public MyDate(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public String toString() {
            return "MyDate{" +
                    "year=" + year +
                    ", month=" + month +
                    ", day=" + day +
                    '}';
        }

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }


        @Override
        public int compareTo(MyDate o) {
            if(year != o.getYear()){
                return year-o.getYear();
            }else{
                if(month!= o.getMonth())
                    return month-o.getMonth();
                else
                    return day-o.getDay();
            }
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            int n = s.length();
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < n / i; j++) {
                        sb.append(s.substring(0, i));
                    }
                    if (sb.toString().equals(s)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)




}


