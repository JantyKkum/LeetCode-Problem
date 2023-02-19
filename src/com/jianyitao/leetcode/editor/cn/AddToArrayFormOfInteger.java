  /**
The array-form of an integer num is an array representing its digits in left to 
right order. 

 
 For example, for num = 1321, the array form is [1,3,2,1]. 
 

 Given num, the array-form of an integer, and an integer k, return the array-
form of the integer num + k. 

 
 Example 1: 

 
Input: num = [1,2,0,0], k = 34
Output: [1,2,3,4]
Explanation: 1200 + 34 = 1234
 

 Example 2: 

 
Input: num = [2,7,4], k = 181
Output: [4,5,5]
Explanation: 274 + 181 = 455
 

 Example 3: 

 
Input: num = [2,1,5], k = 806
Output: [1,0,2,1]
Explanation: 215 + 806 = 1021
 

 
 Constraints: 

 
 1 <= num.length <= 10⁴ 
 0 <= num[i] <= 9 
 num does not contain any leading zeros except for the zero itself. 
 1 <= k <= 10⁴ 
 

 Related Topics 数组 数学 👍 221 👎 0

*/
  
  package com.jianyitao.leetcode.editor.cn;

  import com.janty.test.Cat;

  import java.io.*;
  import java.lang.reflect.InvocationTargetException;
  import java.lang.reflect.Method;
  import java.util.ArrayList;
  import java.util.Collections;
  import java.util.List;

  public class AddToArrayFormOfInteger{
      public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
          Solution solution = new AddToArrayFormOfInteger().new Solution();
            m1();
            m2();
            m3();
      }

      public static void m1() {
          Cat cat = new Cat();
          long start = System.currentTimeMillis();
          for (int i = 0; i < 900000000; i++) {
//              cat.hi();
          }
          long end = System.currentTimeMillis();
          System.out.println("m1() 耗时=" + (end - start));
      }

      //二、反射机制调用方法 hi
      public static void m2() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
              NoSuchMethodException, InvocationTargetException {
          Class cls = Class.forName("com.janty.test.Cat");
          Object o = cls.newInstance();
          Method hi = cls.getMethod("hi");
          long start = System.currentTimeMillis();
          for (int i = 0; i < 900000000; i++) {
              hi.invoke(o);//反射调用方法
          }
          long end = System.currentTimeMillis();
          System.out.println("m2() 耗时=" + (end - start));
      }
          //三、反射调用优化 + 关闭访问检查
          public static void m3() throws ClassNotFoundException, IllegalAccessException, InstantiationException,
                  NoSuchMethodException, InvocationTargetException {
              Class cls = Class.forName("com.janty.test.Cat");
              Object o = cls.newInstance();
              Method hi = cls.getMethod("hi");
              hi.setAccessible(true);//在反射调用方法时， 取消访问检查
              long start = System.currentTimeMillis();
              for (int i = 0; i < 900000000; i++) {
                  hi.invoke(o);//反射调用方法
              }
              long end = System.currentTimeMillis();
              System.out.println("m3() 耗时=" + (end - start));
          }

      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> ans = new ArrayList<>();
        int carry = 0,tempa,tempb,j=k,count =0;
        while( j /10 != 0){
            tempb = j % 10;
            j /= 10;
            count++;
        }
        //ans 数组最大长度为max+1
        int n =Math.max(count+1,num.length);
        for (int i = 0; i < n; i++) {
            if(i < num.length){        //a的长度范围内读取a的数值位
                tempa = num[num.length-i-1];
            }else{
                tempa = 0;
            }

            if(i < count+1){        //b的长度范围内读取b的数值位
                tempb = k % 10;
                k /= 10;
            }else{
                tempb = 0;
            }

            ans.add((tempa+tempb+carry)%10);
            carry = ((tempa+tempb+carry)/10);
        }

        if(carry == 1){
            ans.add(1);
        }
        Collections.reverse(ans);
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }