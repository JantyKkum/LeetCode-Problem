  /**
You are given an array of strings tokens that represents an arithmetic
expression in a Reverse Polish Notation.

 Evaluate the expression. Return an integer that represents the value of the
expression.

 Note that:


 The valid operators are '+', '-', '*', and '/'.
 Each operand may be an integer or another expression.
 The division between two integers always truncates toward zero.
 There will not be any division by zero.
 The input represents a valid arithmetic expression in a reverse polish
notation.
 The answer and all the intermediate calculations can be represented in a 32-
bit integer.



 Example 1:


Input: tokens = ["2","1","+","3","*"]
Output: 9
Explanation: ((2 + 1) * 3) = 9


 Example 2:


Input: tokens = ["4","13","5","/","+"]
Output: 6
Explanation: (4 + (13 / 5)) = 6


 Example 3:


Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
Output: 22
Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
= ((10 * (6 / (12 * -11))) + 17) + 5
= ((10 * (6 / -132)) + 17) + 5
= ((10 * 0) + 17) + 5
= (0 + 17) + 5
= 17 + 5
= 22



 Constraints:


 1 <= tokens.length <= 10⁴
 tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the
range [-200, 200].


 Related Topics 栈 数组 数学 👍 657 👎 0

*/

  package com.jianyitao.leetcode.editor.cn;

  import java.util.Arrays;
  import java.util.Scanner;
  import java.util.Stack;

  public class EvaluateReversePolishNotation{
      public static void main(String[] args) {
          Scanner scanner = new Scanner(System.in);
          int n = scanner.nextInt(),count = 0;

          Student studentLow = new Student(null, 1814, 9, 6);
          Student studentHigh = new Student(null, 2014, 9, 6);
          Student studentMin = studentHigh,studentMax = studentLow;
          for (int i = 0; i < n; i++) {
              String name = scanner.next();
              String s = scanner.next();
              int year = Integer.valueOf(s.substring(0, 4));
              int month = Integer.valueOf(s.substring(5, 7));
              int date = Integer.valueOf(s.substring(8, 10));
              Student student = new Student(name, year, month, date);
              if(bigThan(student,studentLow) && smallThan(student,studentHigh)){
                  count++;
                  if(bigThan(student,studentMax)) studentMax=student;
                  if(smallThan(student,studentMin)) studentMin=student;
              }
          }
          System.out.println(count+" "+ studentMin.name+" "+studentMax.name);


          System.exit(0);

      }

      public static boolean bigThan(Student s1,Student s2){
          if(s1.year != s2.year) {
              return (s1.year >= s2.year);
          }else if(s2.month != s2.month) {
              return (s1.month >= s2.month);
          }else {
              return (s1.date >= s2.date);
          }
      }

      public static boolean smallThan(Student s1,Student s2){
          if(s1.year != s2.year) {
              return (s1.year <= s2.year);
          }else if(s2.month != s2.month) {
              return (s1.month <= s2.month);
          }else {
              return (s1.date <= s2.date);
          }
      }

      static class Student{
          String name;
          int year;
          int month;
          int date;

          public Student(String name, int year, int month, int date) {
              super();
              this.name = name;
              this.year = year;
              this.month = month;
              this.date = date;
          }

      }




      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0,a,b;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i =0; i < tokens.length; i++) {
            if(isNumber(tokens[i])){      //操作数
                stack.push(Integer.valueOf(tokens[i]));
            }else if(tokens[i].equals("+")){                                  //操作符
                a = stack.pop();
                b = stack.pop();
                stack.push(b+a);
            }else if(tokens[i].equals("-")){                                  //操作符
                a = stack.pop();
                b = stack.pop();
                stack.push(b-a);
            }else if(tokens[i].equals("*")){                                  //操作符
                a = stack.pop();
                b = stack.pop();
                stack.push(b*a);
            }else if(tokens[i].equals("/")){                                  //操作符
                a = stack.pop();
                b = stack.pop();
                stack.push(b/a);
            }
        }
        return stack.pop();
    }

    public boolean isNumber(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")){
            return false;
        }else {
            return true;
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }