  /**
An array is monotonic if it is either monotone increasing or monotone 
decreasing. 

 An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An 
array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j]. 

 Given an integer array nums, return true if the given array is monotonic, or 
false otherwise. 

 
 Example 1: 

 
Input: nums = [1,2,2,3]
Output: true
 

 Example 2: 

 
Input: nums = [6,5,4,4]
Output: true
 

 Example 3: 

 
Input: nums = [1,3,2]
Output: false
 

 
 Constraints: 

 
 1 <= nums.length <= 10⁵ 
 -10⁵ <= nums[i] <= 10⁵ 
 

 Related Topics 数组 👍 178 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import java.util.Date;
  import java.util.HashSet;
  import java.util.Objects;

  public class MonotonicArray{
      public static void main(String[] args) {
          HashSet<Employee> set = new HashSet<>();
          set.add(new Employee("tom1",32,new MyDate(1980,8,8)));
          set.add(new Employee("tom2",24,new MyDate(1970,10,30)));
          set.add(new Employee("tom3",29,new MyDate(1990,2,4)));
          set.add(new Employee("tom3",29,new MyDate(1990,2,4)));
          System.out.println(set);


      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean ans1 = true,ans2 = true;
        if(nums.length <= 2){
            return true;
        }
        //假设递增
        if(nums[0] < nums[nums.length-1]){
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] > nums[i+1]){
                    return false;
                }
            }
            return true;
        }else if(nums[0] > nums[nums.length-1]){
                for (int i = 0; i < nums.length-1; i++) {
                    if(nums[i] < nums[i+1]){
                        return false;
                    }
                }
                return true;
        }else{
            for (int i = 0; i < nums.length-1; i++) {
                if(nums[i] != nums[i+1]){
                    return false;
                }
            }
            return true;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)


      public static class Employee{
          String name;
          int age;
          MyDate birthday;

          @Override
          public String toString() {
              return "Employee{" +
                      "name='" + name + '\'' +
                      ", age=" + age +
                      ", birthday=" + birthday +
                      '}';
          }

          public Employee(String name, int age, MyDate birthday) {
              this.name = name;
              this.age = age;
              this.birthday = birthday;
          }

          @Override
          public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              Employee employee = (Employee) o;
              return age == employee.age && Objects.equals(name, employee.name) && Objects.equals(birthday, employee.birthday);
          }

          @Override
          public int hashCode() {
              return Objects.hash(name, age, birthday);
          }

          public MyDate getBirthday() {
              return birthday;
          }

          public void setBirthday(MyDate birthday) {
              this.birthday = birthday;
          }

          public Employee(String name, int age) {
              this.name = name;
              this.age = age;
          }

          public String getName() {
              return name;
          }

          public void setName(String name) {
              this.name = name;
          }

          public int getAge() {
              return age;
          }

          public void setAge(int age) {
              this.age = age;
          }

      }

      public static class MyDate{
          int year;
          int month;
          int day;

          public MyDate(int year, int month, int day) {
              this.year = year;
              this.month = month;
              this.day = day;
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
          public String toString() {
              return "MyDate{" +
                      "year=" + year +
                      ", month=" + month +
                      ", day=" + day +
                      '}';
          }

          @Override
          public boolean equals(Object o) {
              if (this == o) return true;
              if (o == null || getClass() != o.getClass()) return false;
              MyDate myDate = (MyDate) o;
              return year == myDate.year && month == myDate.month && day == myDate.day;
          }

          @Override
          public int hashCode() {
              return Objects.hash(year, month, day);
          }
      }

  }